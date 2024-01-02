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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(UrlPath.API_TRAINER_ADMIN)
public class AdminTrainerController {

    @Autowired
    private CourseEditService courseEditService;

    @ModelAttribute("courseEditDTO")
    public CourseEditDTO initCourseEdit() {
        return new CourseEditDTO();
    }



    @GetMapping("/index")
    public String adminTrainerIndex(Model model) {
        model.addAttribute("courseEditList", courseEditService.getAllCourseEdit());
        return "pages/admin/admin_trainer/page_index/index";
    }

    //==================== start btn ADD COURSE form

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("courseEditDTO") CourseEditDTO courseEditDTO,
                             @RequestParam("imgCourseEdit") MultipartFile imgCourseEdit) {
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

        // Save the course
        if(courseEditDTO.getId()==null){
            courseEditService.createCourseEdit(courseEditDTO);
        }else{
            courseEditService.updateCourseEdit(courseEditDTO);
        }

        return "redirect:/adminTrainer/index";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, Model model) {

        CourseEdit courseEdit = courseEditService.getCourseEditById(id);

        model.addAttribute("courseUpdate", courseEdit);

        return "pages/admin/admin_trainer/page_update_course/page_updateCourse";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {

        CourseEdit courseEdit = courseEditService.getCourseEditById(id);

        model.addAttribute("courseEdit", courseEdit);

        return "pages/admin/admin_trainer/page_edit_course/page_edit";
    }


    @GetMapping("/info/{id}")
    public String infoCourse(@PathVariable Long id, Model model) {

        CourseEdit courseEdit = courseEditService.getCourseEditById(id);

        model.addAttribute("courseEditInfo", courseEdit);

        return "pages/admin/admin_trainer/page_info_course/page_info";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmploy(@PathVariable Long id){
        courseEditService.deleteCourseEdit(id);
        return "redirect:/adminTrainer/index";
    }


}






//
//    //==================== end btn ADD COURSE form
//
//
//    @GetMapping(UrlPath.GET_UPDATE_COURSE_ID_INDEX_TRAINER_ADMIN)
//    public String adminTrainerUpdate(@PathVariable Long id, Model model) {
//        CourseEdit updateCourse = courseEditService.getCourseEditById(id);
//        model.addAttribute("updateCourse",updateCourse);
//
//        return UrlPath.GET_PAGE_UPDATE;
//    }
//
//
//    @PostMapping(UrlPath.POST_UPDATE_COURSE_TRAINER_ADMIN)
//    public String updateCourseForm(
//            @ModelAttribute("updateCourseEditDTO") CourseEditDTO courseEditDTO ,
//            @RequestParam("imgCourseEdit") MultipartFile imgCourseEdit) {
//
//            try {
//                Path path = Paths.get("src/main/resources/static/img/course");
//                InputStream inputStream = imgCourseEdit.getInputStream();
//                Files.copy(inputStream, path.resolve(imgCourseEdit.getOriginalFilename()),
//                        StandardCopyOption.REPLACE_EXISTING);
//
//                courseEditDTO.setImg(imgCourseEdit.getOriginalFilename().toLowerCase());
//                courseEditDTO.setLastUpdate(LocalDateTime.now());
//
//                courseEditService.updateCourseEdit(courseEditDTO);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        return "redirect:"+UrlPath.API_TRAINER_ADMIN;
//    }
//
//
//    //=========================================================UPDATE COURSE=================================
//
//
//
//
//
//
//
//
//
//    @GetMapping(UrlPath.GET_EDIT_COURSE_ID_INDEX_TRAINER_ADMIN)
//    public String adminTrainerEdit(@PathVariable Long id, Model model) {
//        if(id == null) {
//            return "/pages/404.html";
//        } else {
//            CourseEdit courseEdit = courseEditService.getCourseEditById(id);
//            if(courseEdit == null) {
//                return "/pages/404.html";
//            }
//            model.addAttribute("courseEdit", courseEdit);
//        }
//        return UrlPath.GET_PAGE_EDIT;
//    }
//
//    @GetMapping(UrlPath.GET_INFO_COURSE_ID_INDEX_TRAINER_ADMIN)
//    public String adminTrainerInfo (@PathVariable Long id, Model model){
//        if(id == null) {
//            return "/pages/404.html";
//        } else {
//            CourseEdit courseEdit = courseEditService.getCourseEditById(id);
//            if(courseEdit == null) {
//                return "/pages/404.html";
//            }
//            model.addAttribute("courseEditInfo", courseEdit);
//        }
//        return UrlPath.GET_PAGE_INFO;
//    }
//
//    //==================== start delete course by id form index trainer admin page
//    @GetMapping(UrlPath.GET_DELETE_COURSE_ID_INDEX_TRAINER_ADMIN)
//    public String deleteCourseEdit(@PathVariable Long id){
//        courseEditService.deleteCourseEdit(id);
//        return "redirect:"+UrlPath.API_TRAINER_ADMIN;
//    }
//    //====================== end delete course by id form index trainer admin page
//
//
//
//
//
//}
