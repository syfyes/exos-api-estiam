package edu.ban7.estiam426bk.dao;

import edu.ban7.estiam426bk.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface AppUserDao extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByEmail(String email);

    @Query("FROM AppUser u WHERE u.email = :email")
    Optional<AppUser> trouveParAdresseMail(String email);

    @Query(value = "SELECT * FROM app_user u WHERE email = :email", nativeQuery = true)
    Map<String, Object> trouveParAdresseMailNatif(String email);
}
