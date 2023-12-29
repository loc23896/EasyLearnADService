package com.easy.learn.consts;

public interface UrlPath {

    String GET_ALL_USER = "/salarypaids";


//    ==================================== start API Trainer addmin by loc ==========================================
    String API_TRAINER_ADMIN = "/adminTrainer";
    String POST_FORM_COURSE_INDEX_TRAINER_ADMIN = API_TRAINER_ADMIN+"/addCourseForm";
    String GET_EDIT_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/edit/{id}";
    String GET_INFO_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/info/{id}";
    String GET_DELETE_COURSE_ID_INDEX_TRAINER_ADMIN =API_TRAINER_ADMIN+"/delete/{id}";

//    ==================================== end API Trainer addmin by loc ==========================================


//    ==================================== Start API Trainer addmin lesson by loc ==========================================

    String GET_FORM_LESSON_INDEX_TRAINER_ADMIN = API_TRAINER_ADMIN+"/addLessonForm";
    String POST_FORM_LESSON_INDEX_TRAINER_ADMIN = API_TRAINER_ADMIN+"/addLessonForm";





}
