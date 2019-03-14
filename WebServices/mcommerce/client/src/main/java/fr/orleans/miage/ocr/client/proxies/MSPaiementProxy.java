package fr.orleans.miage.ocr.client.proxies;

import fr.orleans.miage.ocr.client.beans.PaiementBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server", contextId = "ms-paiements")
public interface MSPaiementProxy {

    @PostMapping(value = "/ms-paiements/paiement")
    ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);

}
