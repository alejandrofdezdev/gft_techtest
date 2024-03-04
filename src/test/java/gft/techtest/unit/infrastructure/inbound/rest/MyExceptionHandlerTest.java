package gft.techtest.unit.infrastructure.inbound.rest;

import gft.techtest.domain.exception.NotFoundException;
import gft.techtest.infrastructure.inbound.rest.MyExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MyExceptionHandlerTest {

    @Test
    void givenNotFoundException_whenHandleNotFoundException_thenReturnResponseEntity() {
        // Given
        MyExceptionHandler sut = new MyExceptionHandler();
        NotFoundException ex = new NotFoundException();

        // When
        ResponseEntity<Object> responseEntity = sut.handleNotFoundException(ex);

        // Then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(ex.getMessage(), responseEntity.getBody());
    }

}