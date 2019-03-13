package fr.orleans.miage.ocr.client.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 400 : return new ProductBadRequestException("Requete incorrecte !");
            case 404 : return new ProductNotFoundException("Produit non trouvé ");
        }

        return defaultErrorDecoder.decode(s, response);
    }
}
