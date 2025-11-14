package com.app.biletuz.model;

import jakarta.persistence.*;
import jdk.jfr.EventType;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime startTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sala_id", nullable = false)
    private Hall hall;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;


}