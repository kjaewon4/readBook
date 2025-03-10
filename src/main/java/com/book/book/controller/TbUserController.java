package com.book.book.controller;

import com.book.book.entity.TbUser;
import com.book.book.repository.TbUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TbUserController {
    private final TbUserRepository userRepository;
    private final PasswordEncoder PasswordEncoder;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody TbUser tbUser) {
        Optional<TbUser> result = userRepository.findByUserName("jw");

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("사용자를 찾을 수 없습니다.");
        }

        return "";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody TbUser tbUser) {
        TbUser User = new TbUser();
        var hashPassword = passwordEncoder.encode((tbUser.getUserPassword()));

        tbUser.setUserName(tbUser.getUserName());
        tbUser.setUserPassword(hashPassword);

        userRepository.save(tbUser);

        return "";
    }

    @GetMapping("/bookmark")
    public void bookmark(Authentication auth) {
        System.out.println(auth.getPrincipal());
        System.out.println(auth.getName());
    }
    @GetMapping("/")
    public void home(Authentication auth) {
        if (auth != null) {
            System.out.println(auth.getPrincipal());  // 로그인한 경우
            System.out.println(auth.getName());  // 로그인한 경우
        } else {
            System.out.println("로그인되지 않은 사용자입니다.");
        }

    }
}
