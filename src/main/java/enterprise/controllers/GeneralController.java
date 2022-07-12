
package enterprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/greeting")
    public String greetingPage() {
        return "greeting";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
