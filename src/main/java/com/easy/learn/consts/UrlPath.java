package com.easy.learn.consts;

public interface UrlPath {

    String GET_ALL_USER = "/salarypaids";
    String TRAINER_SALARY_PAID_SUMMARY = "/trainersalarysummary";


//    ==================================== start API Trainer addmin by loc ==========================================
    String API_TRAINER_ADMIN = "/adminTrainer";
    String POST_FORM_COURSE_INDEX_TRAINER_ADMIN = API_TRAINER_ADMIN+"/addCourseForm";
    String POST_UPDATE_COURSE_TRAINER_ADMIN = API_TRAINER_ADMIN+"/updateCourseForm";
    String GET_ADD_COURSE =API_TRAINER_ADMIN+"/addCourse";
    String GET_EDIT_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/edit/{id}";
    String GET_UPDATE_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/update/{id}";
    String GET_INFO_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/info/{id}";
    String GET_DELETE_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/delete/{id}";
    String GET_CHANGE_EDIT_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/change/{id}";

//    ==================================== end API Trainer addmin by loc ==========================================


    //    ==================================== start page return by loc ==========================================
    String GET_PAGE_UPDATE= "pages/admin/admin_trainer/page_updateCourse";
    String GET_PAGE_EDIT= "pages/admin/admin_trainer/page_edit";
    String GET_PAGE_INFO= "pages/admin/admin_trainer/page_info";
    String GET_PAGE_ADD_COURSE= "pages/admin/admin_trainer/page_add_Course/indexAddCourse.html";

    //    ==================================== end page return by loc ==========================================


//    ==================================== Start API Trainer addmin lesson by loc ==========================================

    String GET_FORM_LESSON_INDEX_TRAINER_ADMIN = API_TRAINER_ADMIN+"/addLessonForm";
    String POST_FORM_LESSON_INDEX_TRAINER_ADMIN = API_TRAINER_ADMIN+"/addLessonForm";





}
