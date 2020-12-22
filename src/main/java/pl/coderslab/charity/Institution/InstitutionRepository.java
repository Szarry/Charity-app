package pl.coderslab.charity.Institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstitutionRepository extends JpaRepository <Institution, Long> {

    Institution findById(long id);
    Institution findInstitutionById(long id);


    @Query(value = "select * from institution ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List <Institution> getRandomInstitutionList();
}
