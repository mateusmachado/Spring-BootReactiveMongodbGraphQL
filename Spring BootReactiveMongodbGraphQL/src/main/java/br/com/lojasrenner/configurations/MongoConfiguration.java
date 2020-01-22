package br.com.lojasrenner.configurations;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    //@Value("${spring.data.mongodb.database:test}")
    private String database;

    //@Value("${spring.data.mongodb.host:localhost}:${spring.data.mongodb.port:27017}")
    private String host;

    @Autowired
    private MappingMongoConverter mongoConverter;

    // Converts . into a mongo friendly char
    @PostConstruct
    public void setUpMongoEscapeCharacterConversion() {
        mongoConverter.setMapKeyDotReplacement("_");
    }

    @Override
    protected String getDatabaseName() {
        return "price";
    }


    @Bean
    @Override
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
        converterList.add(new MongoLocalDateTimeFromStringConverter());
        return new CustomConversions(converterList);
    }

    @Override
    public MongoClient mongoClient() {

        return new MongoClient("localhost:27017");
    }

    private static final class MongoLocalDateTimeFromStringConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String source) {
            return source == null ? null : LocalDateTime.parse(source);
        }
    }
}