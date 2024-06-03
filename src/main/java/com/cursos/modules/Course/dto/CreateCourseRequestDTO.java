package com.cursos.modules.Course.dto;

import com.cursos.modules.Course.ActiveEnum;
import com.cursos.modules.Course.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCourseRequestDTO {
    private String name;
    private String category;

    public CourseEntity transformDTO() {
        return new CourseEntity(this.name, this.category);
    }
}
