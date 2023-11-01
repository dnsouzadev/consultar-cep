package com.dnsouzadev.apiviacep.service;

import com.dnsouzadev.apiviacep.model.Address;
import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class ViaCepService {
    public Address getAddress(String cep) {
        Address address = null;

        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
            CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();

                address = gson.fromJson(result, Address.class);
            }

            return address;

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
