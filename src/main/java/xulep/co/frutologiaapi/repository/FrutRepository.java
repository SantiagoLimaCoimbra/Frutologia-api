package xulep.co.frutologiaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xulep.co.frutologiaapi.entity.Frut;

@Repository
public interface FrutRepository extends JpaRepository<Frut, Long> {

    @Query(value = "SELECT f FROM Frut f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Frut findByName(@Param("name") String name);

}