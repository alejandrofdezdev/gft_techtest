package gft.techtest.infrastructure.inbound.rest.dto;

import gft.techtest.domain.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceResponseDTOMapper {
    @Mapping(target = "startDate", source = "startDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "endDate", source = "endDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    PriceResponseDTO toDTO(Price price);
}
