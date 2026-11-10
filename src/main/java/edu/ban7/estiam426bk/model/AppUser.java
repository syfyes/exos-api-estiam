package edu.ban7.estiam426bk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.ban7.estiam426bk.view.AppUserView;
import edu.ban7.estiam426bk.view.ProjectView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AppUserView.class, ProjectView.class})
    protected Integer id;

    @JsonView(AppUserView.class)
    protected String email;

    protected String password;

    @ManyToOne(optional = false)
    @JsonView(AppUserView.class)
    protected Role role;

    @OneToMany(mappedBy = "owner")
    @JsonView(AppUserView.class)
    protected List<Project> projects = new ArrayList<>();
}
