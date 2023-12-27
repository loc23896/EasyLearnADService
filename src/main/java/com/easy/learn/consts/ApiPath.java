package com.easy.learn.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

    //user
    String USER_SIGN_IN = API + "/sign-in";
    String USER_GET_ALL = API + "/user/get-all";
    String USER_GET_UUID = API + "/user/get-by-uuid";
    String USER_CREATE = API + "/user/create";
    String USER_UPDATE = API + "/user/update";
    String USER_DELETE = API + "/user/delete";
    //trainersalarypaid
    String TRAINER_SALARY_GET_ALL = API + "/trainersalary/get-all";
    String TRAINER_SALARY_GET_ONE = API + "/trainersalary/get-one";
    String TRAINER_SALARY_CREATE = API + "/trainersalary/create";
    String TRAINER_SALARY_UPDATE = API + "/trainersalary/update";
    String TRAINER_SALARY_DELETE = API + "/trainersalary/delete";

    // end

    //trainersalarypaidSUMMARY
    String TRAINER_SALARY_SUMMARY_GET_ALL = API + "/trainer-salary-summary/get-all";
    String TRAINER_SALARY_SUMMARY_GET_ONE = API + "/trainer-salary-summary/get-one";
    String TRAINER_SALARY_SUMMARY_CREATE = API + "/trainer-salary-summary/create";
    String TRAINER_SALARY_SUMMARY_UPDATE = API + "/trainer-salary-summary/update";
    String TRAINER_SALARY_SUMMARY_DELETE = API + "/trainer-salary-summary/delete";


    //ADMIN_TRAINER_COURSE_EDIT by LOC
    String COURSE_EDIT_GET_ALL = API + "/course-edit/get-all";
    String COURSE_EDIT_GET_ONE = API + "/course-edit/get-one";
    String COURSE_EDIT_CREATE = API + "/course-edit/create";
    String COURSE_EDIT_UPDATE = API + "/course-edit/update";
    String COURSE_EDIT_DELETE = API + "/course-edit/delete";

//END ADMIN_TRAINER_COURSE_EDIT



}
