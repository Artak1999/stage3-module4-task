package com.mjc.school.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseControllers<T, R, K> {
    ResponseEntity<R> create(T request);
    ResponseEntity<R> readById(K id);
    ResponseEntity<List<R>> readAll();
    ResponseEntity<R> update(K id, T request);
    void deleteById(K id);
}
