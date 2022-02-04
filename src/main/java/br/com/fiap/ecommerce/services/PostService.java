package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.domain.Post;
import br.com.fiap.ecommerce.repository.PostRepository;
import br.com.fiap.ecommerce.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> optPost = repository.findById(id);

        return optPost.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
    }

    public List<Post> findByTitle(String text){

        return repository.findByTitleContainingIgnoreCase(text);
    }


}
