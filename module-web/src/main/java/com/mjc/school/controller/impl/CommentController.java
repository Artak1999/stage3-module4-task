package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.CommentDtoRequest;
import com.mjc.school.dto.CommentDtoResponse;
import com.mjc.school.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping(value = "/comments")
public class CommentController implements BaseControllers<CommentDtoRequest, CommentDtoResponse, Long> {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CommentDtoResponse> create(@RequestBody CommentDtoRequest request) {
        return new ResponseEntity<>(this.commentService.create(request), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(this.commentService.readById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CommentDtoResponse>> readAll() {
        return new ResponseEntity<>(this.commentService.readAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentDtoResponse> update(@PathVariable Long id, @RequestBody CommentDtoRequest request) {
        return new ResponseEntity<>(this.commentService.update(request),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.commentService.deleteById(id);
    }

    @GetMapping(value = "?news=newsId")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CommentDtoResponse>> getCommentsByNewsId(@PathVariable Long id) {
        return new ResponseEntity<>(this.commentService.getTagsByNewsId(id),HttpStatus.OK);
    }
}
