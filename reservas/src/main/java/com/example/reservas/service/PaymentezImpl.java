package com.example.reservas.service;

import com.example.reservas.dto.*;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Base64;

@Log4j2
@Service
public class PaymentezImpl implements PaymentezService {
    String appCodeTuya = "WINGOQA-COP-SERVER";
    String appSecretKeyTuya ="7Ab3RDm1A3H0YQiwfximRxdDn1k21g";
    WebClient.Builder webClientBuilder;
    @Autowired
    public PaymentezImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<DataFromBankDTO> getBank() {
        String url = "https://noccapi-stg.paymentez.com/banks/PSE/";
        log.info("URL {}",url);
        WebClient webClient = webClientBuilder.baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Auth-Token", authHeaderValue(appCodeTuya,String.valueOf(Instant.now().toEpochMilli()+60000),appSecretKeyTuya))
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(DataFromBankDTO.class);
    }

    private String authHeaderValue(String applicationCode,String unixtimestamp, String uniqToken) {
        String token = DigestUtils.sha256Hex(uniqToken.concat(unixtimestamp));
        String auth = applicationCode + ";" + unixtimestamp+ ";" + token;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        return encodedAuth;
    }
}
