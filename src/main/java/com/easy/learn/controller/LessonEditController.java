//package com.easy.learn.controller;
//
//import com.easy.learn.callApi.CourseEditService;
//import com.easy.learn.callApi.LessonEditService;
//import com.easy.learn.consts.UrlPath;
//import com.easy.learn.dto.CourseEdit.CourseEdit;
//import com.easy.learn.dto.CourseEdit.CourseEditDTO;
//import com.easy.learn.dto.LessonEdit.LessonEdit;
//import com.easy.learn.dto.LessonEdit.LessonEditDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//@Controller
//@RequestMapping(UrlPath.API_LESSON_TRAINER)
//public class LessonEditController {
//
//    @Autowired
//    private LessonEditService lessonEditService;
//
//    @Autowired
//    private CourseEditService courseEditService;
//
//    @ModelAttribute("lessonEditDTO")
//    public LessonEditDTO initCourseEdit() {
//        return new LessonEditDTO();
//    }
//
//    @GetMapping("/index/{id}")
//    public String lessonIndex(@PathVariable Long id, Model model) {
//        model.addAttribute("course",courseEditService.getCourseEditById(id));
//        model.addAttribute("lessonDTO", new LessonEditDTO());
//        return "pages/admin/admin_trainer/page_edit_course/page_edit";
//    }
//
//    @PostMapping("/index/{id}/saveLesson")
//    public String saveLessonToCourse(
//            @PathVariable Long id,
//            @ModelAttribute("lessonEditDTO") LessonEditDTO lessonEditDTO,
//            @RequestParam("videoLessonEdit") MultipartFile videoCourseEdit
//    ) {
//        try {
//            Path videoPath = Paths.get("src/main/resources/static/videos/lesson");
//
//            if (!Files.exists(videoPath)) {
//                Files.createDirectories(videoPath);
//            }
//
//            if (!videoCourseEdit.isEmpty()) {
//                Files.copy(videoCourseEdit.getInputStream(),
//                        videoPath.resolve("video.mp4"),
//                        StandardCopyOption.REPLACE_EXISTING);
//
//                lessonEditDTO.setVideo("video.mp4");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        CourseEdit courseEdit = courseEditService.getCourseEditById(id);
//        if(courseEdit!=null){
//            LessonEdit lessonEdit = new LessonEdit();
//            lessonEdit.setTitle(lessonEditDTO.getTitle());
//            lessonEdit.setNumber(lessonEditDTO.getNumber());
//            lessonEdit.setVideo(lessonEditDTO.getVideo());
//
//            courseEdit.getLessonEdits().add(lessonEdit);
//            lessonEdit.setCourseEdit(courseEdit);
//        }
//
//        // Save the lesson
//        if (lessonEditDTO.getId() == null) {
//            lessonEditService.createLessonEdit(lessonEditDTO);
//        } else {
//            lessonEditService.updateLessonEdit(lessonEditDTO);
//        }
//
//        return "redirect:/lesson/index";
//    }
//
//
//
//}
