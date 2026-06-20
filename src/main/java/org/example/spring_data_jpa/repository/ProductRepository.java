package org.example.spring_data_jpa.repository;

import org.example.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Optional<Product> findByNameIgnoreCase(String name);
    List<Product> findByCategoryId(Long categoryId);


    // JPQL
    // @Query("SELECT p FROM Product p where p.category.name =:cn")
    @Query(value = "SELECT p FROM products p inner join categories c on c.id = p.category_id where c.name =:cn", nativeQuery = true)
    List<Product> findByCategoryName(@Param(value = "cn") String categoryName);
}
