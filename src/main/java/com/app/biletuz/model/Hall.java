package com.app.biletuz.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private int capacity;
    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Event> events;


}