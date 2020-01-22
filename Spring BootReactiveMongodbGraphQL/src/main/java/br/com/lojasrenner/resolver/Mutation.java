package br.com.lojasrenner.resolver;

import br.com.lojasrenner.model.Price;
import br.com.lojasrenner.repository.PriceRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final PriceRepository priceRepository;

    public Optional<Price> newPrice(String productId, Integer loc, Integer productGrandId, BigDecimal regularRetail, BigDecimal unitRetail, Integer sellingUnitRetail, Boolean clearanceInd, Integer sku) {
        Price p = new Price();

        p.setProductId(productId);
        p.setLoc(loc);
        p.setProductGrandId(productGrandId);
        p.setRegularRetail(regularRetail);
        p.setUnitRetail(unitRetail);
        p.setSellingUnitRetail(sellingUnitRetail);
        p.setClearanceInd(clearanceInd);
        p.setSku(sku);
        //p.setCreationDate(LocalDateTime.now());
        p.setCreationDate("");

        Mono<Price> priceMono = priceRepository.save(p);
        return priceMono.blockOptional();
    }
}
