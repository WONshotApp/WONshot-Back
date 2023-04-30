package WONshotApp.WONshot.domain;

import java.time.LocalDate;


public class Income extends BaseEntity{
    private Integer idx;
    private Integer monthly_idx;
    private String title;
    private Integer price;
    private IncomeCategoryType category;
    private LocalDate date;
}
