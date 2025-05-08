package com.learning.exproductservice.Repository;

import com.learning.exproductservice.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByPrdname(String prdname);
    //Filtering purpose
    Page<Product> findByPrdnameContainingIgnoreCase(String prdname, Pageable pageable);
    //Custom Query
//    @Query(value="select prdname,prdprice from product where prddesc LIKE %:word%", nativeQuery=true)
//    Optional<Product> findByPrddesc(@Param("word") String prddesc);

}
