package gft.techtest.infrastructure.outbound.database;

import gft.techtest.domain.entity.Price;
import gft.techtest.domain.exception.NotFoundException;
import gft.techtest.domain.port.PriceService;
import gft.techtest.infrastructure.outbound.database.entity.PriceEntity;
import gft.techtest.infrastructure.outbound.database.entity.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;
    private final PriceMapper mapper;

    @Override
    public Price findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) throws NotFoundException {
        PriceEntity entity = repository.findApplicablePrice(brandId, productId, applicationDate)
                .orElseThrow(NotFoundException::new);

        return mapper.toDomain(entity);
    }
}

