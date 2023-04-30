package WONshotApp.WONshot.domain;
import java.time.LocalDateTime;


public abstract class BaseEntity {
    private StatusType status;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
