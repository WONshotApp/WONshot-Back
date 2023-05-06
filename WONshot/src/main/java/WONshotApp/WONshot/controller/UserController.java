package WONshotApp.WONshot.controller;

import WONshotApp.WONshot.dto.user.UserDto;
import WONshotApp.WONshot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    @ResponseBody
    public String register(UserDto userDto) {
        userService.joinUser(userDto);
        return "회원가입 완료";
    }

}
