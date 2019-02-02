package com.finalproject.serviceone.repository;

import com.finalproject.serviceone.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Integer> {
 Sell findBySellPriceLessThan(int sellPrice);

}
