package com.cursos.modules.Course.services;

import com.cursos.modules.Course.CourseEntity;
import com.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ListCourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseEntity> findAll() {
        return this.courseRepository.findAll();
    }

    public Optional<List<CourseEntity>> ListByNameOrCategory(String name, String category) {
        return this.courseRepository.findAllByNameOrCategory(name, category);
    }

    public CourseEntity findByID(UUID id) {
        return this.courseRepository.findById(id).orElseThrow();
    }
}
