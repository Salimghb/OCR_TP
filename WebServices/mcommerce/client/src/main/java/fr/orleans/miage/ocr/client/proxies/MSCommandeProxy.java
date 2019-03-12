package fr.orleans.miage.ocr.client.proxies;

import fr.orleans.miage.ocr.client.beans.CommandeBean;
import fr.orleans.miage.ocr.client.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-commandes", url = "localhost:9002")
public interface MSCommandeProxy {

    @PostMapping(value = "/commandes")
    ResponseEntity<CommandeBean> ajouterCommande(@RequestBody CommandeBean commande);

    @GetMapping(value = "/commandes/{id}")
    CommandeBean recupererUneCommande(@PathVariable int id);

}
