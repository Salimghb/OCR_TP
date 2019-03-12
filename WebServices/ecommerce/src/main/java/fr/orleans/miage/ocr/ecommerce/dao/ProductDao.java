package fr.orleans.miage.ocr.ecommerce.dao;

import fr.orleans.miage.ocr.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findById(int id);
    List<Product> findByPrixGreaterThan(int prix);

    @Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
    Product chercherUnProduitCher(@Param("prixLimit") int prix);
}
