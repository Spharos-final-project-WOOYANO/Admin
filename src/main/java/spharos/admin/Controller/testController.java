package spharos.admin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class testController {

    @GetMapping("/test")
    public String example(){

        return "Admin Service";

    }
}
