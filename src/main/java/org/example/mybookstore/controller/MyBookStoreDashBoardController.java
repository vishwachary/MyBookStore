package org.example.mybookstore.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class MyBookStoreDashBoardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal
                                OAuth2User oauthUser, Model model) {
        if (oauthUser != null) {
            model.addAttribute("name", oauthUser.getAttribute("name"));
            model.addAttribute("email", oauthUser.getAttribute("email"));
        }
        return "dashboard"; // resolves to dashboard.html
    }
}
