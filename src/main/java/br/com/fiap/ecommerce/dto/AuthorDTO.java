package br.com.fiap.ecommerce.dto;

import br.com.fiap.ecommerce.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;


    public AuthorDTO() {
    }

    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
