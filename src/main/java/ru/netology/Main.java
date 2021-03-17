package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String URL = "https://cat-fact.herokuapp.com/facts";
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(10000)
                        .setSocketTimeout(50000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader(HttpHeaders.ACCEPT, ContentType.
                APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = client.execute(httpGet);
        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);

        List<CatFacts> catFactsList = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<List<CatFacts>>() {});

        catFactsList
                .stream().filter(catFacts -> catFacts.getUsed(true))
                .forEach(System.out::println);
    }
}
