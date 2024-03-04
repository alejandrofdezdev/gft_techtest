package gft.techtest.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
public class Price {
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;

}

