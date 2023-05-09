package WONshotApp.WONshot.controller;

import WONshotApp.WONshot.config.BaseResponse;
import WONshotApp.WONshot.dto.user.JoinUserReq;
import WONshotApp.WONshot.dto.user.JoinUserRes;
import WONshotApp.WONshot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    @ResponseBody
    public BaseResponse<JoinUserRes> joinUser(JoinUserReq joinUserReq) {
        JoinUserRes joinUserRes = userService.joinUser(joinUserReq);
        return new BaseResponse<>(joinUserRes);
    }

}
