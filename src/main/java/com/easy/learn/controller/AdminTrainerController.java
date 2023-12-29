package com.easy.learn.controller;

import com.easy.learn.callApi.CourseEditService;

import com.easy.learn.callApi.LessonEditService;
import com.easy.learn.consts.UrlPath;
import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.CourseEdit.CourseEditDTO;

import com.easy.learn.dto.LessonEdit.LessonEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class AdminTrainerController {

    @Autowired
    private CourseEditService courseEditService;

    @GetMapping(UrlPath.API_TRAINER_ADMIN)
    public String adminTrainerIndex(Model model) {
        model.addAttribute("courseEditList", courseEditService.getAllCourseEdit());
        model.addAttribute("courseEditDTO", new CourseEditDTO());
        return "pages/admin/admin_trainer/index";
    }

    //==================== start btn ADD COURSE form
    @PostMapping(UrlPath.POST_FORM_COURSE_INDEX_TRAINER_ADMIN)
    public String addCourseForm(
            @ModelAttribute("courseEditDTO") CourseEditDTO courseEditDTO,
            @RequestParam("imgCourseEdit") MultipartFile imgCourseEdit) {
        if (imgCourseEdit.isEmpty()) {
            return "/pages/admin/admin_trainer/ErrorPage.html";
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

            courseEditService.saveOrUpdateCourseEdit(courseEditDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:"+UrlPath.API_TRAINER_ADMIN;
    }

    //==================== end btn ADD COURSE form


    @GetMapping(UrlPath.GET_EDIT_COURSE_ID_INDEX_TRAINER_ADMIN)
    public String adminTrainerEdit(@PathVariable Long id, Model model) {
        if (id == null) {
            return "/pages/404.html";
        } else {
            CourseEdit courseEdit = courseEditService.getCourseEditById(id);
            if (courseEdit == null) {
                return "/pages/404.html";
            }
            model.addAttribute("courseEdit", courseEdit);
        }
        return "pages/admin/admin_trainer/page_edit";
    }



        @GetMapping(UrlPath.GET_INFO_COURSE_ID_INDEX_TRAINER_ADMIN)
    public String adminTrainerInfo (@PathVariable Long id, Model model){
        if(id == null) {
            return "/pages/404.html";
        } else {
            CourseEdit courseEdit = courseEditService.getCourseEditById(id);
            if(courseEdit == null) {
                return "/pages/404.html";
            }
            model.addAttribute("courseEditInfo", courseEdit);
        }

        return "pages/admin/admin_trainer/page_info";
    }

    //==================== start delete course by id form index trainer admin page
    @GetMapping(UrlPath.GET_DELETE_COURSE_ID_INDEX_TRAINER_ADMIN)
    public String deleteCourseEdit(@PathVariable Long id){
        courseEditService.deleteCourseEdit(id);
        return "redirect:"+UrlPath.API_TRAINER_ADMIN;
    }
    //====================== end delete course by id form index trainer admin page





}
