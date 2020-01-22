package br.com.lojasrenner.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
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
//    private LocalDateTime lastUpdate;
}
