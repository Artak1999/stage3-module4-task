package com.mjc.school.implementation;

import com.mjc.school.BaseControllers;
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
    public ResponseEntity<TagDtoResponse> create(@RequestBody TagDtoRequest request) {
        return new ResponseEntity<>(this.tagService.create(request), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<TagDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(this.tagService.readById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TagDtoResponse>> readAll() {
        return new ResponseEntity<>(this.tagService.readAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<TagDtoResponse> update(@RequestBody TagDtoRequest request) {
        return new ResponseEntity<>(this.tagService.update(request),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.tagService.deleteById(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "?news=newsId")
    public ResponseEntity<List<TagDtoResponse>> getTagByNewsId(@PathVariable Long id) {
        return new ResponseEntity<>(this.tagService.getTagsByNewsId(id),HttpStatus.OK);
    }
}
