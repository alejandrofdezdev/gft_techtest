package gft.techtest.domain.port;

import gft.techtest.domain.entity.Price;
import gft.techtest.domain.exception.NotFoundException;

import java.time.LocalDateTime;

public interface PriceService {
    Price findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) throws NotFoundException;
}

