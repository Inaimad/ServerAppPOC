package com.hsbc.serverapp.controller;

import com.hsbc.serverapp.domain.User;
import com.hsbc.serverapp.service.AuthenticationService;
import com.hsbc.serverapp.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Main Controller of the app
 */
@Controller
public class MvcController {

    private final AuthenticationService authenticationService;
    private final ServerService serverService;

    @Autowired
    public MvcController(final AuthenticationService authenticationService,
                         final ServerService serverService) {
        this.authenticationService = authenticationService;
        this.serverService = serverService;
    }

    @GetMapping({"/", ""})
    public String homePage(Model model) {
        model.addAttribute("user", new User());
        return "logon";
    }

    @PostMapping({"/", ""})
    public String loginSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("serverList", serverService.getAllServers());
        model.addAttribute("serverService", serverService);
        return authenticationService.authenticateUser(user) ? "mainPage" : "logon";
    }
}
