package com.cursos.modules.Course.services;

import com.cursos.modules.Course.CourseEntity;
import com.cursos.modules.Course.CourseRepository;
import com.cursos.modules.Course.dto.EditCourseRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EditCourseService {

    @Autowired
    CourseRepository courseRepository;

    public CourseEntity editCourse(UUID id, EditCourseRequestDTO editedCourse) {
        CourseEntity course = this.courseRepository.findById(id).orElseThrow();

        course.setName(editedCourse.name());
        course.setCategory(editedCourse.category());

        this.courseRepository.save(course);
        return course;
    }
}
