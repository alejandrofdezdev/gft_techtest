package gft.techtest.unit.infrastructure.inbound.rest;

import gft.techtest.application.PriceUseCases;
import gft.techtest.domain.entity.Price;
import gft.techtest.infrastructure.inbound.rest.PriceController;
import gft.techtest.infrastructure.inbound.rest.dto.PriceResponseDTO;
import gft.techtest.infrastructure.inbound.rest.dto.PriceResponseDTOMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {
    @InjectMocks
    private PriceController sut;
    @Mock
    private PriceUseCases priceUseCases;
    @Mock
    private PriceResponseDTOMapper priceResponseDTOMapper;

    @Test
    void givenBrandIdProductIdAndApplicationDate_whenFindApplicablePrice_thenReturnResponseEntityOk() {
        // Given
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Price toReturn = new Price();

        doReturn(toReturn).when(priceUseCases).findApplicablePrice(brandId, productId, applicationDate);

        PriceResponseDTO priceResponseDTO = new PriceResponseDTO();
        doReturn(priceResponseDTO).when(priceResponseDTOMapper).toDTO(toReturn);

        // When
        ResponseEntity<PriceResponseDTO> price = sut.findApplicablePrice(brandId, productId, applicationDate);

        // Then
        assertNotNull(price);
        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(priceResponseDTO, price.getBody());

        verify(priceUseCases).findApplicablePrice(brandId, productId, applicationDate);
    }

}