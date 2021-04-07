package lv.javaguru.crm.web.modules.courses.controllers;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;
import lv.javaguru.crm.core.modules.courses.services.AddCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddCourseController {

    @Autowired private AddCourseService addCourseService;

    @GetMapping(value = "/course/addCourse")
    public String showAddCoursePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new CourseFieldRequest(new Course()));
        return "/course/addCourse";
    }

    @PostMapping("/course/addCourse")
    public String processAddCourseRequest(@ModelAttribute(value = "request") CourseFieldRequest request, ModelMap modelMap)
            throws NoSuchFieldException, IllegalAccessException {
        CourseFieldResponse response = addCourseService.addCourse(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "/course/addCourse";
        } else {
            return "redirect:/";
        }
    }

}
