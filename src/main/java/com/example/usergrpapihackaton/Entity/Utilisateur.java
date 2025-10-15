package com.example.usergrpapihackaton.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utilisateurs")
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = AUTO INCREMENT //SEQUENCE : SI JAI UNE MANIERE SPECIFIQUE POUR LA GENERATION DE L ID
    private Long idUser;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;

    private String telephone,specialite, role;

    @ManyToMany(mappedBy = "utilisateurs")
    @JsonIgnoreProperties("utilisateurs")
    private Set<Groupe> groupes = new HashSet<>();

}
