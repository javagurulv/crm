package lv.javaguru.crm.web.modules.students.controllers;

import lv.javaguru.crm.core.modules.students.response.GetStudentListResponse;
import lv.javaguru.crm.core.modules.students.service.GetStudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllStudentsController {

    @Autowired private GetStudentListService getStudentListService;
/*
    @GetMapping(value = "/student/showAllStudents")
    public String showAllStudentsPage(ModelMap modelMap){
        GetStudentListResponse response = getStudentListService.getStudentList()
    }

 */
}
