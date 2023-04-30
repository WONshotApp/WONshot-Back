package WONshotApp.WONshot.domain;

import java.time.LocalDate;


public class Expense extends BaseEntity{
    private Integer idx;
    private Integer monthly_idx;
    private String title;
    private Integer price;
    private ExpenseCategoryType category;
    private LocalDate date;
}
