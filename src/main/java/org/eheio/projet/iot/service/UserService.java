package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(UUID id);

    public void deleteUser(User user);

    public void addUser(User user);

    public void updateUser(User user);


}
