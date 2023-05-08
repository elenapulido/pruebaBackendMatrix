package backend.matrix.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CPriceDto {
    private Integer brandId;
    private Integer productId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    private String currency;

    public CPriceDto(Integer brandId, Integer productId, Integer priceList, LocalDateTime startDate,
                     LocalDateTime endDate, Integer priority, double price, String currency) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.price = BigDecimal.valueOf(price);
        this.currency = currency;
    }

}

