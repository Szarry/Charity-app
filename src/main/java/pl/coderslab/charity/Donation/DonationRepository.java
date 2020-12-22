package pl.coderslab.charity.Donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationRepository extends JpaRepository <Donation, Long> {

    @Query(value = "select COUNT(id) as count from donation", nativeQuery = true)
    Integer countId();

    @Query(value = "select SUM(quantity) from donation", nativeQuery = true)
    Integer sumQuantity();
}