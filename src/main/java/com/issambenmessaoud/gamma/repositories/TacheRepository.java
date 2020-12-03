package com.issambenmessaoud.gamma.repositories;

import com.issambenmessaoud.gamma.models.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Long> {
    HashSet<Tache> findByEtat(String etat) ;

}
