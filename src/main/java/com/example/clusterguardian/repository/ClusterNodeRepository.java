package com.example.clusterguardian.repository;

import com.example.clusterguardian.model.ClusterNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClusterNodeRepository extends JpaRepository<ClusterNode, Long> {
    Optional<ClusterNode> findByIpAddress(String ipAddress);
}
