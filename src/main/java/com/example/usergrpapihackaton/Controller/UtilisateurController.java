package com.example.usergrpapihackaton.Controller;

import com.example.usergrpapihackaton.Entity.Utilisateur;
import com.example.usergrpapihackaton.service.UtilisateurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> allUsers() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUser(@PathVariable Long id) {
        return utilisateurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur created = utilisateurService.create(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUser(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur updated = utilisateurService.update(id, utilisateur);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            utilisateurService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
