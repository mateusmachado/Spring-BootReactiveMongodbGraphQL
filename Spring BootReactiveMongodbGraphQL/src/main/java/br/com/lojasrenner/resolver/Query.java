package br.com.lojasrenner.resolver;

import br.com.lojasrenner.model.Price;
import br.com.lojasrenner.repository.PriceRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final PriceRepository priceRepository;

    public Iterable<Price> findAllPrice() {
        return priceRepository.findAll().toIterable();
    }

    public Optional<Price> findPriceByProductId(String productId) {
        return priceRepository.findById(productId).blockOptional();
    }

    public Optional<Long> countPrice() {
        return priceRepository.count().blockOptional();
    }
}
