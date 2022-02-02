package br.com.fiap.ecommerce.config;

import br.com.fiap.ecommerce.domain.Post;
import br.com.fiap.ecommerce.domain.User;
import br.com.fiap.ecommerce.dto.AuthorDTO;
import br.com.fiap.ecommerce.dto.CommentDTO;
import br.com.fiap.ecommerce.repository.PostRepository;
import br.com.fiap.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Gray", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        AuthorDTO authorDTO1 = new AuthorDTO(maria);

        CommentDTO comment1 = new CommentDTO("Boa viagem, mano!", LocalDate.now(), new AuthorDTO(alex));

        CommentDTO comment2 = new CommentDTO("Aproveite!", LocalDate.now(), new AuthorDTO(bob));

        List<CommentDTO> listComments1 = new ArrayList<>(Arrays.asList(comment1, comment2));

        List<CommentDTO> listComments2 = new ArrayList<>();

        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.now(), new AuthorDTO(alex));

        listComments2.add(comment3);

        Post post1 = new Post();
        post1.setDate(LocalDate.of(2021, 11, 24));
        post1.setTitle("Partiu viagem");
        post1.setBody("Vou viajar para São Paulo. Abraços!");
        post1.setAuthor(authorDTO1);
        post1.setCommentDTOList(listComments1);

        Post post2 = new Post(null, "Bom dia", "Acordei Feliz hoje!", LocalDate.of(2022, 2, 1), authorDTO1, listComments2);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);


    }
}
