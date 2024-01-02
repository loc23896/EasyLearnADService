package com.easy.learn.dto.CourseEdit;

import com.easy.learn.Enum.Status;
import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.LessonEdit.LessonEdit;
import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEditDTO extends ResponseDTO<CourseEdit> {
    private Long id;
    private LocalDateTime lastUpdate;
    private Status status;
    private String title;
    private String description;
    private String img;

//    private Set<LessonEdit> lessonEdits = new HashSet<>();
}
