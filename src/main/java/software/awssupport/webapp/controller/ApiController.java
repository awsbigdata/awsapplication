package software.awssupport.webapp.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/***
 * Returns API name
 */
@RestController
public class ApiController {

    /**
     *  It return home with API from request
     * @param apiname
     * @return
     */
    @PostMapping(value = "/api")
    public String registerAPI(@RequestBody MultiValueMap apiname){

        return "Home "+(String) apiname .getFirst("name");
    }
}
