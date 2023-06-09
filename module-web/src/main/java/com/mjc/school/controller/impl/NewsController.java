package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.NewsDtoRequest;
import com.mjc.school.dto.NewsDtoResponse;
import com.mjc.school.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping(value = "/news")
public class NewsController implements BaseControllers<NewsDtoRequest, NewsDtoResponse, Long> {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    @PostMapping
    public ResponseEntity<NewsDtoResponse> create(@RequestBody NewsDtoRequest request) {
        return new ResponseEntity<>(this.newsService.create(request), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<NewsDtoResponse> readById(@PathVariable Long id) {
        return new ResponseEntity<>(this.newsService.readById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<NewsDtoResponse>> readAll() {
        return new ResponseEntity<>(this.newsService.readAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<NewsDtoResponse> update(@RequestBody NewsDtoRequest request) {
        return new ResponseEntity<>(this.newsService.update(request),HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.newsService.deleteById(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name")
    public ResponseEntity<List<NewsDtoResponse>> getNewsByTagNames(@RequestParam(name = "name") List<String> tagNames, List<Long> tagIds, String authorName, String title, String content) {
        return new ResponseEntity<>(this.newsService.getNewsByCriteria(tagNames, tagIds, authorName, title, content),HttpStatus.OK);
    }
}
