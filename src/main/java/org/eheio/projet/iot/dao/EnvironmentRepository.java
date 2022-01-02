package org.eheio.projet.iot.dao;

import org.eheio.projet.iot.model.Environment;
import org.eheio.projet.iot.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EnvironmentRepository extends JpaRepository<Environment,UUID>{
    @Query("SELECT e FROM Environment e where e.ID = :id")
    Environment findOneByUUID(@Param("id") UUID id);
}
