package software.awssupport.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String apiform() {
        return "welcome";
    }
}
