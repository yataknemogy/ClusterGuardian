package com.example.clusterguardian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BackupScheduler {

    private final BackupService backupService;

    @Autowired
    public BackupScheduler(BackupService backupService) {
        this.backupService = backupService;
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void scheduleBackup() {
        try {
            backupService.backupDatabase("path/to/backup/file.dump");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
