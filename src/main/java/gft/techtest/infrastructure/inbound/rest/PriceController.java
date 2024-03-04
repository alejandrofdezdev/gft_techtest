package gft.techtest.infrastructure.inbound.rest;

import gft.techtest.application.PriceUseCases;
import gft.techtest.domain.entity.Price;
import gft.techtest.infrastructure.inbound.rest.dto.PriceResponseDTO;
import gft.techtest.infrastructure.inbound.rest.dto.PriceResponseDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceUseCases priceUseCases;
    private final PriceResponseDTOMapper priceResponseDTOMapper;

    @Operation(summary = "Get Price",
            description = "Get the applicable price for a given brand, product, and application date.")
    @GetMapping("/prices")
    public ResponseEntity<PriceResponseDTO> findApplicablePrice(@RequestParam Long brandId,
                                                                @RequestParam Long productId,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
        Price price = priceUseCases.findApplicablePrice(brandId, productId, applicationDate);
        PriceResponseDTO priceResponseDTO = priceResponseDTOMapper.toDTO(price);

        return ResponseEntity.ok(priceResponseDTO);
    }
}

