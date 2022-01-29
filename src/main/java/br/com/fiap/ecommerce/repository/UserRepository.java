package br.com.fiap.ecommerce.repository;

import br.com.fiap.ecommerce.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
