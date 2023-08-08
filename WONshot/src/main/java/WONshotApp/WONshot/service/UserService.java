package WONshotApp.WONshot.service;

import WONshotApp.WONshot.config.BaseException;
import WONshotApp.WONshot.config.BaseExceptionStatus;
import WONshotApp.WONshot.domain.User;
import WONshotApp.WONshot.dto.user.*;
import WONshotApp.WONshot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static WONshotApp.WONshot.config.BaseExceptionStatus.INVALID_PASSWORD;
import static WONshotApp.WONshot.utils.ValidationRegex.*;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CheckIdRes checkId(CheckIdReq checkIdReq) {
        return new CheckIdRes(!userRepository.existsUserById(checkIdReq.getId()));
    }

    public JoinUserRes joinUser(JoinUserReq joinUserReq) throws BaseException {
        // email에 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
        if (joinUserReq.getEmail().length() == 0) {
            throw new BaseException(BaseExceptionStatus.EMPTY_EMAIL);
        }
        //이메일 정규표현: 입력받은 이메일이 email@domain.xxx와 같은 형식인지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
        if (!isRegexEmail(joinUserReq.getEmail())) {
            throw new BaseException(BaseExceptionStatus.INVALID_EMAIL);
        }
        //id 정규표현: 입력받은 id가 영문 대소문자,숫자 4-16자리 형식인지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
        if (!isRegexId(joinUserReq.getId())) {
            throw  new BaseException(BaseExceptionStatus.INVALID_ID);
        }
        // password에 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
        if (joinUserReq.getPassword().length() == 0) {
            throw new BaseException(BaseExceptionStatus.EMPTY_EMAIL);
        }
        //비밀번호 정규표현: 입력받은 비밀번호가 숫자, 특문 각 1회 이상, 영문은 대소문자 모두 사용하여 8~16자리 입력과 같은 형식인지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
        if (!isRegexPassword(joinUserReq.getPassword())) {
            throw new BaseException(INVALID_PASSWORD);
        }
        // 닉네임 값이 존재하는지, 빈 값으로 요청하지는 않았는지 검사합니다. 빈값으로 요청했다면 에러 메시지를 보냅니다.
        if (joinUserReq.getName().length() == 0) {
            throw new BaseException(BaseExceptionStatus.EMPTY_NICKNAME);
        }
        // 닉네임 정규표현: 입력받은 닉네임이 숫자와 영문, 한글로만 이루어졌는지 검사합니다. 형식이 올바르지 않다면 에러 메시지를 보냅니다.
        if (!isRegexNickname(joinUserReq.getName())) {
            throw new BaseException(BaseExceptionStatus.INVALID_NICKNAME);
        }

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

    public FindIdRes findId(FindIdReq findIdReq) throws BaseException {
        List<User> user_list = userRepository.findByEmail(findIdReq.getEmail());
        if (user_list.size() == 0){
            throw new BaseException(BaseExceptionStatus.NOT_FOUND_EMAIL);
        }
        return new FindIdRes(user_list.get(0).getId());
    }

    public LoginRes login(LoginReq loginReq) throws BaseException {
        return new LoginRes("d", "d");
    }

}