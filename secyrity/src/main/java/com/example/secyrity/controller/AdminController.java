package com.example.secyrity.controller;

import com.example.secyrity.model.Role;
import com.example.secyrity.model.User;
import com.example.secyrity.service.RoleService;
import com.example.secyrity.service.UserService;
import com.example.secyrity.service.UserServiceDatails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserServiceDatails userServiceDatails;

    public AdminController(UserService userService, RoleService roleService, UserServiceDatails userServiceDatails) {
        this.userService = userService;
        this.roleService = roleService;
        this.userServiceDatails = userServiceDatails;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getListOfUsers());
        return "Admin/admin-all-user";
    }
    @GetMapping("/AdmimNewUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList",roleService.getAllRoles());
        return "Admin/admin-NewUser";
    }
    @PatchMapping
    public String edditUser(@ModelAttribute("user") User user,
                            @PathVariable("id") Long id) {
        userService.edditUser( id, user);
        return "redirect:/admin";
    }
    @PostMapping
    public String creatNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUsers(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
    @GetMapping("/{id}/getUser")
    public String getUserId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "Admin/removeUser";
    }
    @PostMapping("/createNewUser")
    public String createUser(@ModelAttribute("user") User user) {
        List<Role> listRoles = new ArrayList<>();
        for (Role role : user.getRoleList()) {
            listRoles.add(roleService.getRoleByName(role.getName()));
        }
        user.setRoleList(listRoles);
        userService.addUser(user);
        return "redirect:/admin";
    }
}
