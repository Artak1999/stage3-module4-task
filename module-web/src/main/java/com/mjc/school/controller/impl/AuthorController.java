package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.AuthorDtoRequest;
import com.mjc.school.dto.AuthorDtoResponse;
import com.mjc.school.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDtoResponse create(@RequestBody AuthorDtoRequest request) {
        return this.authorService.create(request);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDtoResponse readById(@PathVariable Long id) {
        return this.authorService.readById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDtoResponse> readAll(@RequestParam int size, @RequestParam int page, @RequestParam String sort) {
        return this.authorService.readAll(size, page, sort);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDtoResponse update(@PathVariable Long id, @RequestBody AuthorDtoRequest request) {
        return this.authorService.update(request);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.authorService.deleteById(id);
    }

    @GetMapping(value = "?news=newsId")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDtoResponse getAuthorByNewsId(@PathVariable Long id){
        return this.authorService.getAuthorByNewsId(id);
    }
}
