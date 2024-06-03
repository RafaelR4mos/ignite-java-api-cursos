package com.cursos.modules.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    public Optional<List<CourseEntity>> findAllByNameOrCategory(String name, String category);
    public Optional <CourseEntity> findByName(String name);
}
