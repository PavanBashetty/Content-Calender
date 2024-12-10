package com.dragonball.backend_cc.repository;

import com.dragonball.backend_cc.model.Content;
import com.dragonball.backend_cc.model.Status;
import com.dragonball.backend_cc.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentRepository(){

    }

    public List<Content> findAll(){
        return contents;
    }

    public Optional<Content> findById(Integer id){
        return contents.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content(
                1,
                "My first blog post",
                "blog on spring",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contents.add(c);
    }

    public void save(Content newContent) {
        contents.removeIf(c->c.id().equals(newContent.id()));
        contents.add(newContent);
    }

    public boolean existsById(Integer id) {
        return contents.stream().filter(c->c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contents.removeIf(c->c.id().equals(id));
    }
}
