package com.learning.excontainerdemo;

import com.learning.excontainerdemo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface greetRepository extends JpaRepository<Product,Integer> {
}
