package br.com.lojasrenner.repository;


import br.com.lojasrenner.model.Price;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PriceRepository extends ReactiveCrudRepository<Price, String> {

    @Tailable
    Flux<Price> findWithTailableCursorBy();

    @Query("{ 'productId' :  ?0 }")
    Flux<Price> findAllByProductId(String productId);
}
