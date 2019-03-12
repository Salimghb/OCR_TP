package fr.orleans.miage.ocr.client.beans;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommandeBean {

    private int id;

    private Integer productId;

    private Date dateCommande;

    private Integer quantite;

    private Boolean commandePayee;

}
