package fr.orleans.miage.ocr.client.controllers;

import fr.orleans.miage.ocr.client.beans.ProductBean;
import fr.orleans.miage.ocr.client.proxies.MSProduitProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private MSProduitProxy produitProxy;

    @GetMapping(value = "produits")
    public String accueil(Model model){

        List<ProductBean> productBeans = produitProxy.listeDesProduits();

        model.addAttribute("produits", productBeans);

        return "Accueil";
    }

    @GetMapping(value = "produits/{id}")
    public String accueil(Model model, @PathVariable int id){

        ProductBean produit = produitProxy.recupererUnProduit(id);

        model.addAttribute("produit", produit);

        return "Produit";
    }
}
