package gft.techtest.application;

import gft.techtest.domain.entity.Price;
import gft.techtest.domain.port.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceUseCases {

    private final PriceService priceService;

    public Price findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceService.findApplicablePrice(brandId, productId, applicationDate);
    }
}
