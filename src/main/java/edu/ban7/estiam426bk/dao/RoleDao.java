package edu.ban7.estiam426bk.dao;

import edu.ban7.estiam426bk.model.Project;
import edu.ban7.estiam426bk.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

}
