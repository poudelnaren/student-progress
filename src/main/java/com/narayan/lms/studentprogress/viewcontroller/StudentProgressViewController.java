package com.narayan.lms.studentprogress.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentProgressViewController {

    @RequestMapping("/show-report")
    public String viewProgressReport(){
        return "index";
    }
}
