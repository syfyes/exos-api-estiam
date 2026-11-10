package edu.ban7.estiam426bk.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.ban7.estiam426bk.view.AppUserView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView(AppUserView.class)
    protected String name;

}
