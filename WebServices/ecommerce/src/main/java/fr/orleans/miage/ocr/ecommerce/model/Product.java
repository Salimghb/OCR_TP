package fr.orleans.miage.ocr.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
//@JsonFilter(value = "myFilter")
public class Product {

    //Privée
    @Id
    @GeneratedValue
    private int id;

    //Publiques
    private String nom;
    private int prix;

    //Privée
    private int prixAchat;

}
