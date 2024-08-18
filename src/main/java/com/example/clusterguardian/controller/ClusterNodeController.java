package com.example.clusterguardian.controller;

import com.example.clusterguardian.model.ClusterNode;
import com.example.clusterguardian.service.ClusterNodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nodes")
public class ClusterNodeController {

    private static final Logger logger = LoggerFactory.getLogger(ClusterNodeController.class);

    private final ClusterNodeService clusterNodeService;

    @Autowired
    public ClusterNodeController(ClusterNodeService clusterNodeService) {
        this.clusterNodeService = clusterNodeService;
    }

    @GetMapping
    public List<ClusterNode> getAllNodes() {
        try {
            List<ClusterNode> nodes = clusterNodeService.getAllNodes();
            if (nodes.isEmpty()) {
                logger.info("No nodes found!");
            }
            return nodes;
        } catch (Exception e) {
            logger.error("Error while fetching nodes: " + e.getMessage());
            return List.of();
        }
    }

    @GetMapping("/{id}")
    public Optional<ClusterNode> getNodeById(@PathVariable Long id) {
        try {
            Optional<ClusterNode> node = clusterNodeService.getNodeByid(id);
            if (node.isEmpty()) {
                logger.info("Node with id " + id + " not found!");
            }
            return node;
        } catch (Exception e) {
            logger.error("Error while fetching node with id " + id + ": " + e.getMessage());
            return Optional.empty();
        }
    }

    @PostMapping
    public ClusterNode addNode(@RequestBody ClusterNode clusterNode) {
        try {
            ClusterNode addedNode = clusterNodeService.addNode(clusterNode);
            logger.info("Node added successfully with id " + addedNode.getId());
            return addedNode;
        } catch (Exception e) {
            logger.error("Error while adding node: " + e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id) {
        try {
            clusterNodeService.deleteNode(id);
            logger.info("Node with id " + id + " deleted successfully.");
        } catch (Exception e) {
            logger.error("Error while deleting node with id " + id + ": " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void updateNode(@PathVariable Long id, @RequestBody ClusterNode clusterNodeDetails) {
        try {
            clusterNodeService.updateNode(id, clusterNodeDetails);
            logger.info("Node with id " + id + " updated successfully.");
        } catch (Exception e) {
            logger.error("Error while updating node with id " + id + ": " + e.getMessage());
        }
    }
}
