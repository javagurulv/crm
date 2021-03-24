package lv.javaguru.crm.web.modules.courses.controllers;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.requests.UpdateCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.UpdateCourseResponse;
import lv.javaguru.crm.core.modules.courses.services.UpdateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateCourseController {

    @Autowired
    private UpdateCourseService updateCourseService;

    @GetMapping(value = "/course/updateCourse")
    public String showUpdateCoursePage(ModelMap modelMap) {
        modelMap.addAttribute("request", new UpdateCourseRequest(new Course()));
        return "course/updateCourse";
    }

    @PostMapping("/course/updateCourse")
    public String showUpdateCourse(
            @ModelAttribute(value = "request") UpdateCourseRequest request, ModelMap modelMap) throws NoSuchFieldException, IllegalAccessException {
        UpdateCourseResponse response = updateCourseService.updateCourse(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
        } else {
            modelMap.addAttribute("courses", response.getUpdatedCourse());
        }
        return "course/updateCourse";
    }
}