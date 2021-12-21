package org.eheio.projet.iot.dao;

import org.eheio.projet.iot.dto.request.NodeDto;
import org.eheio.projet.iot.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NodeRepsitory extends JpaRepository<NodeDto,UUID>{
}
