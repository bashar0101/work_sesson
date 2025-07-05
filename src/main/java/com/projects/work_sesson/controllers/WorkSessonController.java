package com.projects.work_sesson.controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.work_sesson.entities.WorkSesson;
import com.projects.work_sesson.repositories.WorkSessonRepo;

@CrossOrigin(origins = "https://bashar0101.github.io")
@RestController
@RequestMapping("/api/v1/worksesson")
public class WorkSessonController {

    private LocalDateTime startTime;
    @Autowired
    private WorkSessonRepo workSessonRepo;

    @PostMapping("/start")
    public void startWork() {
        startTime = LocalDateTime.now();
    }

    @PostMapping("/end")
    public void endWork() {
        if (startTime == null)
            throw new IllegalStateException("Start time not set");

        LocalDateTime endTime = LocalDateTime.now();
        double hours = Duration.between(startTime, endTime).toMinutes() / 60.0;

        WorkSesson session = new WorkSesson();
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        session.setHoursWorked(hours);
        session.setWorkDate(LocalDate.now()); // 👈 التاريخ الحالي

        workSessonRepo.save(session);
        startTime = null;
    }

    @GetMapping
    public List<WorkSesson> getAllSessions() {
        return workSessonRepo.findAll();
    }
}
