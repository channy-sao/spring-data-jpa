package org.example.spring_data_jpa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Product Response")
public class ProductResponse {
    @Schema(example = "1", description = "id of product")
    private Long id;
    @Schema(example = "iPhone 16",description = "name of product")
    private String name;
    @Schema(example = "abcd    hahah", description = "description of product")
    private String description;
    @Schema(example = "1700",description = "product price")
    private BigDecimal price;
    @Schema(description = "category detail of product")
    private CategoryResponse category;

    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
