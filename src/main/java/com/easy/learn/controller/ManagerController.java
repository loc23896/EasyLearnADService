package com.easy.learn.controller;

import com.easy.learn.callApi.ManagerService;
import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.Manager.Manager;
import com.easy.learn.dto.Manager.ManagerDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import javax.jws.WebParam;
//import java.util.List;
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
    public String processRegister(ManagerDTO managerDTO) {
        managerService.create(managerDTO);

        return "pages/loginPage/register_success";
    }
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("manager", new Manager());
        return "pages/loginPage/login";
    }

    @PostMapping("/process_login")
    public String processLoginPage(@ModelAttribute("manager") ManagerDTO managerDTO, Model model) {
        String username = managerDTO.getUsername();
        String password = managerDTO.getPassword();
            ManagerDTO authenticatedManager = managerService.signIn(username, password);

            if (authenticatedManager.getData()!=null && authenticatedManager.getData().getId()!=null) {
                return "pages/admin/index";
            } else {
                model.addAttribute("error", "Username không tồn tại hoặc mật khẩu sai.");
                return "pages/loginPage/login";
            }

    }


    @GetMapping("/admin/index")
    public String showAdminIndexPage() {
        return  "pages/admin/index";
    }



}