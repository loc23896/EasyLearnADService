package com.easy.learn.controller;

import com.easy.learn.callApi.CourseEditService;
import com.easy.learn.callApi.TrainerSalaryService;
import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.CourseEdit.CourseEditDTO;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaid;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaidDTO;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/adminTrainer")
public class AdminTrainerController {

    @Autowired
    private CourseEditService courseEditService;

    @GetMapping("")
    public String adminTrainerIndex (Model model){
        model.addAttribute("courseEditList", courseEditService.getAllCourseEdit());
        model.addAttribute("courseEditDTO", new CourseEditDTO());
        return "pages/admin/admin_trainer/index";
    }

    //start add form admin_trainer COURSE btn
    @PostMapping("/addCourseForm")
    public String addCourseForm (
            @ModelAttribute("courseEditDTO") CourseEditDTO courseEditDTO,
            @RequestParam("imgCourseEdit") MultipartFile imgCourseEdit){
        if (imgCourseEdit.isEmpty()){
            return "redirect:/adminTrainer";
        }
        try {
            Path path = Paths.get("src/main/resources/static/img/course");
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            InputStream inputStream = imgCourseEdit.getInputStream();
            Files.copy(inputStream, path.resolve(imgCourseEdit.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            courseEditDTO.setImg(imgCourseEdit.getOriginalFilename().toLowerCase());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(courseEditDTO.getId() == null){
            courseEditService.createCourseEdit(courseEditDTO);
        }else{
            courseEditService.updateCourseEdit(courseEditDTO);
        }

        System.out.println(courseEditDTO.getId());
        return "redirect:/adminTrainer";
    }

    //end add form admin_trainer COURSE btn


    @GetMapping("/edit/{id}")
    public String adminTrainerEdit (@PathVariable Long id, Model model){
        if(id == null) {
            return "/pages/404.html";
        } else {
            CourseEdit courseEdit = courseEditService.getCourseEditById(id);
            if(courseEdit == null) {
                return "/pages/404.html";
            }
            model.addAttribute("courseEditDTO", courseEdit);
        }
        return "pages/admin/admin_trainer/page_edit";
    }



    @GetMapping("/info")
    public String adminTrainerInfo (){
        return "pages/admin/admin_trainer/page_info";
    }

//    @GetMapping("/info")
//    public String adminTrainerInfotesst (){
//        return "/pages/404.html";
//    }

}
