package com.example.gestionseriews.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    @NotNull(message = "Le champ nom ne peut pas etre null")
    @NotBlank(message =  "Le champ nom ne peut pas etre vide")
    private String nom;

    @Column(name = "prix")
    @NotNull(message = "Le champ prix ne peut pas etre null")
    private Double prix;

    @NotNull(message = "Le champ date ne peut pas etre null")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateSortie;

    @OneToMany(mappedBy="serie", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Saison> saisons;

    public Serie() {
    }

    public Serie(String nom, Double prix, Date dateSortie) {
        this.nom = nom;
        this.prix = prix;
        this.dateSortie = dateSortie;
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", dateSortie=" + dateSortie +
                '}';
    }
}

