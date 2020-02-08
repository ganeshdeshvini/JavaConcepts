package httpclientexample.restclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpClientFormBasedAuthenticationProgramatically {
    static Cookie cookie;

    public static void main(String[] args) {
        System.out.println(new Date());
        System.exit(0);
        try {
            String userName = "sa";
            String password = "sa";
            CookieStore httpCookieStore = new BasicCookieStore();
            HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).build();
            HttpPost post = new HttpPost("http://localhost:8080/cfd-services/j_security_check");
            //            HttpPost post = new HttpPost("http://localhost:8080/j_security_check");
            //            post = new HttpPost("http://localhost:8080/cfd-services/rest-api/measurements");
            //
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("j_username", userName));
            nameValuePairs.add(new BasicNameValuePair("j_password", password));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse httpResponse = client.execute(post);
            List<Cookie> cookies = httpCookieStore.getCookies();
            HttpClientFormBasedAuthenticationProgramatically.cookie = cookies.get(0);
            HttpEntity responseEntity = httpResponse.getEntity();
            String strResponse = EntityUtils.toString(responseEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out
                    .println("Http status code for Authenticattion Request: " + statusCode);// Status code should be 302
            System.out.println("Response for Authenticattion Request: n" + strResponse); // Should be blank string
            System.out.println("================================================================n");

            //
            HttpGet get = new HttpGet("http://localhost:8080/cfd-services/rest-api/measurements");
            get.setHeader("Cookie", HttpClientFormBasedAuthenticationProgramatically.cookie.toString());
            httpResponse = client.execute(get);
            responseEntity = httpResponse.getEntity();
            strResponse = EntityUtils.toString(responseEntity);
            statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out
                    .println("Http status code for Authenticattion Request: " + statusCode);// Status code should be 302
            System.out.println("Response for Authenticattion Request: n" + strResponse); // Should be blank string
            System.out.println("================================================================n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
