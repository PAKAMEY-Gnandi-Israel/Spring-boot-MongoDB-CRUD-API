package com.Otaku.Blog.Repository;
import com.Otaku.Blog.model.product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<product, String > {
    @Query("{'name': ?0}")
    Optional<product> findByName(String name);
}
