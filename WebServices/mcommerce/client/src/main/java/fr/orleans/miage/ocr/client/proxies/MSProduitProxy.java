package fr.orleans.miage.ocr.client.proxies;

import fr.orleans.miage.ocr.client.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server", contextId = "ms-produits")
public interface MSProduitProxy {

    @GetMapping(value = "/ms-produits/Produits")
    List<ProductBean> listeDesProduits();

    /*
     * Notation @PathVariable("id") qui est différente de celle qu'on utlise dans le contrôleur
     **/
    @GetMapping( value = "/ms-produits/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);



}
