package br.com.lojasrenner.resolver;

import br.com.lojasrenner.model.Price;
import br.com.lojasrenner.repository.PriceRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceResolver implements GraphQLResolver<Price> {

    private final PriceRepository priceRepository;

    public Iterable<Price> getPrice(Price p) {
        return priceRepository.findAllByProductId(p.getProductId()).toIterable();
    }

}
