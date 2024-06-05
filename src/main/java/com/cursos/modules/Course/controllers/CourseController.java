package com.cursos.modules.Course.controllers;

import com.cursos.modules.Course.CourseEntity;
import com.cursos.modules.Course.CourseRepository;
import com.cursos.modules.Course.dto.CreateCourseRequestDTO;
import com.cursos.modules.Course.dto.CreateCourseResponseDTO;
import com.cursos.modules.Course.dto.EditCourseRequestDTO;
import com.cursos.modules.Course.services.CreateCourseService;
import com.cursos.modules.Course.services.DeleteCourseService;
import com.cursos.modules.Course.services.EditCourseService;
import com.cursos.modules.Course.services.ListCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CreateCourseService createCourseService;

    @Autowired
    ListCourseService listCourseService;

    @Autowired
    DeleteCourseService deleteCourseService;

    @Autowired
    EditCourseService editCourseService;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<Object> list(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        if (name != null || category != null) {
            Optional<List<CourseEntity>> courses = this.listCourseService.ListByNameOrCategory(name != null ? name : "", category != null ? category : "");
            return ResponseEntity.ok().body(courses);
        }

        List<CourseEntity> result = this.listCourseService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<CreateCourseResponseDTO> create(@Valid @RequestBody CreateCourseRequestDTO createCourseDTO) {
        CourseEntity course = this.createCourseService.create(createCourseDTO.transformDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateCourseResponseDTO.transformDTO(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseEntity> edit(@PathVariable UUID id, @RequestBody EditCourseRequestDTO editedCourse) {
       return ResponseEntity.ok().body(this.editCourseService.editCourse(id, editedCourse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        CourseEntity course = this.listCourseService.findByID(id);
        this.deleteCourseService.delete(course);

        return ResponseEntity.ok().body("Curso " + course.getId() + " deletado com sucesso.");
    }
}
