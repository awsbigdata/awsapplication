package software.awssupport.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * it is used to redirect to form page.
 */
@Controller
public class SimpleController {


    /**
     * it return API form page
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String apiform() {
        return "welcome";
    }
}
