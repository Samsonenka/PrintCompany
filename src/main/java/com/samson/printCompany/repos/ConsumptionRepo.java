package com.samson.printCompany.repos;

import com.samson.printCompany.models.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepo extends JpaRepository<Consumption, Integer> {
}
