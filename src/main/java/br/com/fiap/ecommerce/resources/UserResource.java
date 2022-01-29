package br.com.fiap.ecommerce.resources;

import br.com.fiap.ecommerce.domain.User;
import br.com.fiap.ecommerce.dto.UserDTO;
import br.com.fiap.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listUserDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        listUserDTO.forEach(l -> System.out.println(l));

        return ResponseEntity.ok().body(listUserDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User userEntity = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(userEntity));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
        User userEntity = service.insert(service.fromDTO(userDTO));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userEntity.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        User userEntity = service.fromDTO(userDTO);
        userEntity.setId(id);
        service.update(userEntity);
        return ResponseEntity.noContent().build();
    }

}
