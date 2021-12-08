package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Envirenment;
import org.eheio.projet.iot.model.Envirenment;

import java.util.List;
import java.util.UUID;

public interface EnvirenementService {
    public List<Envirenment> getAllEnvirenments();

    public Envirenment getUsEnvirenmenterById(UUID id);

    public void deleteEnvirenement(Envirenment envirenment);

    public void addEnvirenments(Envirenment envirenment);

    public void updateEnvirenemets(Envirenment envirenment);
}
