    package com.easy.learn.controller;


    import com.easy.learn.callApi.TestEditService;
    import com.easy.learn.dto.CourseEdit.CourseEditDTO;
    import com.easy.learn.dto.LessonEdit.LessonEditDTO;
    import com.easy.learn.dto.TestEditDTO.TestEditDTO;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.http.*;
    import org.springframework.web.multipart.MultipartFile;


    import java.io.IOException;
    import java.util.List;

    import static com.easy.learn.controller.FileUploadController.checkExcelFormat;
    import static com.easy.learn.controller.FileUploadController.convertExcelToList;

    @Controller
    public class TestEditController {

        @Autowired
        TestEditService testEditService;

        @ModelAttribute("testEditDTO")
        public TestEditDTO initCourseEdit() {
            return new TestEditDTO();
        }


        @GetMapping("/index")
        public String adminTrainerIndex(Model model) {
            model.addAttribute("testEditList", testEditService.getAllTestEdit());
            return "/pages/pageList";
        }

        @PostMapping("/upload")
        public String testLessonToCourse(@RequestParam("testFile") MultipartFile testFile) {
            try {
                if (checkExcelFormat(testFile)) {
                    List<TestEditDTO> testEditDTOS = convertExcelToList(testFile.getInputStream());
                    testEditService.saveAllTest(testEditDTOS);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:/pages/pageList";
        }
    }


