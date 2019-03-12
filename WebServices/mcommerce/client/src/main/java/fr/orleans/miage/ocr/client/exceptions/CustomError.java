package fr.orleans.miage.ocr.client.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomError implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 400){
            return new ProductBadRequestException("Requete incorrecte !");
        }

        return defaultErrorDecoder.decode(s, response);
    }
}
