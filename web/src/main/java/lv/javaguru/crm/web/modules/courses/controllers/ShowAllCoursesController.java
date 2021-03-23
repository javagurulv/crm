package lv.javaguru.crm.web.modules.courses.controllers;

import lv.javaguru.crm.core.modules.courses.responses.GetAllCoursesResponse;
import lv.javaguru.crm.core.modules.courses.services.GetAllCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowAllCoursesController {

    @Autowired private GetAllCoursesService getAllCoursesService;

    @GetMapping(value = "/course/showAllCourses")
    public String showAllCoursesPage(ModelMap modelMap){
        GetAllCoursesResponse response = getAllCoursesService.execute();
        modelMap.addAttribute("courses", response.getCourseList());
        return "course/showAllCourses";
    }

}
