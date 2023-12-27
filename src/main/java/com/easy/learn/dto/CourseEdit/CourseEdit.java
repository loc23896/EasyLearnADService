package com.easy.learn.dto.CourseEdit;

import com.easy.learn.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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
}
