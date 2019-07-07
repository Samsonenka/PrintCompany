package com.samson.printCompany.repos;

import com.samson.printCompany.models.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepo extends JpaRepository<Clothes, Integer> {
}
