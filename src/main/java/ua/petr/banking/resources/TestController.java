package ua.petr.banking.resources;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "")
            String name, Model model) {

        return name;
    }
}
