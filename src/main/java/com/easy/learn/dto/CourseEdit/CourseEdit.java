package com.easy.learn.dto.CourseEdit;

import com.easy.learn.Enum.Status;
import com.easy.learn.dto.LessonEdit.LessonEdit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEdit implements Serializable {
    private Long id;
    private LocalDateTime lastUpdate;
    private Status status;
    private String title;
    private String description;
    private String img;
    private String file;

//    private Set<LessonEdit> lessonEdits = new HashSet<>();
}
