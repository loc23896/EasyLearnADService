package com.easy.learn.dto.TrainerSalaryPaid;

import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaidDTO extends ResponseDTO<TrainerSalaryPaid> {
    private Long id;
    private String trainerSalaryPaidId;
    private String dataRecorded;
    private Date paymentDate;
    private Double amount;
    private String transactionType;
    private boolean paymentMethod;
    private boolean description;
    private String creditDebit;
    private boolean status;
}
