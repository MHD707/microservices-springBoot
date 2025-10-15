package com.example.usergrpapihackaton.Controller;

import com.example.usergrpapihackaton.Entity.Utilisateur;
import com.example.usergrpapihackaton.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/")
    public List<Utilisateur> allUsers(){
        return utilisateurService;
    }
}
