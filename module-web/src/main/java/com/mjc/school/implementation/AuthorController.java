package com.mjc.school.implementation;

import com.mjc.school.BaseControllers;
import com.mjc.school.dto.AuthorDtoRequest;
import com.mjc.school.dto.AuthorDtoResponse;
import com.mjc.school.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping(value = "/authors")
public class AuthorController implements BaseControllers<AuthorDtoRequest, AuthorDtoResponse, Long> {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    @PostMapping
    public ResponseEntity<AuthorDtoResponse> create(@RequestBody AuthorDtoRequest request) {
        return new ResponseEntity<>(this.authorService.create(request),HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(this.authorService.readById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AuthorDtoResponse>> readAll() {
        return new ResponseEntity<>(this.authorService.readAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<AuthorDtoResponse> update(@RequestBody AuthorDtoRequest request) {
        return new ResponseEntity<>(this.authorService.update(request),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.authorService.deleteById(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "?news=newsId")
    public ResponseEntity<AuthorDtoResponse> getAuthorByNewsId(@PathVariable Long id){
        return new ResponseEntity<>(this.authorService.getAuthorByNewsId(id),HttpStatus.OK);
    }
}
