package lv.javaguru.crm.web.modules.students.controllers;

import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.request.AddStudentRequest;
import lv.javaguru.crm.core.modules.students.response.AddStudentResponse;
import lv.javaguru.crm.core.modules.students.service.AddStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddStudentController {

    @Autowired private AddStudentService addStudentService;

    @GetMapping(value = "/student/addStudent")
    public String showAddStudentPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new AddStudentRequest(new Student()));
        return "/student/addStudent";
    }

    @PostMapping("/student/addStudent")
    public String processAddStudentRequest(@ModelAttribute(value = "request") AddStudentRequest request, ModelMap modelMap)
        throws NoSuchFieldException, IllegalAccessException{
        AddStudentResponse response = addStudentService.execute(request);
        if (response.hasErrors()){
            modelMap.addAttribute("errors", response.getErrors());
            return "/student/addStudent";
        } else {
            return "redirect:/";
        }
    }
}
