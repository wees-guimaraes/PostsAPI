package br.com.fiap.ecommerce.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class ResourcesUtil {

    public static String decodeParam(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
