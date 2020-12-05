package com.issambenmessaoud.gamma.repositories;

import com.issambenmessaoud.gamma.models.ETacheEtat;
import com.issambenmessaoud.gamma.models.Tache;
import com.issambenmessaoud.gamma.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacheRepository extends JpaRepository<Tache,Long> {
  List<Tache> findAllByEtatEquals(ETacheEtat eTacheEtat);

  List<Tache> findAllByEtatEqualsAndUserEquals(ETacheEtat started, User user);
}
