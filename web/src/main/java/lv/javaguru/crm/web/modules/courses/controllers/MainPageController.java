package lv.javaguru.crm.web.modules.courses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping(value = "/course/main")
    public String showMainPage() {
        return "/course/main";
    }

}


