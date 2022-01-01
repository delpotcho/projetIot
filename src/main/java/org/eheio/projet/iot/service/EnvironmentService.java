package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Environment;

import java.util.List;
import java.util.UUID;

public interface EnvironmentService {
    public List<Environment> getAllEnvironments();

    public Environment getUsEnvirenmenterById(UUID id);

    public void deleteEnvirenement(Environment environment);


    public void updateEnvirenemets(Environment environment);

    void addEnvironment(Environment environment);
}
