package com.cursos.modules.Course.dto;

import com.cursos.modules.Course.ActiveEnum;
import com.cursos.modules.Course.CourseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CreateCourseResponseDTO {

    private UUID id;
    private String name;
    private String category;
    private ActiveEnum active;

    public static CreateCourseResponseDTO transformDTO(CourseEntity course) {
        return new CreateCourseResponseDTO(course.getId(), course.getName(), course.getCategory(), course.getActive());
    }
}
