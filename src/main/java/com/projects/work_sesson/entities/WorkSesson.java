package com.projects.work_sesson.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkSesson {

    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;
    private LocalDate workDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double hoursWorked;

    // @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    // @JoinColumn(name = "worker_id")
    // private Worker worker;

    // public UUID getWorker() {
    // return worker.getId();
    // }
}
