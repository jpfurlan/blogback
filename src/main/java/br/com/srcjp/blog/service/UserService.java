package br.com.srcjp.blog.service;

import br.com.srcjp.blog.dto.UserDto;
import br.com.srcjp.blog.dto.UserReadDto;
import br.com.srcjp.blog.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.srcjp.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserReadDto createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user = userRepository.save(user);
        UserReadDto userReadDto = new UserReadDto();
        BeanUtils.copyProperties(user, userReadDto);
        return userReadDto;
    }

    public UserReadDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        UserReadDto userReadDto = new UserReadDto();
        BeanUtils.copyProperties(user, userReadDto);
        return userReadDto;
    }

    public UserReadDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        BeanUtils.copyProperties(userDto, user);
        user = userRepository.save(user);
        UserReadDto userReadDto = new UserReadDto();
        BeanUtils.copyProperties(user, userReadDto);
        return userReadDto;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
