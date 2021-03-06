package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    @Query("select max (u.idutilisateur) from Utilisateur  u")
    Long nextId();

    @Query("select u from Utilisateur u where u.login=:username")
    Optional<Utilisateur> findByLogin(@Param(value = "username") String username);

    @Query("select u from Utilisateur  u where u.idinstitution.idinstitution=:idInstitution order by u.login")
    List<Utilisateur> findAllByIdinstitution(@Param("idInstitution") Integer idInstitution);

}
