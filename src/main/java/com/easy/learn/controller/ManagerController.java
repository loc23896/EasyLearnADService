package com.easy.learn.controller;

import com.easy.learn.callApi.ManagerService;
import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.Manager.Manager;
import com.easy.learn.dto.Manager.ManagerDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("managerDTO", new ManagerDTO());
        return "pages/loginPage/register";
    }
    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute("managerDTO") ManagerDTO managerDTO) {
        if (managerDTO.getId() == null) {
            managerService.create(managerDTO);
        } else {
            managerService.update(managerDTO);
        }
        return "pages/loginPage/register_success";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "pages/loginPage/login";
    }
    @PostMapping("/process_login")
    public String processLoginPage(@ModelAttribute("form") ManagerDTO managerDTO) {
        if(managerDTO.getUserName() != null){
            managerService.login(managerDTO.getUserName(),managerDTO.getPassword());

        } else {
            return "pages/loginPage/login";
        }
        return "pages/admin/index";
    }
    @GetMapping("/managers")
    public String listUsers(Model model) {
        List<Manager> listManager = managerService.getAllManager();
        model.addAttribute("listManager", listManager);

        return "managers";
    }

    @GetMapping("/admin/index")
    public String showAdminIndexPage() {
        return  "pages/admin/index";
    }



}