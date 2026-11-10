package edu.ban7.estiam426bk.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.ban7.estiam426bk.dao.ProjectDao;
import edu.ban7.estiam426bk.dto.PublicProjectDto;
import edu.ban7.estiam426bk.model.Project;
import edu.ban7.estiam426bk.view.ProjectView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("project")
public class ProjectController {

    protected final ProjectDao projectDao;

    @GetMapping("/all")
    @JsonView(ProjectView.class)
    public List<Project> all() {

        return projectDao.findAll();
    }

    @GetMapping("/public")
    public List<PublicProjectDto> allPublic() {

        return projectDao.findAllPublicWithImages()
                .stream()
                .map(PublicProjectDto::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    @JsonView(ProjectView.class)
    public ResponseEntity<Project> read(@PathVariable int id) {

        Optional<Project> projectDb =  projectDao.findById(id);

        if(projectDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(projectDb.get(), HttpStatus.OK);
    }

    @PostMapping
    @JsonView(ProjectView.class)
    public ResponseEntity<Project> create(@RequestBody Project newUser) {

        projectDao.save(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @JsonView(ProjectView.class)
    public ResponseEntity<Project> update(
            @PathVariable int id,
            @RequestBody Project alteredUser) {

        Optional<Project> projectDb =  projectDao.findById(id);

        if(projectDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        alteredUser.setId(id);
        projectDao.save(alteredUser);

        return new ResponseEntity<>(alteredUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<Project> projectDb =  projectDao.findById(id);

        if(projectDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        projectDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
