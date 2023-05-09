package backend.matrix.controller;

import backend.matrix.model.CPriceDto;
import backend.matrix.model.CPriceRequest;
import backend.matrix.service.CPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/prices")
public class CPriceController {
    @Autowired
    private final CPriceService priceService;

    public CPriceController(CPriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<CPriceDto> getPrice(
            @RequestBody CPriceRequest priceRequest) {
        CPriceDto price = priceService.getPrice(
                priceRequest.getBrandId(),
                priceRequest.getProductId(),
                priceRequest.getApplicationDate());
        return ResponseEntity.ok(price);
    }
}


