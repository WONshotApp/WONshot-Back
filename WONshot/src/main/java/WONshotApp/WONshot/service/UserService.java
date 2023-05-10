package WONshotApp.WONshot.service;

import WONshotApp.WONshot.config.BaseException;
import WONshotApp.WONshot.config.BaseExceptionStatus;
import WONshotApp.WONshot.config.BaseResponse;
import WONshotApp.WONshot.domain.User;
import WONshotApp.WONshot.dto.user.CheckIdReq;
import WONshotApp.WONshot.dto.user.CheckIdRes;
import WONshotApp.WONshot.dto.user.JoinUserReq;
import WONshotApp.WONshot.dto.user.JoinUserRes;
import WONshotApp.WONshot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CheckIdRes checkId(CheckIdReq checkIdReq) {
        return new CheckIdRes(!userRepository.existsUserById(checkIdReq.getId()));
    }

    public JoinUserRes joinUser(JoinUserReq joinUserReq) throws BaseException {

        // email에 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
        if (joinUserReq.getEmail().length() == 0) {
            throw new BaseException(BaseExceptionStatus.EMPTY_EMAIL);
        }
//        //이메일 정규표현: 입력받은 이메일이 email@domain.xxx와 같은 형식인지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
//        if (!isRegexEmail(postUserReq.getUserEmail())) {
//            return new BaseResponse<>(POST_USERS_INVALID_EMAIL);
//        }
//        // id에 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
//        if (postUserReq.getUserId().length() == 0) {
//            return new BaseResponse<>(POST_USERS_EMPTY_ID);
//        }
//        //id 정규표현: 입력받은 id가 영문 대소문자,숫자 4-16자리 형식인지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
//        if (!isRegexId(postUserReq.getUserId())) {
//            return new BaseResponse<>(POST_USERS_INVALID_ID);
//        }
//        // password에 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
//        if (postUserReq.getUserPwd().length() == 0) {
//            return new BaseResponse<>(POST_USERS_EMPTY_PASSWORD);
//        }
//        //비밀번호 정규표현: 입력받은 비밀번호가 숫자, 특문 각 1회 이상, 영문은 대소문자 모두 사용하여 8~16자리 입력과 같은 형식인지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
//        if (!isRegexPassword(postUserReq.getUserPwd())) {
//            return new BaseResponse<>(POST_USERS_INVALID_PASSWORD);
//        }
//        // 닉네임 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
//        if (postUserReq.getUserNickname().length() == 0) {
//            return new BaseResponse<>(POST_USERS_EMPTY_NICKNAME);
//        }
//        // 닉네임 정규표현: 입력받은 닉네임이 숫자와 영문, 한글로만 이루어졌는지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
//        if (!isRegexNickname(postUserReq.getUserNickname())) {
//            return new BaseResponse<>(POST_USERS_INVALID_NICKNAME);
//        }
//        // 주소가 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
//        if (postUserReq.getUserAddress().length() == 0) {
//            return new BaseResponse<>(POST_USERS_EMPTY_ADDRESS);
//        }
//        // 관심사를 설정했는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
//        if (postUserReq.getUserLikes() == null) {
//            return new BaseResponse<>(POST_USERS_EMPTY_LIKES);
//        }
//        try {
//            PostUserRes postUserRes = userService.createUser(postUserReq);
//            return new BaseResponse<>(postUserRes);
//        } catch (BaseException exception) {
//            return new BaseResponse<>((exception.getStatus()));
//        }

        String uuid = UUID.randomUUID().toString();
        User user = User.builder()
                .uuid(uuid)
                .id(joinUserReq.getId())
                .password(passwordEncoder.encode(joinUserReq.getPassword()))
                .name(joinUserReq.getName())
                .email(joinUserReq.getEmail())
                .build();
        userRepository.save(user);
        return new JoinUserRes(uuid, joinUserReq.getId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}