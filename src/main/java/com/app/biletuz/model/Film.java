package com.app.biletuz.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String title;
        @Column
        private String description;
        @Column
        private Integer duration;
        @Column
        private Integer year;
        @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private Set<Event> events = new HashSet<>();



}
