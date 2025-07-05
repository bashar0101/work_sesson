package com.projects.work_sesson.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.work_sesson.entities.WorkSesson;

@Repository
public interface WorkSessonRepo extends JpaRepository<WorkSesson, UUID> {

}
