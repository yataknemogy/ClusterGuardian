package com.example.clusterguardian.service;

import com.example.clusterguardian.model.ClusterNode;
import com.example.clusterguardian.repository.ClusterNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ClusterNodeService {

    private final ClusterNodeRepository clusterNodeRepository;

    @Autowired
    public ClusterNodeService(ClusterNodeRepository clusterNodeRepository) {
        this.clusterNodeRepository = clusterNodeRepository;
    }

    @GetMapping
    public List<ClusterNode> getAllNodes() {
        return clusterNodeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClusterNode> getNodeByid(@PathVariable Long id) {
        return clusterNodeRepository.findById(id);
    }

    @PostMapping
    public ClusterNode addNode(@RequestBody ClusterNode clusterNode) {
        return clusterNodeRepository.save(clusterNode);
    }

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id) {
        clusterNodeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateNode(@PathVariable Long id, @RequestBody ClusterNode clusterNodeDetails) {
        clusterNodeRepository.findById(id).map(clusterNode -> {
            clusterNode.setIpAddress(clusterNodeDetails.getIpAddress());
            clusterNode.setRole(clusterNodeDetails.getRole());
            clusterNode.setStatus(clusterNodeDetails.getStatus());
            return clusterNodeRepository.save(clusterNode);
        }).orElseThrow(() -> new IllegalArgumentException("ClusterNode not found with id " + id));
    }
}