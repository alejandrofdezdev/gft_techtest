package gft.techtest.infrastructure.outbound.database;

import gft.techtest.infrastructure.outbound.database.entity.PriceEntity;
import gft.techtest.infrastructure.outbound.database.entity.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, PriceId> {

    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.priceId.brandId = :brandId " +
            "AND p.priceId.productId = :productId " +
            "AND p.priceId.startDate <= :date " +
            "AND p.priceId.endDate >= :date " +
            "ORDER BY p.priceId.priority DESC " +
            "LIMIT 1")
    Optional<PriceEntity> findApplicablePrice(Long brandId, Long productId, LocalDateTime date);
}
