package gft.techtest.infrastructure.outbound.database.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class PriceId implements Serializable {
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Long priority;

}
