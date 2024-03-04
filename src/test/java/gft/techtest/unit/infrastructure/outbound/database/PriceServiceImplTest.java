package gft.techtest.unit.infrastructure.outbound.database;

import gft.techtest.domain.entity.Price;
import gft.techtest.domain.exception.NotFoundException;
import gft.techtest.infrastructure.outbound.database.PriceRepository;
import gft.techtest.infrastructure.outbound.database.PriceServiceImpl;
import gft.techtest.infrastructure.outbound.database.entity.PriceEntity;
import gft.techtest.infrastructure.outbound.database.entity.PriceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @InjectMocks
    private PriceServiceImpl sut;
    @Mock
    private PriceRepository repository;
    @Mock
    private PriceMapper mapper;

    @Test
    void givenBrandIdProductIdAndApplicationDate_whenFindApplicablePrice_thenReturnPrice() {
        // Given
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        PriceEntity toMap = new PriceEntity();
        Price toReturn = new Price();

        doReturn(Optional.of(toMap)).when(repository).findApplicablePrice(brandId, productId, applicationDate);
        doReturn(toReturn).when(mapper).toDomain(toMap);

        // When
        Price price = sut.findApplicablePrice(brandId, productId, applicationDate);

        // Then
        assertNotNull(price);
        assertEquals(toReturn, price);

        verify(repository).findApplicablePrice(brandId, productId, applicationDate);
        verify(mapper).toDomain(toMap);
    }

    @Test
    void givenBrandIdProductIdAndApplicationDate_whenNothingFound_thenThrowException() {
        // Given
        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        doReturn(Optional.empty()).when(repository).findApplicablePrice(brandId, productId, applicationDate);

        assertThrows(NotFoundException.class, () -> sut.findApplicablePrice(brandId, productId, applicationDate));

        verify(repository).findApplicablePrice(brandId, productId, applicationDate);
    }

}