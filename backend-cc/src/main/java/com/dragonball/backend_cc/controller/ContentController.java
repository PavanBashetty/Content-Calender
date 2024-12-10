package com.dragonball.backend_cc.controller;


import com.dragonball.backend_cc.model.Content;
import com.dragonball.backend_cc.repository.ContentRepository;
import com.dragonball.backend_cc.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentService service;

    public ContentController(ContentService service){
        this.service = service;
    }

    @GetMapping("")
    public List<Content> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content newContent){
        service.create(newContent);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        service.update(content,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
