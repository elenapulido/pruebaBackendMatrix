package backend.matrix.controller;

import backend.matrix.model.CPriceDto;
import backend.matrix.service.CPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;



public class CPriceControllerTest {

    @Mock
    private CPriceService priceService;

    private CPriceController priceController;


    @BeforeEach
    public void setUp() {
        try {
            priceService = mock(CPriceService.class);
            priceController = new CPriceController(priceService);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetPrice_10am_on_14th() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00");
        CPriceDto expectedPrice = new CPriceDto(1, 35455, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 0, 35.50, "EUR");
        when(priceService.getPrice(1, 35455, applicationDate)).thenReturn(expectedPrice);

        // Act
        ResponseEntity<CPriceDto> response = priceController.getPrice(1, 35455, applicationDate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrice, response.getBody());
    }



    @Test
    public void testGetPrice_16pm_on_14th() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T16:00:00");
        CPriceDto expectedPrice = new CPriceDto(1, 35455, 2, LocalDateTime.parse("2020-06-14T15:00:00"),
                LocalDateTime.parse("2020-06-14T18:30:00"), 1, 25.45, "EUR");
        when(priceService.getPrice(1, 35455, applicationDate)).thenReturn(expectedPrice);

        // Act
        ResponseEntity<CPriceDto> response = priceController.getPrice(1, 35455, applicationDate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrice, response.getBody());
    }

    @Test
    public void testGetPrice_21pm_on_14th() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T21:00:00");
        CPriceDto expectedPrice = new CPriceDto(1, 35455, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 0, 35.50, "EUR");
        when(priceService.getPrice(1, 35455, applicationDate)).thenReturn(expectedPrice);

        // Act
        ResponseEntity<CPriceDto> response = priceController.getPrice(1, 35455, applicationDate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrice, response.getBody());
    }
    @Test
    public void testGetPrice_10am_on_15th() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15T10:00:00");
        CPriceDto expectedPrice = new CPriceDto(1, 35455, 3, LocalDateTime.parse("2020-06-15T00:00:00"),
                LocalDateTime.parse("2020-06-15T11:00:00"), 1, 30.50, "EUR");
        when(priceService.getPrice(1, 35455, applicationDate)).thenReturn(expectedPrice);

        // Act
        ResponseEntity<CPriceDto> response = priceController.getPrice(1, 35455, applicationDate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrice, response.getBody());
    }

    @Test
    public void testGetPrice_9pm_on_16th() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16T21:00:00");
        CPriceDto expectedPrice = new CPriceDto(1, 35455, 4, LocalDateTime.parse("2020-06-15T16:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"), 1, 38.95, "EUR");
        when(priceService.getPrice(1, 35455, applicationDate)).thenReturn(expectedPrice);

        // Act
        ResponseEntity<CPriceDto> response = priceController.getPrice(1, 35455, applicationDate);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrice, response.getBody());
    }

}
