package xulep.co.frutologiaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xulep.co.frutologiaapi.entity.Frut;

import java.util.List;
import java.util.Optional;

@Repository
public interface FrutRepository extends JpaRepository<Frut, Long> {

    Frut findByName(String name);

}
