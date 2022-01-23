package org.eheio.projet.iot.dao;

import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface NodeRepsitory extends JpaRepository<Node,UUID>{

    @Query("SELECT n FROM Node n where n.id = :id")
    Node findOneByUUID(@Param("id") UUID id);


}
