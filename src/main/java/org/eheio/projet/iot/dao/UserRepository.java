package org.eheio.projet.iot.dao;

import org.eheio.projet.iot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
