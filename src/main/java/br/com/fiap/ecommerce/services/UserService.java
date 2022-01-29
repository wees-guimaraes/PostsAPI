package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.domain.User;
import br.com.fiap.ecommerce.dto.UserDTO;
import br.com.fiap.ecommerce.repository.UserRepository;
import br.com.fiap.ecommerce.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> optionalUser = repository.findById(id);

        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    /**
     * @param id
     */
    public void delete(String id){
        this.findById(id);
        repository.deleteById(id);
    }

    public void update(User user){
        this.findById(user.getId());
        repository.save(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }


}
