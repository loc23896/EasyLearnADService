package com.easy.learn.dto.TrainerSalaryPaid;

import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaidDTO extends ResponseDTO<TrainerSalaryPaid> {
    private Long id;
    private String trainerSalaryPaidId;
    private Integer weekNumber;
    private Integer monthNumber;
    private Integer yearNumber;
    private Double totalNumber;
}
