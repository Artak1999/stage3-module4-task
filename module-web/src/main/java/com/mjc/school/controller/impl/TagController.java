package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.TagDtoRequest;
import com.mjc.school.dto.TagDtoResponse;
import com.mjc.school.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public TagDtoResponse create(@RequestBody TagDtoRequest request) {
        return this.tagService.create(request);
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TagDtoResponse readById(@PathVariable Long id) {
        return this.tagService.readById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TagDtoResponse> readAll(@RequestParam int size, @RequestParam int page, @RequestParam String sort) {
        return this.tagService.readAll(size, page, sort);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TagDtoResponse update(@PathVariable Long id, @RequestBody TagDtoRequest request) {
        return this.tagService.update(request);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.tagService.deleteById(id);
    }

    @GetMapping(value = "?news=newsId")
    @ResponseStatus(HttpStatus.OK)
    public List<TagDtoResponse> getTagByNewsId(@PathVariable Long id) {
        return this.tagService.getTagsByNewsId(id);
    }
}
