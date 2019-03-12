package fr.orleans.miage.ocr.ecommerce.web.controllers;


import fr.orleans.miage.ocr.ecommerce.dao.ProductDao;
import fr.orleans.miage.ocr.ecommerce.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description = "API exposant les produits du site d'ecommerce")
@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @ApiOperation(value = "Affichage liste des produits")
    @GetMapping(value="/produits")
    public List<Product> listeProduits() {

        List<Product> mesProduits = productDao.findAll();

//        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
//
//        FilterProvider listeDeMesFiltres = new SimpleFilterProvider().addFilter("myFilter", monFiltre);
//
//        MappingJacksonValue mesProduitsFiltres = new MappingJacksonValue(mesProduits);
//
//        mesProduitsFiltres.setFilters(listeDeMesFiltres);

        return mesProduits;
    }


    @ApiOperation(value = "Affichage d'un produit")
    @GetMapping(value = "/produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    @ApiOperation(value = "Ajout d'un produit")
    @PostMapping(value = "/produits")
    public ResponseEntity<Product> ajouterProduit(@RequestBody Product product){
        Product productAdded =  productDao.save(product);

        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Suppression d'un produit")
    @DeleteMapping(value = "/produits/{id}")
    public void deleteProduit (@PathVariable int id){
        productDao.deleteById(id);
    }

    @ApiOperation(value = "Modification d'un produit")
    @PutMapping (value = "/produits")
    public void updateProduit(@RequestBody Product product) {
        productDao.save(product);
    }

    @ApiOperation(value = "TestRequete1")
    @GetMapping(value = "test1/produits/{prixLimit}")
    public List<Product> testeDeRequetes1(@PathVariable int prixLimit) {
        return productDao.findByPrixGreaterThan(400);
    }

    @ApiOperation(value = "TestRequete2")
    @GetMapping(value = "test2/produits")
    public Product testeDeRequetes2() {
        return productDao.chercherUnProduitCher(400);
    }



}
