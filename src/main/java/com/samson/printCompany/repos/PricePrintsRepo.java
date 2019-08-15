package com.samson.printCompany.repos;

import com.samson.printCompany.models.PricePrints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricePrintsRepo extends JpaRepository<PricePrints, Integer> {
}
