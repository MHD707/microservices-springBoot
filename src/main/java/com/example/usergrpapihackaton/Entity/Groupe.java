package com.example.usergrpapihackaton.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groupes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroupe;

    @Column(nullable = false)
    private String nom;

    private String description;

    @Column(name = "hackathon_nom")
    private String hackathonNom;

    @ManyToMany
    @JoinTable(
            name = "groupe_utilisateurs",
            joinColumns = @JoinColumn(name = "groupe_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    @JsonIgnoreProperties("groupes")
    private Set<Utilisateur> utilisateurs = new HashSet<>();
}
