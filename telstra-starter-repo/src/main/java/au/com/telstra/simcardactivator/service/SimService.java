package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.model.ActivationResult;
import au.com.telstra.simcardactivator.model.SimCard;
import au.com.telstra.simcardactivator.repository.SimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimService {

    @Autowired
    private SimRepository simRepository;
    private RestTemplate restTemplate;
    private String incentiveApiUrl;

    @Autowired
    public SimService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.incentiveApiUrl = "http://localhost:8081/api/v1/rica";
    }

    public ActivationResult registerSim(SimCard simCard){
        SimCard sim = simRepository.save(simCard);
        return restTemplate.postForObject(incentiveApiUrl, simCard, ActivationResult.class);
    }

}
