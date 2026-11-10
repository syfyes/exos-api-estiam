package edu.ban7.estiam426bk.dao;

import edu.ban7.estiam426bk.model.Role;
import edu.ban7.estiam426bk.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends JpaRepository<Tag, Integer> {

}
