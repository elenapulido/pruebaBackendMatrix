package backend.matrix.service;

import backend.matrix.model.CPrice;
import backend.matrix.model.CPriceDto;
import backend.matrix.repository.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CPriceService {

    private final IPriceRepository priceRepository;

    @Autowired
    public CPriceService(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


        public CPriceDto getPrice(Integer brandId, Integer productId, LocalDateTime applicationDate) {
        List<CPrice> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(brandId, productId, applicationDate, applicationDate);
        if (prices.isEmpty()) {
            throw new IllegalArgumentException("Price not found for brandId " + brandId + ", productId " + productId + ", applicationDate " + applicationDate);
        }

        CPrice price = prices.stream()
                .max(Comparator.comparing(CPrice::getPriority))
                .orElseThrow(() -> new IllegalArgumentException(
                        "No applicable prices found for brandId " + brandId + ", productId " + productId + ", applicationDate " + applicationDate));

        return new CPriceDto(
                price.getBrandId(),
                price.getProductId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPriority(),
                price.getPrice().doubleValue(),
                "EUR"
        );
    }
}
