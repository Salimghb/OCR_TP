package fr.orleans.miage.ocr.client.proxies;

import fr.orleans.miage.ocr.client.beans.CommandeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server", contextId = "ms-commandes")
public interface MSCommandeProxy {

    @PostMapping(value = "/ms-commandes/commandes")
    ResponseEntity<CommandeBean> ajouterCommande(@RequestBody CommandeBean commande);

    @GetMapping(value = "/ms-commandes/commandes/{id}")
    CommandeBean recupererUneCommande(@PathVariable int id);

}
