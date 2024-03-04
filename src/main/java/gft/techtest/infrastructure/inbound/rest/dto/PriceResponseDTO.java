package gft.techtest.infrastructure.inbound.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PriceResponseDTO {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private String startDate;
    private String endDate;
    private Double price;

}
