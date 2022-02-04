package br.com.fiap.ecommerce.resources;

import br.com.fiap.ecommerce.domain.Post;
import br.com.fiap.ecommerce.resources.util.ResourcesUtil;
import br.com.fiap.ecommerce.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitleText(@RequestParam(value = "text", defaultValue = "") String text) {
        List<Post> postList = service.findByTitle(ResourcesUtil.decodeParam(text));
        return ResponseEntity.ok().body(postList);
    }



}
