package br.com.lojasrenner.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@ToString
public class Price {
    @Id
    private String productId;
    private Integer loc;
    private Integer productGrandId;
    private BigDecimal regularRetail;
    private BigDecimal unitRetail;
    private Integer sellingUnitRetail;
    private Boolean clearanceInd;
    private Integer sku;
    private String creationDate;
}
