package main.java.net;


import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpsUrlConnectionTests {
    @Test
    public void testConnection() throws Exception{

        URL url = new URL("https://www.baidu.com");
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        
        conn.setSSLSocketFactory(ssf);
        // 设置长链接
        conn.setRequestProperty("Connection", "Keep-Alive");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line).append("\n");
        }
        in.close();

        System.out.println(result.toString());
    }
}
