package WONshotApp.WONshot.controller;

import WONshotApp.WONshot.config.BaseException;
import WONshotApp.WONshot.config.BaseResponse;
import WONshotApp.WONshot.dto.user.*;
import WONshotApp.WONshot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("find-id")
    @ResponseBody
    public BaseResponse<FindIdRes> findId(FindIdReq findIdReq) throws BaseException {
        FindIdRes findIdRes = userService.findId(findIdReq);
        return new BaseResponse<>(findIdRes);
    }

    @PostMapping("login")
    @ResponseBody
    public BaseResponse<LoginRes> login(LoginReq loginReq) throws BaseException {
        LoginRes loginRes = userService.login(loginReq);
        return new BaseResponse<>(loginRes);
    }
}
