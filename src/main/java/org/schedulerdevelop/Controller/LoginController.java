package org.schedulerdevelop.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.schedulerdevelop.Dto.LoginRequest;
import org.schedulerdevelop.Dto.LoginResponse;
import org.schedulerdevelop.Service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/signup")
    public String signup(
            @RequestBody LoginRequest request
    ) {
        loginService.signup(request);
        return "회원 가입에 성공하였습니다";
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest loginRequest,
            HttpServletRequest request
    ) {
        LoginResponse result = loginService.login(loginRequest);

        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_USER", result.getId());
        return "로그인에 성공하였습니다.";
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
