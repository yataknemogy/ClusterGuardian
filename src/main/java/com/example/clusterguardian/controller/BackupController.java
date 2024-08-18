package com.example.clusterguardian.controller;

import com.example.clusterguardian.service.BackupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backup")
public class BackupController {

    private static final Logger logger = LoggerFactory.getLogger(BackupController.class);

    private final BackupService backupService;

    @Autowired
    public BackupController(BackupService backupService) {
        this.backupService = backupService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBackup(@RequestParam String backUpFilePath) {
        try {
            if(backUpFilePath == null || backUpFilePath.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Backup file path musn't be empty!");
            }

            backupService.backupDatabase(backUpFilePath);
            logger.info("Backup created successfully at: " +backUpFilePath);
            return ResponseEntity.ok("Backup created successfully!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Backup failed: " + e.getMessage());
        }
    }

    @PostMapping("/restore")
    public ResponseEntity<String> restoreBackup(@RequestParam String backUpFilePath) {
        try {
            if(backUpFilePath == null || backUpFilePath.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Backup file path musn't be empty!");
            }

            backupService.restoreDatabase(backUpFilePath);
            logger.info("Backup restored successfully from: " +backUpFilePath);
            return ResponseEntity.ok("Backup restored successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Restore failed: " + e.getMessage());
        }
    }
}