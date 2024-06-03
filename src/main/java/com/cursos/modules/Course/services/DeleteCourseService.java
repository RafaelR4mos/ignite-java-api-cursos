package com.cursos.modules.Course.services;

import com.cursos.modules.Course.CourseEntity;
import com.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteCourseService {

    @Autowired
    CourseRepository courseRepository;

    public void delete(CourseEntity course) {
            this.courseRepository.delete(course);
    }
}
