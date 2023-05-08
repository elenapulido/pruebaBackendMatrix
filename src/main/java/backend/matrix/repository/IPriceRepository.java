package backend.matrix.repository;


import backend.matrix.model.CPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
    public interface IPriceRepository extends JpaRepository<CPrice, Long> {

        List<CPrice>findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
                Integer brandId,
                Integer productId,
                LocalDateTime startDate,
                LocalDateTime endDate);

    }






