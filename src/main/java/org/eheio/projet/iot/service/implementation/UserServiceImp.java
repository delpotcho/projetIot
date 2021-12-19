package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.UserRepository;
import org.eheio.projet.iot.model.User;
import org.eheio.projet.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserName(String username) throws UsernameNotFoundException{
        User user= userRepository.getUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return  user;
    }
    @Override
    public User getUserById(UUID id) throws UsernameNotFoundException{
        User user= userRepository.getById(id);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return  user;
    }



    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
