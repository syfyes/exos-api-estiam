package edu.ban7.estiam426bk.controller;

import edu.ban7.estiam426bk.dao.TagDao;
import edu.ban7.estiam426bk.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("tag")
public class TagController {

    protected final TagDao tagDao;

    @GetMapping("/all")
    public List<Tag> all() {

        return tagDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> read(@PathVariable int id) {

        Optional<Tag> tagDb =  tagDao.findById(id);

        if(tagDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tagDb.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody Tag newUser) {

        tagDao.save(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> update(
            @PathVariable int id,
            @RequestBody Tag alteredUser) {

        Optional<Tag> tagDb =  tagDao.findById(id);

        if(tagDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        alteredUser.setId(id);
        tagDao.save(alteredUser);

        return new ResponseEntity<>(alteredUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<Tag> tagDb =  tagDao.findById(id);

        if(tagDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tagDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
