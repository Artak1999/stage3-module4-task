package com.mjc.school;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseControllers<T, R, K> {
    ResponseEntity<R> create(T request);
    ResponseEntity<R> readById(K id);
    ResponseEntity<List<R>> readAll();
    ResponseEntity<R> update(T request);
    ResponseEntity<Boolean> deleteById(K id);
}
