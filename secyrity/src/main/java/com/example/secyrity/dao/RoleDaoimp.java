package com.example.secyrity.dao;

import com.example.secyrity.model.Role;
import com.example.secyrity.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class RoleDaoimp implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String name) {
        Query query = entityManager.createQuery("select role from Role role where Role .name= :name", Role.class);
        query.setParameter("name", name);
        return (Role) query.getSingleResult();
    }

@Override
public List<Role> getListOfRoles() {
    return entityManager.createQuery("select role from Role role", Role.class).getResultList();
}
}
