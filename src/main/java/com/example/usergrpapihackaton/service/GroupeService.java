package com.example.usergrpapihackaton.service;

import com.example.usergrpapihackaton.Entity.Groupe;
import com.example.usergrpapihackaton.Repository.GroupeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {

    private final GroupeRepository groupeRepository;

    public GroupeService(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public List<Groupe> findAll() {
        return groupeRepository.findAll();
    }

    public Optional<Groupe> findById(Long id) {
        return groupeRepository.findById(id);
    }

    public Groupe create(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    public Groupe update(Long id, Groupe groupe) {
        return groupeRepository.findById(id)
                .map(existing -> {
                    existing.setNom(groupe.getNom());
                    existing.setDescription(groupe.getDescription());
                    existing.setHackathonNom(groupe.getHackathonNom());
                    existing.setUtilisateurs(groupe.getUtilisateurs());
                    return groupeRepository.save(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Groupe not found with id " + id));
    }

    public void delete(Long id) {
        if (!groupeRepository.existsById(id)) {
            throw new EntityNotFoundException("Groupe not found with id " + id);
        }
        groupeRepository.deleteById(id);
    }
}
