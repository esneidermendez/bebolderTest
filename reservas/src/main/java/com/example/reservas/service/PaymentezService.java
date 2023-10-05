package com.example.reservas.service;

import com.example.reservas.dto.DataFromBankDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface PaymentezService {
    Mono<DataFromBankDTO> getBank();
}
