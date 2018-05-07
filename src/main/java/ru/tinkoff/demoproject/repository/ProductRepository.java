package ru.tinkoff.demoproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.tinkoff.demoproject.entity.Products;

import java.util.List;

public interface ProductRepository extends CrudRepository<Products, Long> {

    @Query("SELECT p FROM Products p WHERE p.clientId=:clientId")
    List<Products> findProductsByClientId(@Param("clientId") long clientId);
}
