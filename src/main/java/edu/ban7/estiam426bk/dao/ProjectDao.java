package edu.ban7.estiam426bk.dao;

import edu.ban7.estiam426bk.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

    // fetch join : charge les images en une seule requête (pas de N+1)
    @Query("SELECT DISTINCT p FROM Project p LEFT JOIN FETCH p.images WHERE p.isPrivate = false")
    List<Project> findAllPublicWithImages();

}
