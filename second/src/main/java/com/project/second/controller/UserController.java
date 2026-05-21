package com.project.second.controller;

import com.project.second.dtos.*;
import com.project.second.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register/admin")
    public String registerAdmin(@RequestBody AdminRequest request) {
        return userService.registerAdmin(request);
    }

    @PostMapping("/register/owner")
    public String registerOwner(@RequestBody OwnerRegistrationRequest request) {
        return userService.registerOwner(request);
    }

    @PostMapping("/register/manager")
    public String registerManager(@RequestBody ManagerRequest request) {
        return userService.registerManager(request);
    }

    @PostMapping("/register/chef")
    public String registerChef(@RequestBody ChefRequest request) {
        return userService.registerChef(request);
    }

    @PostMapping("/register/waiter")
    public String registerWaiter(@RequestBody WaiterRequest request) {
        return userService.registerWaiter(request);
    }
}
