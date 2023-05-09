package backend.matrix.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CPriceRequest {
    private Integer brandId;
    private Integer productId;
    private LocalDateTime applicationDate;


}



