package edu.ban7.estiam426bk.controller;

import edu.ban7.estiam426bk.dao.RoleDao;
import edu.ban7.estiam426bk.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class RoleController {

    protected final RoleDao roleDao;

    @GetMapping("/all")
    public List<Role> all() {

        return roleDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> read(@PathVariable int id) {

        Optional<Role> roleDb =  roleDao.findById(id);

        if(roleDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roleDb.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role newUser) {

        roleDao.save(newUser);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> update(
            @PathVariable int id,
            @RequestBody Role alteredUser) {

        Optional<Role> roleDb =  roleDao.findById(id);

        if(roleDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        alteredUser.setId(id);
        roleDao.save(alteredUser);

        return new ResponseEntity<>(alteredUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<Role> roleDb =  roleDao.findById(id);

        if(roleDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        roleDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
