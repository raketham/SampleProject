package com.ord.fiserv.controller;

import com.ord.fiserv.dao.SampleRepository;
import com.ord.fiserv.entity.Sample;
import com.ord.fiserv.exception.ItemNotFoundException;
import com.ord.fiserv.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    private SampleRepository sampleRepository;

    @GetMapping("/items")
    List<Sample> all() {
        return sampleRepository.findAll();
    }


    @PostMapping("/items")
    Sample createNew(@RequestBody Sample sample) {
        return sampleRepository.save(sample);
    }

    @DeleteMapping("/items/{id}")
    void delete(@PathVariable Long id) {
        sampleRepository.deleteById(id);
    }

    @PutMapping("/items/{id}")
    Sample updateOrCreate(@RequestBody Sample sample, @PathVariable Long id) {


        return sampleRepository.findById(id)
                .map(item -> {
                    item.setName(sample.getName());
                    return sampleRepository.save(item);
                })
                .orElseGet(() -> {
                    sample.setId(id);
                    return sampleRepository.save(sample);
                });
    }

    @GetMapping("/insert")
    String insertAllRecords() {

        Sample[] array = {
                new Sample(1L, "Ram"),
                new Sample(2L, "hello"),
                new Sample(3L, "testing"),
                new Sample(4L, "James"),
                new Sample(5L, "Test"),
                new Sample(6L, "Done")
        };
        List<Sample> list = Arrays.asList(array);

        sampleRepository.saveAll(list);
        return "Success";
    }

    @GetMapping("/items/{id}")
    Sample getById(@PathVariable Long id) {

        return sampleRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

}
