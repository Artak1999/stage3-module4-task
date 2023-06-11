package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.CommentDtoRequest;
import com.mjc.school.dto.CommentDtoResponse;
import com.mjc.school.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public CommentDtoResponse create(@RequestBody CommentDtoRequest request) {
        return this.commentService.create(request);
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDtoResponse readById(@PathVariable Long id) {
        return this.commentService.readById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDtoResponse> readAll(@RequestParam int size, @RequestParam int page, @RequestParam String sort) {
        return this.commentService.readAll(size, page, sort);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDtoResponse update(@PathVariable Long id, @RequestBody CommentDtoRequest request) {
        return this.commentService.update(request);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.commentService.deleteById(id);
    }

    @GetMapping(value = "?news=newsId")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDtoResponse> getCommentsByNewsId(@PathVariable Long id) {
        return this.commentService.getTagsByNewsId(id);
    }
}
