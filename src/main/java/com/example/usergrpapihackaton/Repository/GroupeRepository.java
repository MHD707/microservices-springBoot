package com.example.usergrpapihackaton.Repository;

import com.example.usergrpapihackaton.Entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
}
