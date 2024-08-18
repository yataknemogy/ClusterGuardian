package com.example.clusterguardian.controller;

import com.example.clusterguardian.model.ClusterNode;
import com.example.clusterguardian.service.ClusterNodeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClusterNodeControllerTest {

    @Mock
    private ClusterNodeService clusterNodeService;

    @InjectMocks
    private ClusterNodeController clusterNodeController;

    public ClusterNodeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    public static final String ANSI_GREEN = "\u001B[32m";

    @Test
    public void testAddNode_Success() {
        ClusterNode clusterNode = new ClusterNode();
        clusterNode.setId(1L);
        clusterNode.setIpAddress("192.168.0.1");
        clusterNode.setRole(ClusterNode.Role.MASTER);
        clusterNode.setStatus(ClusterNode.Status.ACTIVE);

        when(clusterNodeService.addNode(clusterNode)).thenReturn(clusterNode);

        ClusterNode result = clusterNodeController.addNode(clusterNode);

        assertEquals(1L, result.getId());
        assertEquals("192.168.0.1", result.getIpAddress());
        assertEquals(ClusterNode.Role.MASTER, result.getRole());
        assertEquals(ClusterNode.Status.ACTIVE, result.getStatus());
    }
}