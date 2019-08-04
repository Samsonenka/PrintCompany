package com.samson.printCompany.repos;

import com.samson.printCompany.models.ClothesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesOrderRepo extends JpaRepository<ClothesOrder, Integer> {
}
