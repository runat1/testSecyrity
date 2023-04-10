package com.example.secyrity.service;

import com.example.secyrity.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public interface RoleService  {


    Role getRoleByName(String name);


    List<Role> getListOfRoles();
    List<Role> getAllRoles();
}
