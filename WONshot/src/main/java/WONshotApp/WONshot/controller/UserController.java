package WONshotApp.WONshot.controller;

import WONshotApp.WONshot.config.BaseException;
import WONshotApp.WONshot.config.BaseResponse;
import WONshotApp.WONshot.dto.user.CheckIdReq;
import WONshotApp.WONshot.dto.user.CheckIdRes;
import WONshotApp.WONshot.dto.user.JoinUserReq;
import WONshotApp.WONshot.dto.user.JoinUserRes;
import WONshotApp.WONshot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j // logger
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("check-id")
    @ResponseBody
    public BaseResponse<CheckIdRes> checkId(CheckIdReq checkIdReq) {
        CheckIdRes checkIdRes = userService.checkId(checkIdReq);
        return new BaseResponse<>(checkIdRes);
    }

    @PostMapping("register")
    @ResponseBody
    public BaseResponse<JoinUserRes> joinUser(JoinUserReq joinUserReq) throws BaseException {
        JoinUserRes joinUserRes = userService.joinUser(joinUserReq);
        return new BaseResponse<>(joinUserRes);
    }

}
