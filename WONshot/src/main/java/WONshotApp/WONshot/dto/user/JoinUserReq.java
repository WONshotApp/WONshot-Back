package WONshotApp.WONshot.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinUserReq {
    private String id;
    private String password;
    private String name;
    private String email;
}
