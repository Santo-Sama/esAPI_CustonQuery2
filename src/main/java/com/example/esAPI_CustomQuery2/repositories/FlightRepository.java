package com.example.esAPI_CustomQuery2.repositories;

import com.example.esAPI_CustomQuery2.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "select * from flights f where f.status_enum_id = :p1 or f.status_enum_id = :p2", nativeQuery = true)
    List<Flight> findTwoStatus(@Param("p1") Integer p1, @Param("p2") Integer p2);
}