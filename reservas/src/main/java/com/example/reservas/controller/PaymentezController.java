package com.example.reservas.controller;
import com.example.reservas.dto.DataFromBankDTO;
import com.example.reservas.entity.ReservationEntity;
import com.example.reservas.repository.ReservationRepository;
import com.example.reservas.service.PaymentezService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping
// TODO: 4/10/2023 Tiene los CORS habilitados para pruebas en local
@CrossOrigin(origins = "*")
public class PaymentezController {
    private final PaymentezService paymentezService;
    private final ReservationRepository reservationRepository;

    @Autowired
    public  PaymentezController(PaymentezService paymentezService, ReservationRepository reservationRepository){
        this.paymentezService = paymentezService;
        this.reservationRepository = reservationRepository;
    }
    @GetMapping("/get/bank")
    public ResponseEntity<Mono<DataFromBankDTO>> getBank() {
        log.info("Inicio de method getBank");
        ResponseEntity<Mono<DataFromBankDTO>> response = new ResponseEntity<>(paymentezService.getBank(), HttpStatus.OK);
        log.info("Fin de method getBank");

        return response;
    }
    @PostMapping("/reservas")
    public ReservationEntity postReservation(@RequestBody ReservationEntity reserva) {
        log.info("Inicio de method postReservation");
        System.out.println(reserva.getPassengerName());
        System.out.println(reserva.getDateCreation());
        return reservationRepository.save(reserva);
        //ResponseEntity<Mono<DataFromBankDTO>> response = new ResponseEntity<>(paymentezService.getBank(), HttpStatus.OK);
        //log.info("Fin de method postReservation");

        //return response;
    }
}
