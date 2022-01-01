package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.EnvirenmentRepository;
import org.eheio.projet.iot.model.Environment;
import org.eheio.projet.iot.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    @Autowired
    private EnvirenmentRepository environmentsRepository;
    @Override
    public List<Environment> getAllEnvironments() {
        return environmentsRepository.findAll();
    }

    @Override
    public Environment getUsEnvirenmenterById(UUID id) {
        return null;
    }

    @Override
    public void deleteEnvirenement(Environment environment) {

    }

    @Override
    public void addEnvironment(Environment environment) {
        environmentsRepository.save(environment);
    }

    @Override
    public void updateEnvirenemets(Environment environment) {

    }
}
