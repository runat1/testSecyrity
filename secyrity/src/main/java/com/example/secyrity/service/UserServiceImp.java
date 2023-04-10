package com.example.secyrity.service;


import com.example.secyrity.dao.UserDao;
import com.example.secyrity.model.User;
import com.example.secyrity.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private static UserDao userDao;
   private final UserRepository userRepository;

   public UserServiceImp(UserDao userDao, UserRepository userRepository) {
      this.userDao = userDao;
      this.userRepository = userRepository;
   }

   @Override
   @Transactional
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   @Transactional
   public List<User> getListOfUsers() {
      return userDao.getListOfUsers();
   }

   @Override
   @Transactional
   public void edditUser(Long id, User user) {
      userDao.edditUser(id, user);
   }

   @Override
   @Transactional
   public User getUserId(Long id) {
      return userDao.getUserId(id);
   }

   @Override
   public void deleteUserById(Long id) {
      userDao.deleteUserById(id);
   }

   @Override
   public User getUserByUsername(String name) {
      return userDao.getUserByUsername(name);
   }

   public static void addUS(User user){
      userDao.addUser(user);
   }
   @Override
   @Transactional
   public void saveUser(User user){
      user.setPassword(user.getPassword());
      userRepository.save(user);
   }
}
