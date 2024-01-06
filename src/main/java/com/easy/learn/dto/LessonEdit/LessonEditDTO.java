package com.easy.learn.dto.LessonEdit;

//import com.easy.learn.Enum.Status;
//import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonEditDTO extends ResponseDTO<LessonEditDTO> {
    private Long id;
    private Long number;
    private String title;
    private LocalDateTime lastUpdate;
    private String video;
    private String test;
    private Integer duration;

    private Long courseEditId;

}
