package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.EnvirenmentRepository;
import org.eheio.projet.iot.model.Envirenment;
import org.eheio.projet.iot.service.EnvirenementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EnvirenementServiceImpl implements EnvirenementService {
    @Autowired
    private EnvirenmentRepository envirenmentRepository;
    @Override
    public List<Envirenment> getAllEnvirenments() {
        return null;
    }

    @Override
    public Envirenment getUsEnvirenmenterById(UUID id) {
        return null;
    }

    @Override
    public void deleteEnvirenement(Envirenment envirenment) {

    }

    @Override
    public void addEnvirenments(Envirenment envirenment) {

    }

    @Override
    public void updateEnvirenemets(Envirenment envirenment) {

    }
}
