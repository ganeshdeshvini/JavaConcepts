package httpclientexample.replica;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public enum SessionManager {
    INSTANCE;
    private CookieStore httpCookieStore;

    SessionManager() {
        httpCookieStore = new BasicCookieStore();
        initializeCookie();
    }

    private void initializeCookie() {
        clearAllCookiesFromStore();
        HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).build();
        HttpPost post = new HttpPost(getAuthURL());

        List<NameValuePair> nameValuePairs = getNameValuePairs();

        try {
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse = client.execute(post);

            HttpEntity responseEntity = httpResponse.getEntity();
            String strResponse = EntityUtils.toString(responseEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);
            if (statusCode == 200) {
                System.out.println("===========================SUCCESS==============================");
            } else {
                System.out.println("===========================ERROR==============================");
            }
            System.out.println("Http status code for Authenticattion Request: " + statusCode);
            System.out.println("Response for Authenticattion Request: " + strResponse);

        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    private void clearAllCookiesFromStore() {
        httpCookieStore.clear();
    }

    private List<NameValuePair> getNameValuePairs() {
        return Arrays.asList(
                new BasicNameValuePair("j_username", getUserName()),
                new BasicNameValuePair("j_password", getPassword()));
    }

    private String getAuthURL() {
        return RemoteServiceFactory.cfdServiceURL + "j_security_check";
    }

    private String getUserName() {
        return RemoteServiceFactory.cfdServiceUser;
    }

    private String getPassword() {
        return RemoteServiceFactory.cfdServicePW;
    }
    CookieStore getHttpCookieStore() {
        return httpCookieStore;
    }
}
