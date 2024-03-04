package gft.techtest.unit.application;

import gft.techtest.application.PriceUseCases;
import gft.techtest.domain.entity.Price;
import gft.techtest.domain.port.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PriceUseCasesTest {
    @InjectMocks
    private PriceUseCases sut;

    @Mock
    private PriceService priceService;

    @Test
    void givenBrandIdProductIdAndApplicationDate_whenFindApplicablePrice_thenReturnPrice() {
        // Given
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        Price toReturn = new Price();

        doReturn(toReturn).when(priceService).findApplicablePrice(brandId, productId, applicationDate);

        // When
        Price price = sut.findApplicablePrice(brandId, productId, applicationDate);

        // Then
        assertNotNull(price);
        assertEquals(toReturn, price);

        verify(priceService).findApplicablePrice(brandId, productId, applicationDate);
    }

}