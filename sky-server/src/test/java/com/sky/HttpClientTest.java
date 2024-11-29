package com.sky;

import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author CWL
 * @version 1.0
 * @Description
 * @packageName com.sky
 * @fileName HttpClientTest.java
 * @createTime 2024/8/5
 * @copyright 2024 Amarsoft
 */

@SpringBootTest
public class HttpClientTest {

    @Test
    void test() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();

        System.out.println("状态码"+statusCode);
        HttpEntity entity = response.getEntity();

        System.out.println("服务端返回的数据"+entity.toString());

        response.close();
        httpClient.close();


    }

    @Test
    void testPOST() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username","admin");
        jsonObject.addProperty("password","123456");

        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        stringEntity.setContentEncoding("UTF-8");

        stringEntity.setContentType("application/json");

        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);


        //解析返回结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应码为：" + statusCode);

        HttpEntity entity1 = response.getEntity();
        String body = EntityUtils.toString(entity1);
        System.out.println("响应数据为：" + body);

        //关闭资源
        response.close();
        httpClient.close();


    }





}