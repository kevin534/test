package com.example.gestionseriews.repositories;

import com.example.gestionseriews.models.Saison;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaisonRepository extends CrudRepository<Saison,Long> {
    @Override
    List<Saison> findAll();
    List<Saison> findBySerieId(Long serieId);
}


