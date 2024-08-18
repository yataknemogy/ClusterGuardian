package com.example.clusterguardian.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class BackupService {

    public void backupDatabase(String backupFilePath) throws Exception {
        String command = String.format("pg_dump -U postgres -F c -b -v -f %s postgres", backupFilePath);
        executeCommand(command);
    }

    public void restoreDatabase(String backupFilePath) throws Exception {
        String command = String.format("pg_restore -U postgres -d postgres -v %s", backupFilePath);
        executeCommand(command);
    }

    private void executeCommand(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;

        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new Exception("Proccess failed with exit code " + exitCode);
        }
    }
}