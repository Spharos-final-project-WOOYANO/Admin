package shparos.admin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class testController {

    @GetMapping("/123")
    public String example(){

        return "example";

    }
}
