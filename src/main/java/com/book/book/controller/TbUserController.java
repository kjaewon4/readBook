package com.book.book.controller;

import com.book.book.entity.TbUser;
import com.book.book.repository.TbUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TbUserController {
    private final TbUserRepository userRepository;
    private final PasswordEncoder PasswordEncoder;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody TbUser tbUser) {

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
}
