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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProjectView.class)
    protected Integer id;

    @JsonView({AppUserView.class, ProjectView.class})
    protected String name;

    @JsonView(ProjectView.class)
    protected boolean isPrivate = false;

    @ManyToOne(optional = false)
    @JsonView(ProjectView.class)
    protected AppUser owner;

    @ManyToMany
    @JsonView(ProjectView.class)
    @JoinTable(
            name = "tag_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    protected List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonView(ProjectView.class)
    protected List<Image> images = new ArrayList<>();

}
