package com.example.reservas.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
//@Table(name = "Reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private String dateCreation;

    public ReservationEntity(Long id, String passengerName, String dateCreation) {
        this.id = id;
        this.passengerName = passengerName;
        this.dateCreation = dateCreation;
    }
    public ReservationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
