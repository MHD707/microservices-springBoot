package com.example.usergrpapihackaton.service;

import com.example.usergrpapihackaton.Entity.Utilisateur;
import com.example.usergrpapihackaton.Repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Optional<Utilisateur> findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur update(Long id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(id)
                .map(existing -> {
                    existing.setNom(utilisateur.getNom());
                    existing.setEmail(utilisateur.getEmail());
                    existing.setTelephone(utilisateur.getTelephone());
                    existing.setSpecialite(utilisateur.getSpecialite());
                    existing.setRole(utilisateur.getRole());
                    return utilisateurRepository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found with id " + id));
    }

    public void delete(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new EntityNotFoundException("Utilisateur not found with id " + id);
        }
        utilisateurRepository.deleteById(id);
    }
}
