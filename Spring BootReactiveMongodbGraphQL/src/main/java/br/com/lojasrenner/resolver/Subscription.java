package br.com.lojasrenner.resolver;

import br.com.lojasrenner.model.Price;
import br.com.lojasrenner.repository.PriceRepository;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Subscription implements GraphQLSubscriptionResolver {

    private final PriceRepository priceRepository;

    public Publisher<Price> getNewPrice() {
        return priceRepository.findWithTailableCursorBy();
    }
}
