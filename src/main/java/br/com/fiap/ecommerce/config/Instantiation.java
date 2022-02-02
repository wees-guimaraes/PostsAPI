package br.com.fiap.ecommerce.config;

import br.com.fiap.ecommerce.domain.Post;
import br.com.fiap.ecommerce.domain.User;
import br.com.fiap.ecommerce.dto.AuthorDTO;
import br.com.fiap.ecommerce.repository.PostRepository;
import br.com.fiap.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Gray", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        AuthorDTO authorDTO1 = new AuthorDTO(maria);

        Post post1 = new Post();
        post1.setDate(LocalDate.of(2021, 11, 24));
        post1.setTitle("Partiu viagem");
        post1.setBody("Vou viajar para São Paulo. Abraços!");
        post1.setAuthor(authorDTO1);

        Post post2 = new Post(null, "Bom dia", "Acordei Feliz hoje!", LocalDate.of(2022, 02, 01), authorDTO1);

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
