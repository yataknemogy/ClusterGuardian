package com.example.clusterguardian.service;

import com.example.clusterguardian.model.ClusterNode;
import com.example.clusterguardian.repository.ClusterNodeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NodeMonitorService {

    private final ClusterNodeRepository clusterNodeRepository;

    public NodeMonitorService(ClusterNodeRepository clusterNodeRepository) {
        this.clusterNodeRepository = clusterNodeRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void monitorNodes() {
        List<ClusterNode> nodes = clusterNodeRepository.findAll();

        for (ClusterNode node : nodes) {
            String url = "http://" + node.getIpAddress() + ":8080/api/health";
            RestTemplate restTemplate = new RestTemplate();
            try {
                String status = restTemplate.getForObject(url, String.class);
                node.setStatus(ClusterNode.Status.valueOf(status));
            } catch (Exception e) {
                node.setStatus(ClusterNode.Status.FAILED);
            }
            clusterNodeRepository.save(node);
        }
    }
}