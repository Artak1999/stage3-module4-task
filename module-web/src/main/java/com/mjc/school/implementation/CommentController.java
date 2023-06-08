package com.mjc.school.implementation;

import com.mjc.school.BaseControllers;
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
    public ResponseEntity<CommentDtoResponse> create(@RequestBody CommentDtoRequest request) {
        return new ResponseEntity<>(this.commentService.create(request), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(this.commentService.readById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CommentDtoResponse>> readAll() {
        return new ResponseEntity<>(this.commentService.readAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<CommentDtoResponse> update(@RequestBody CommentDtoRequest request) {
        return new ResponseEntity<>(this.commentService.update(request),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.commentService.deleteById(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "?news=newsId")
    public ResponseEntity<List<CommentDtoResponse>> getCommentsByNewsId(@PathVariable Long id) {
        return new ResponseEntity<>(this.commentService.getTagsByNewsId(id),HttpStatus.OK);
    }
}
