package com.cursos.modules.Course.services;

import com.cursos.modules.Course.CourseEntity;
import com.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity create(CourseEntity courseEntity) {
            this.courseRepository.findByName(courseEntity.getName())
                    .ifPresent((user) -> {
                        throw new RuntimeException("curso já registrado");
                    });

            courseEntity.setName(courseEntity.getName().toLowerCase());
            courseEntity.setCategory(courseEntity.getCategory().toLowerCase());

            return this.courseRepository.save(courseEntity);
    }
}
