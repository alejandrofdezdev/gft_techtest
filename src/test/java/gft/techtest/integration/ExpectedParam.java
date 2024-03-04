package gft.techtest.integration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@RequiredArgsConstructor
public class ExpectedParam {
    private final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private final LocalDateTime applicationDate;
    private final Long productId;
    private final Long brandId;
    private Double expectedPrice;
    private String expectedStartDate;
    private String expectedEndDate;

    public void setExpectations(Double expectedPrice, LocalDateTime expectedStartDate, LocalDateTime expectedEndDate) {
        this.expectedPrice = expectedPrice;
        this.expectedStartDate = expectedStartDate.format(DateTimeFormatter.ofPattern(dateFormat));
        this.expectedEndDate = expectedEndDate.format(DateTimeFormatter.ofPattern(dateFormat));
    }
}
