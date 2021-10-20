package com.kea.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import com.kea.cinemaxx.entities.Seat;
import com.kea.cinemaxx.entities.Screening;


import javax.persistence.*;

@Entity
@Getter @Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ticketId;

    boolean purchased;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference ("ticketsForUser")
    User user;  // the user CAN be null since some tickets will not be purchased yet

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    @JsonManagedReference ("ticketForSeat")
    Seat seat;

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    @JsonBackReference ("ticketsForScreening")
    Screening screening;

    public Ticket(){}

    public Ticket(boolean purchased, User user, Seat seat, Screening screening) {
        this.purchased = purchased;
        this.user = user;
        this.seat = seat;
        this.screening = screening;
    }

    public void resetTicket(Seat seatToKeep) {
        this.purchased = false;
        this.user = null;
        this.seat = seatToKeep;
    }

}
