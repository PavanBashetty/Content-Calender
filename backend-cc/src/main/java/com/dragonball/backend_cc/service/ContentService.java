package com.dragonball.backend_cc.service;

import com.dragonball.backend_cc.model.Content;
import com.dragonball.backend_cc.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    public List<Content> findAll(){
        return repository.findAll();
    }

    public Content findById(Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    public void create(Content newContent){
        repository.save(newContent);
    }

    public void update(Content content, Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
    }

    public void delete(Integer id){
        repository.delete(id);
    }
}
