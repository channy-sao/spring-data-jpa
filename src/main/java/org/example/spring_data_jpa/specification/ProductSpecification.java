package org.example.spring_data_jpa.specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.spring_data_jpa.entity.Product;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {
    public static Specification<Product> findByName(String name) {
        return ((root, query, criteriaBuilder) -> {
            if(name == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%");
        });
    }

    public static Specification<Product> findByCategoryName(String categoryName) {
        return ((root, query, criteriaBuilder) -> {
            if(categoryName == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("category").get("name"), "%" + categoryName + "%");
        });
    }
}
