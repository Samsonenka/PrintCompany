package com.samson.printCompany.repos;

import com.samson.printCompany.models.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrivalRepo extends JpaRepository<Arrival, Integer> {
}
