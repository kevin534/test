package com.example.gestionseriews.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "saison")
public class Saison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    @NotNull(message = "Le champ nom ne peut pas etre null")
    @NotBlank(message =  "Le champ nom ne peut pas etre vide")
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Serie serie;

    public Saison() {
    }

    public Saison(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Saison{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
