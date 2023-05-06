package WONshotApp.WONshot.dto.user;

import WONshotApp.WONshot.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String password;
    private String name;
    private String email;
}
