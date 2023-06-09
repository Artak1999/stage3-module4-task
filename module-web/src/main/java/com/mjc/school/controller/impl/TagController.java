package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;
import com.mjc.school.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping(value = "/tags")
public class TagController implements BaseControllers<TagDtoRequest, TagDtoResponse, Long> {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TagDtoResponse> create(@RequestBody TagDtoRequest request) {
        return new ResponseEntity<>(this.tagService.create(request), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TagDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(this.tagService.readById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TagDtoResponse>> readAll() {
        return new ResponseEntity<>(this.tagService.readAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TagDtoResponse> update(@PathVariable Long id, @RequestBody TagDtoRequest request) {
        return new ResponseEntity<>(this.tagService.update(request),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.tagService.deleteById(id);
    }

    @GetMapping(value = "?news=newsId")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TagDtoResponse>> getTagByNewsId(@PathVariable Long id) {
        return new ResponseEntity<>(this.tagService.getTagsByNewsId(id),HttpStatus.OK);
    }
}
