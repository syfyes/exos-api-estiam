package edu.ban7.estiam426bk.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.ban7.estiam426bk.view.ProjectView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ProjectView.class)
    protected Integer id;

    @Column(nullable = false)
    @JsonView(ProjectView.class)
    protected String url;

    // Pas de @JsonView : jamais sérialisé -> évite la boucle Project -> Image -> Project
    @ManyToOne(optional = false)
    protected Project project;
}
