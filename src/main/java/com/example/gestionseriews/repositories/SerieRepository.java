package com.example.gestionseriews.repositories;

import com.example.gestionseriews.models.Saison;
import com.example.gestionseriews.models.Serie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends CrudRepository<Serie,Long> {
    List<Serie> findAll();
}
