package lv.javaguru.crm.web.modules.courses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String showHomePage() {
        return "index";
    }

}
