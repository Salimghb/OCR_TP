package fr.orleans.miage.ocr.client.beans;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PaiementBean {

    private int id;

    private Integer idCommande;

    private Integer montant;

    private Long numeroCarte;

}
