package se.kth.sda.skeleton.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Post> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Post create(@RequestBody Post newPost) {
        return service.create(newPost);
    }

    @PutMapping("")
    public Post update(@RequestBody Post updatedPost) {
        return service.update(updatedPost);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
