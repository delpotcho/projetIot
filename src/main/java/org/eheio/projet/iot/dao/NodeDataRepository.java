package org.eheio.projet.iot.dao;

import org.eheio.projet.iot.model.Node;
import org.eheio.projet.iot.model.NodeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface NodeDataRepository extends JpaRepository<NodeData,Long> {
     List<NodeData> getNodeDataByDateTimeBetween(LocalDateTime date1, LocalDateTime date2);
     NodeData getTopByOrderByDateTimeDesc();
     NodeData getTopByNodeIdOrderByDateTimeDesc(UUID id);
}
