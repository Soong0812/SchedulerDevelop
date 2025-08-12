package org.schedulerdevelop.Service;


import lombok.RequiredArgsConstructor;
import org.schedulerdevelop.Dto.UserRequest;
import org.schedulerdevelop.Dto.UserResponse;
import org.schedulerdevelop.Entity.User;
import org.schedulerdevelop.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse createUser(UserRequest request) {
        User user = new User(
                request.getEmail(),
                request.getUserName()
        );
        User saved = userRepository.save(user);
        return new UserResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        return new UserResponse(user);
    }

    @Transactional
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );
        user.update(request.getEmail(),  request.getUserName());
        return new UserResponse(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 유저가 없습니다.");
        }
        userRepository.deleteById(id);
    }
}
