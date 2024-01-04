package br.com.srcjp.blog.repository;

import br.com.srcjp.blog.dto.UserDto;
import br.com.srcjp.blog.dto.UserReadDto;
import br.com.srcjp.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
