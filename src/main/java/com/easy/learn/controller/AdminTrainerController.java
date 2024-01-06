package com.easy.learn.controller;

import com.easy.learn.callApi.CourseEditService;


import com.easy.learn.consts.UrlPath;
//import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.CourseEdit.CourseEditDTO;


//import com.easy.learn.dto.LessonEdit.LessonEdit;
import com.easy.learn.dto.LessonEdit.LessonEditDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(UrlPath.API_TRAINER_ADMIN)
public class AdminTrainerController {

    @Autowired
    private LessonEditService lessonEditService;
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
            courseEditDTO.setLastUpdate(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Save the course
        if(courseEditDTO.getId()==null){
            courseEditDTO.setStatus(false);
            courseEditService.createCourseEdit(courseEditDTO);
        }else{
            courseEditService.updateCourseEdit(courseEditDTO);
        }

        return "redirect:/adminTrainer/index";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, Model model) {

//        CourseEdit courseEdit = courseEditService.getCourseEditById(id);

        model.addAttribute("courseUpdate", courseEditService.getCourseEditById(id));

        return "pages/admin/admin_trainer/page_update_course/page_updateCourse";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {

        model.addAttribute("courseEdit", courseEditService.getCourseEditById(id));
        model.addAttribute("listLesson",lessonEditService.getAllLessonByCourseId(id));

            return "pages/admin/admin_trainer/page_edit_course/page_edit";
    }


    @GetMapping("/info/{id}")
    public String infoCourse(@PathVariable Long id, Model model) {

        CourseEditDTO courseEdit = courseEditService.getCourseEditById(id);

        model.addAttribute("courseEditInfo", courseEdit);

        return "pages/admin/admin_trainer/page_info_course/page_info";
    }


    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        lessonEditService.deleteAllLessonByCourseId(id);
        courseEditService.deleteCourseEdit(id);
        return "redirect:/adminTrainer/index";
    }


    //===============================================================PAGE EDIT ==================================

    @GetMapping("/{id}/createLesson")
    public String createLesson(@PathVariable Long id, Model model) {
        //get id by course -> for page_Lesson_create.html
        model.addAttribute("courseById", courseEditService.getCourseEditById(id));
        //show list lesson in titlePageContent -> page_lesson_create.html
        model.addAttribute("lessonList", lessonEditService.getAllLessonByCourseId(id));
        //add new lesson form in table -> page_lesson_create.html
        model.addAttribute("lessonEditDTO", new LessonEditDTO());

        return "pages/admin/admin_trainer/page_lesson_create/page_lesson_create.html";
    }

    @PostMapping("/{id}/saveLesson")
    public String saveLessonToCourse(@PathVariable Long id,
                                     @ModelAttribute("lessonEditDTO") LessonEditDTO lessonEditDTO,
                                     @RequestParam("videoLessonEdit") MultipartFile videoCourseEdit) {

        try {
            Path videoPath = Paths.get("src/main/resources/static/videos/lesson");

            if (!Files.exists(videoPath)) {
                Files.createDirectories(videoPath);
            }

            if (!videoCourseEdit.isEmpty()) {
                Files.copy(videoCourseEdit.getInputStream(),
                        videoPath.resolve(videoCourseEdit.getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);
                lessonEditDTO.setVideo(videoCourseEdit.getOriginalFilename().toLowerCase());
                lessonEditDTO.setLastUpdate(LocalDateTime.now());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(lessonEditDTO.getId()==null){
            CourseEditDTO courseEdit = courseEditService.getCourseEditById(id);
            lessonEditDTO.setCourseEditId(courseEdit.getId());
            List<LessonEditDTO> lessonList = lessonEditService.getAllLessonEdit();
            courseEdit.setLessonEdits(lessonList);
            courseEditService.updateCourseEdit(courseEdit);

        }
            lessonEditService.updateLessonEdit(lessonEditDTO);

        return "redirect:/adminTrainer/edit/"+id;

    }

    @GetMapping("/{id}/updateLesson/{lessonId}")
    public String updateLesson(@PathVariable Long id,
                               Model model,
                               @PathVariable Long lessonId) {
        model.addAttribute("lessonUpdate", lessonEditService.getLessonEditById(lessonId));
        return "/adminTrainer/{id}/saveLesson";

    }

    @GetMapping("/{id}/deleteLesson/{lessonId}")
    public String deleteLesson(@PathVariable Long id,
                               @PathVariable Long lessonId) {
        // Xác định khóa học
        if (lessonEditService.getLessonEditById(lessonId) != null) {
            lessonEditService.deleteLessonEdit(lessonId);
        }
        return "redirect:/adminTrainer/edit/" + id;

    }






}


