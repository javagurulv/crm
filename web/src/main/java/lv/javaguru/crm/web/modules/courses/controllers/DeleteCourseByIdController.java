package lv.javaguru.crm.web.modules.courses.controllers;

import lv.javaguru.crm.core.modules.courses.requests.DeleteCourseByIdRequest;
import lv.javaguru.crm.core.modules.courses.responses.DeleteCourseByIdResponse;
import lv.javaguru.crm.core.modules.courses.services.DeleteCourseByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteCourseByIdController {

    @Autowired private DeleteCourseByIdService deleteCourseByIdService;

    @GetMapping(value = "course/deleteCourseById")
    private String showDeleteCourseByIdPage(ModelMap modelMap) {
        modelMap.addAttribute("request", new DeleteCourseByIdRequest());
        return "course/deleteCourseById";
    }

    @PostMapping("course/deleteCourseById")
    private String deleteCourseById(
            @ModelAttribute(value = "request") DeleteCourseByIdRequest request, ModelMap modelMap) {
        DeleteCourseByIdResponse response = deleteCourseByIdService.execute(request);
        if (response.hasErrors()) {
            modelMap.addAttribute("errors", response.getErrors());
            return "course/deleteCourseById";
        } else {
            return "redirect:/";
        }
    }

}
