package com.easy.learn.controller;

import com.easy.learn.callApi.TrainerSalaryService;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaid;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trainersalary")
public class TrainerSalaryPaidController {

    @Autowired
    private TrainerSalaryService trainerSalaryService;

    @GetMapping("/list")
    public String getAllTrainerSalaryPaid(Model model) {
        model.addAttribute("trainerSalaryPaidList", trainerSalaryService.getAllTrainerSalaryPaid());
        model.addAttribute("trainerSalaryPaidDTO", new TrainerSalaryPaidDTO()); // For form binding
        return "/pages/finance_management/list";
    }

    @PostMapping("/save")
    public String saveTrainerSalaryPaid(@ModelAttribute("trainerSalaryPaidDTO") TrainerSalaryPaidDTO trainerSalaryPaidDTO ) {
        if (trainerSalaryPaidDTO.getId() == null) {

            trainerSalaryService.createTrainerSalaryPaid(trainerSalaryPaidDTO);
        } else {

            trainerSalaryService.updateTrainerSalaryPaid(trainerSalaryPaidDTO);

        }
        return "redirect:/trainersalary/list";
    }

    @GetMapping("/view/{id}")
    public String viewTrainerSalaryPaid(@PathVariable Long id, Model model) {
        TrainerSalaryPaid trainerSalaryPaid = trainerSalaryService.getTrainerSalaryPaidById(id);
        model.addAttribute("trainerSalaryPaidDTO", trainerSalaryPaid);
        return "/pages/finance_management/view";
    }

    @GetMapping("/edit/{id}")
    public String editTrainerSalaryPaid(@PathVariable Long id, Model model) {
        TrainerSalaryPaid trainerSalaryPaid = trainerSalaryService.getTrainerSalaryPaidById(id);
        model.addAttribute("trainerSalaryPaidDTO", trainerSalaryPaid);
        List<TrainerSalaryPaid> trainerSalaryPaidList = trainerSalaryService.getAllTrainerSalaryPaid();
        model.addAttribute("trainerSalaryPaidList", trainerSalaryPaidList);
        return "/pages/finance_management/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainerSalaryPaid(@PathVariable Long id) {
        trainerSalaryService.deleteTrainerSalaryPaid(id);
        return "redirect:/trainersalary/list";
    }


}
