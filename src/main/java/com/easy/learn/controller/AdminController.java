package com.easy.learn.controller;

import com.easy.learn.callApi.StudentService;
import com.easy.learn.callApi.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TrainerService trainerService;
    @GetMapping("")
    public String index() {
        return "pages/admin/index";
    }

    @GetMapping("/finance/student")
    public String adminFinanceStudent() {
        return "pages/admin/finance_managements/student";
    }

    @GetMapping("/finance/trainer")
    public String adminFinanceTrainer() {
        return "pages/admin/finance_managements/trainer";
    }

    @GetMapping("/member/student")
    public String adminMemberStudent(Model model) {
        model.addAttribute("studentList", studentService.getAllStudent());
        return "pages/admin/member_managements/view_student";
    }

    @GetMapping("/member/trainer")
    public String adminMemberTrainer(Model model) {
        model.addAttribute("trainerList", trainerService.getAllTrainer());
        return "pages/admin/member_managements/view_trainer";
    }

    @GetMapping("/customerCare/student")
    public String adminCustomerCareStudent() {
        return "pages/admin/customerCare_managements/student";
    }

    @GetMapping("/customerCare/trainer")
    public String adminCustomerCareTrainer() {
        return "pages/admin/customerCare_managements/trainer";
    }


    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "pages/admin/admin_dashboard";
    }

    @GetMapping("/table")
    public String adminTable() {
        return "pages/admin/admin_table";
    }


    @GetMapping("/profile")
    public String profile() {
        return "pages/admin/admin_profile";
    }

    @GetMapping("/profile/edit")
    public String changeProfile() {
        return "pages/admin/admin_profile_edit";
    }

    //admin user profile other.
    @GetMapping("/profile-other")
    public String adminProfileOther() {
        return "pages/admin/admin_profile_other";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "pages/loginPage/login";
//    }

    @GetMapping("/register")
    public String register() {
        return "pages/loginPage/register";
    }
}








