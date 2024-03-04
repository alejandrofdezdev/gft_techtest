package gft.techtest.infrastructure.outbound.database.entity;

import gft.techtest.domain.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "brandId", source = "priceId.brandId")
    @Mapping(target = "startDate", source = "priceId.startDate")
    @Mapping(target = "endDate", source = "priceId.endDate")
    @Mapping(target = "priceList", source = "priceId.priceList")
    @Mapping(target = "productId", source = "priceId.productId")
    @Mapping(target = "priority", source = "priceId.priority")
    Price toDomain(PriceEntity priceEntity);
}
