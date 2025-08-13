package org.schedulerdevelop.Service;

import lombok.RequiredArgsConstructor;
import org.schedulerdevelop.Dto.LoginRequest;
import org.schedulerdevelop.Dto.LoginResponse;
import org.schedulerdevelop.Entity.User;
import org.schedulerdevelop.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(LoginRequest request) {
        User user = new User(
                request.getEmail(),
                request.getUserName(),
                request.getPassword()
        );
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("없는 E-mail입니다.")
        );

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginResponse(user.getId());
    }
}
