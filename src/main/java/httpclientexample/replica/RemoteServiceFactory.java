package httpclientexample.replica;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

import java.util.Optional;

public class RemoteServiceFactory {
    static String cfdServiceURL = getSystemProperty("CFD-SERVICE-URL", "http://localhost:8080/cfd-services/");
    static String cfdServiceUser = getSystemProperty("CFD-SERVICE-USER", "sa");
    static String cfdServicePW = getSystemProperty("CFD-SERVICE-PW", "sa");
    private Optional<ResteasyWebTarget> webTarget = Optional.empty();

    public <T> T createWebService(Class<T> interfaceClass) {
        if (!webTarget.isPresent()) {
            HttpClient httpClient = HttpClientBuilder.create()
                    .setDefaultCookieStore(SessionManager.INSTANCE.getHttpCookieStore()).build();
            ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
            ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
            webTarget = Optional.of(client.target(cfdServiceURL));
        }
        return webTarget.map(resteasyWebTarget -> resteasyWebTarget.proxy(interfaceClass)).orElse(null);
    }

    static String getSystemProperty(String propertyKey, String defaultValue) {
        String urlProperty = System.getProperty(propertyKey);
        return urlProperty != null ? urlProperty : defaultValue;
    }

}