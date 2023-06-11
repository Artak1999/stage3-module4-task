package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseControllers;
import com.mjc.school.dto.NewsDtoRequest;
import com.mjc.school.dto.NewsDtoResponse;
import com.mjc.school.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public NewsDtoResponse create(@RequestBody NewsDtoRequest request) {
        return this.newsService.create(request);
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsDtoResponse readById(@PathVariable Long id) {
        return this.newsService.readById(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDtoResponse> readAll(@RequestParam int size, @RequestParam int page, @RequestParam String sort) {
        return this.newsService.readAll(size, page, sort);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsDtoResponse update(@PathVariable Long id, @RequestBody NewsDtoRequest request) {
        return this.newsService.update(request);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.newsService.deleteById(id);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDtoResponse> getNewsByTagNames(@RequestParam(name = "name") List<String> tagNames, List<Long> tagIds, String authorName, String title, String content, int size, int page, String sort) {
        return this.newsService.getNewsByCriteria(tagNames, tagIds, authorName, title, content, size, page, sort);
    }
}
