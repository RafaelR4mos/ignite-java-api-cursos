package com.cursos.modules.Course.services;

import com.cursos.modules.Course.CourseEntity;
import com.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity create(CourseEntity courseEntity) {
            this.courseRepository.findByName(courseEntity.getName())
                    .ifPresent((user) -> {
                        throw new RuntimeException("curso já registrado");
                    });

            return this.courseRepository.save(courseEntity);
    }
}
