package fr.orleans.miage.ocr.client.proxies;

import fr.orleans.miage.ocr.client.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-produits", url = "localhost:9001")
public interface MSProduitProxy {

    @GetMapping(value = "/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping(value = "/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);

}
