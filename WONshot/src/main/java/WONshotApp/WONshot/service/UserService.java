package WONshotApp.WONshot.service;

import WONshotApp.WONshot.domain.User;
import WONshotApp.WONshot.dto.user.UserDto;
import WONshotApp.WONshot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional
    public void joinUser(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = User.builder()
                .uuid(UUID.randomUUID().toString())
                .id(userDto.getId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}