package fr.orleans.miage.ocr.client.proxies;

import fr.orleans.miage.ocr.client.beans.PaiementBean;
import fr.orleans.miage.ocr.client.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ms-paiements", url = "localhost:9003")
public interface MSPaiementProxy {

    @PostMapping(value = "/paiement")
    public ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);

}
