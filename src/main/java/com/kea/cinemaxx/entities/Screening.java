package com.kea.cinemaxx.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "screening")
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int screeningId;

    @Column(length = 60,nullable = false)
    LocalTime time;

    @Column(length = 60,nullable = false)
    LocalDate date;

    @ManyToOne
    @JoinColumn(name="hall_id", nullable=false)
    @JsonBackReference
    Hall hall;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    @JsonBackReference
    Movie movie;

    @ManyToOne
    @JoinColumn(name="cinema_id", nullable = false)
    @JsonBackReference
    Cinema cinema;

//    List<Ticket> tickets // This needs to be created yet!

    public Screening(){}

    public  Screening(LocalTime time, LocalDate date, Movie movie, Hall hall, Cinema cinema){
        this.time = time;
        this.date = date;
        this.hall = hall;
        this.movie = movie;
        this.cinema = cinema;
    }


}
