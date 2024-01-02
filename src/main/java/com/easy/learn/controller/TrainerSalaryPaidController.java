package com.easy.learn.controller;

import com.easy.learn.callApi.TrainerSalaryPaidService;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/trainersalary")
public class TrainerSalaryPaidController {
    @Autowired
    private TrainerSalaryPaidService trainerSalaryPaidService;

    @GetMapping("/list")
    public String getAllTrainerSalaryPaid(Model model) {
        model.addAttribute("listTrainerSalary", trainerSalaryService.getAllTrainerSalaryPaid());
        model.addAttribute("trainerSalaryPaidDTO", new TrainerSalaryPaidDTO()); // For form binding
        return "/pages/finance_management/list";
    }

    // Read: Display one salary
    @GetMapping("/{id}")
    public String showTrainerSalary(@PathVariable Long id, Model model) {
        model.addAttribute("salary", trainerSalaryPaidService.getTrainerSalaryPaidById(id));
        return "pages/admin/finance_managements/trainerSalaryDetail";
    }

    // Create: Show form to create a new salary
    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("salary", new TrainerSalaryPaidDTO());
        return "trainerSalaryForm";
    }

    // Create: Process the form
    @PostMapping
    public String saveTrainerSalary(@ModelAttribute TrainerSalaryPaidDTO salary, RedirectAttributes redirectAttributes) {
        trainerSalaryPaidService.createTrainerSalaryPaid(salary);
        redirectAttributes.addFlashAttribute("message", "Salary added successfully!");
        return "redirect:pages/admin/finance_managements/trainer-salary";
    }

    // Update: Show form to edit a salary
    @GetMapping("/edit/{id}")

    public String editTrainerSalaryPaid(@PathVariable Long id, Model model) {
        TrainerSalaryPaid trainerSalaryPaid = trainerSalaryService.getTrainerSalaryPaidById(id);
        model.addAttribute("trainerSalaryPaidDTO", trainerSalaryPaid);
//        List<TrainerSalaryPaid> trainerSalaryPaidList = trainerSalaryService.getAllTrainerSalaryPaid();
//        model.addAttribute("trainerSalaryPaidList", trainerSalaryPaidList);
        return "/pages/finance_management/edit";
    }

    // Update: Process the edit form
    @PostMapping("/{id}")
    public String updateTrainerSalary(@PathVariable Long id, @ModelAttribute TrainerSalaryPaidDTO salary, RedirectAttributes redirectAttributes) {
        trainerSalaryPaidService.updateTrainerSalaryPaid(salary);
        redirectAttributes.addFlashAttribute("message", "Salary updated successfully!");
        return "redirect:pages/admin/finance_managements/trainer-salary";
    }

    // Delete: Remove a salary
    @GetMapping("/delete/{id}")
    public String deleteTrainerSalary(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        trainerSalaryPaidService.deleteTrainerSalaryPaid(id);
        redirectAttributes.addFlashAttribute("message", "Salary deleted successfully!");
        return "redirect:pages/admin/finance_managements/trainer-salary";
    }
}

