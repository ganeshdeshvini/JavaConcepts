package httpclientexample.restclient;

import httpclientexample.IUnitUnderTestSearchWebService;
import httpclientexample.PartSearchResultDTO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpClientFormBasedAuthenticationProgramaticallyCookieStoreJSessionIDUsingRestEasy {
    static String FORM_AUTH_URL = "http://localhost:8080/cfd-services/j_security_check";
    static String MEASUREMENT_URL = "http://localhost:8080/cfd-services/rest-api/measurements";
    static String PART_SEARCH_URL = "http://localhost:8080/cfd-services/rest-api/searchPart/A";
    static String CFD_SERVICE_URL = "http://localhost:8080/cfd-services/";
    static CookieStore httpCookieStore;

    public static void main(String[] args) {
        httpCookieStore = new BasicCookieStore();

        executeFormBasedLoginProgramatically();
//        executeWithRestEasy();
                executeWithRestEasyWithProxy();
        //        executeWithRestEasyWithCookieStore();
        //        executeWithRestEasyHeader();
    }

    static String getCookieForHeader() {
        return httpCookieStore.getCookies().get(0).getName() + "=" +
                httpCookieStore.getCookies().get(0).getValue();
    }

    static String getCookieName() {
        return httpCookieStore.getCookies().get(0).getName();
    }

    static String getCookieValue() {
        return httpCookieStore.getCookies().get(0).getValue();
    }

    static void executeFormBasedLoginProgramatically() {
        try {
            String userName = "sa";
            String password = "sa";
            HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).build();
            HttpPost post = new HttpPost(FORM_AUTH_URL);
            //            HttpPost post = new HttpPost("http://localhost:8080/j_security_check");
            //            post = new HttpPost("http://localhost:8080/cfd-services/rest-api/measurements");
            //
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("j_username", userName));
            nameValuePairs.add(new BasicNameValuePair("j_password", password));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse httpResponse = client.execute(post);
            HttpEntity responseEntity = httpResponse.getEntity();
            String strResponse = EntityUtils.toString(responseEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out
                    .println("Http status code for Authenticattion Request: " + statusCode);// Status code should be 302
            System.out.println("Response for Authenticattion Request: " + strResponse); // Should be blank string
            System.out.println("================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void executeRestCallUsingApacheHttpClient() {
        try {
            //
            HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(new BasicCookieStore()).build();
            HttpGet get = new HttpGet(PART_SEARCH_URL);
            //            get.setHeader("Cookie", httpCookieStore.getCookies().get(0).toString());
            String cookieJsession = getCookieForHeader();
            get.setHeader("Cookie", cookieJsession);
            HttpResponse httpResponse = client.execute(get);
            //            httpResponse = client.execute(get);
            HttpEntity responseEntity = httpResponse.getEntity();
            String strResponse = EntityUtils.toString(responseEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out
                    .println("Http status code for Authenticattion Request: " + statusCode);// Status code should be 302
            System.out.println("Response for Authenticattion Request: n" + strResponse); // Should be blank string
            System.out.println("================================================================");

            System.out.println(httpCookieStore.getCookies().get(0).getName());
            System.out.println(httpCookieStore.getCookies().get(0).getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void executeWithRestEasy() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(PART_SEARCH_URL);
        ClientRequestFilter userToHeader = requestContext -> {
            requestContext.getHeaders().put("Cookie", Arrays.asList(new Cookie(getCookieName(), getCookieValue())));
        };
        target.register(userToHeader);
        Response response = target.request().get();
        System.out.println(response.readEntity(String.class));

        //=================
        client = new ResteasyClientBuilder().build();
        target = client.target(PART_SEARCH_URL);
        userToHeader = requestContext -> {
            requestContext.getHeaders().put("Cookie", Arrays.asList(new Cookie(getCookieName(), getCookieValue())));
        };
        target.register(userToHeader);
        response = target.request().get();
        System.out.println(response.readEntity(String.class));
    }

    static void executeWithRestEasyWithProxy() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(CFD_SERVICE_URL);

        Cookie cookie = new Cookie(getCookieName(), getCookieValue());
        ClientRequestFilter userToHeader = requestContext -> {
            requestContext.getHeaders().put("Cookie", Arrays.asList(cookie));
        };
        IUnitUnderTestSearchWebService proxy = target.proxy(IUnitUnderTestSearchWebService.class);
        List<PartSearchResultDTO> partSearchResultDTOs = proxy.searchPartByNumber("A");
        partSearchResultDTOs.forEach(System.out::println);
    }

    static void executeWithRestEasyHeader() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        //        ResteasyWebTarget target = client.target(MEASUREMENT_URL);
        ResteasyWebTarget target = client.target(PART_SEARCH_URL);

        Cookie cookie = new Cookie(getCookieName(), getCookieValue());
        ClientRequestFilter userToHeader = requestContext -> {
            requestContext.getHeaders().put("Cookie", Arrays.asList(cookie.getName() + "=" + cookie.getValue()));
        };
        target.register(userToHeader);

        Response response = target.request().get();
        String entity = response.readEntity(String.class);
        System.out.println(entity);
    }
}
