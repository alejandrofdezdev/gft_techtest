package gft.techtest.infrastructure.outbound.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "PRICES")
@NoArgsConstructor
public class PriceEntity {

    @EmbeddedId
    private PriceId priceId;
    private BigDecimal price;
    @Column(name = "CURR")
    private String currency;

}
