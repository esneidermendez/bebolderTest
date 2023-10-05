package com.example.reservas.service;

import com.example.reservas.dto.DataFromBankDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.google.gson.Gson;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class PaymentezImplTest {
    static Gson gson = new Gson();
    PaymentezImpl paymentezService;
    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriMock;

    @Mock
    WebClient.ResponseSpec responseMock;

    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.Builder webClientBuilder;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentezService = new PaymentezImpl(webClientBuilder);
    }

    @Test
    void getBank() {
        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeader(anyString(), anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.defaultHeader(anyString(), anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClientMock);
        when(webClientMock.get()).thenReturn(requestHeadersUriMock);
        when(requestHeadersUriMock.retrieve()).thenReturn(responseMock);
        when(responseMock.bodyToMono(DataFromBankDTO.class)).thenReturn(Mono.just(getDataBank()));

        StepVerifier.create(paymentezService.getBank())
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }
    private DataFromBankDTO getDataBank() {
        String response = "{\n" +
                "    \"banks\": [\n" +
                "        {\n" +
                "            \"name\": \"A continuación seleccione su banco\",\n" +
                "            \"code\": \"0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BAN.CO\",\n" +
                "            \"code\": \"1552\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO AGRARIO\",\n" +
                "            \"code\": \"1040\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO AGRARIO DESARROLLO\",\n" +
                "            \"code\": \"1081\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO AGRARIO QA DEFECTOS\",\n" +
                "            \"code\": \"1080\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO CAJA SOCIAL\",\n" +
                "            \"code\": \"10322\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO CAJA SOCIAL DESARROLLO\",\n" +
                "            \"code\": \"1032\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO COLPATRIA DESARROLLO\",\n" +
                "            \"code\": \"1019\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO COLPATRIA UAT\",\n" +
                "            \"code\": \"1078\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO COMERCIAL AVVILLAS S.A.\",\n" +
                "            \"code\": \"1052\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO COOMEVA S.A. - BANCOOMEVA\",\n" +
                "            \"code\": \"1061\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO COOPERATIVO COOPCENTRAL\",\n" +
                "            \"code\": \"1016\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO DAVIVIENDA\",\n" +
                "            \"code\": \"1051\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO DAVIVIENDA Desarrollo\",\n" +
                "            \"code\": \"10512\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO DE BOGOTA\",\n" +
                "            \"code\": \"1039\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO DE BOGOTA DESARROLLO 2013\",\n" +
                "            \"code\": \"1001\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO DE OCCIDENTE\",\n" +
                "            \"code\": \"1023\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO FALABELLA\",\n" +
                "            \"code\": \"1062\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO GNB COLOMBIA (ANTES HSBC)\",\n" +
                "            \"code\": \"1010\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO GNB SUDAMERIS\",\n" +
                "            \"code\": \"1012\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO PICHINCHA S.A.\",\n" +
                "            \"code\": \"1060\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO POPULAR\",\n" +
                "            \"code\": \"1002\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO PROCREDIT COLOMBIA\",\n" +
                "            \"code\": \"1058\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO PRODUCTOS POR SEPARADO\",\n" +
                "            \"code\": \"1203\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Banco PSE\",\n" +
                "            \"code\": \"1101\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO SANTANDER COLOMBIA\",\n" +
                "            \"code\": \"1065\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Banco Serfinanza\",\n" +
                "            \"code\": \"1063\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO TEQUENDAMA\",\n" +
                "            \"code\": \"1035\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Banco union Colombia Credito\",\n" +
                "            \"code\": \"1004\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Banco union Colombia credito FD\",\n" +
                "            \"code\": \"1005\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCO UNION COLOMBIANO\",\n" +
                "            \"code\": \"1022\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Banco Web Service ACH\",\n" +
                "            \"code\": \"1055\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Banco Web Service ACH WSE 3.0\",\n" +
                "            \"code\": \"1055\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCOLOMBIA DATAPOWER\",\n" +
                "            \"code\": \"10072\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCOLOMBIA DESARROLLO\",\n" +
                "            \"code\": \"10071\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BANCOLOMBIA QA\",\n" +
                "            \"code\": \"1007\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"BBVA COLOMBIA S.A.\",\n" +
                "            \"code\": \"1013\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"CITIBANK COLOMBIA S.A.\",\n" +
                "            \"code\": \"1009\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"CONFIAR COOPERATIVA FINANCIERA\",\n" +
                "            \"code\": \"1292\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"DAVIPLATA\",\n" +
                "            \"code\": \"1551\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"ITAU\",\n" +
                "            \"code\": \"1006\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"NEQUI CERTIFICACION\",\n" +
                "            \"code\": \"1508\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Prueba Steve\",\n" +
                "            \"code\": \"121212\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return gson.fromJson(response, DataFromBankDTO.class);
    }
}