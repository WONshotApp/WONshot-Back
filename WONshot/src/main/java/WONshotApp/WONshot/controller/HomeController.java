package WONshotApp.WONshot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("home")
    @ResponseBody
    public String home() {
        String code = UUID.randomUUID().toString();
        return code;
    }
}
