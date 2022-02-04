package br.com.fiap.ecommerce.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ResourcesUtil {

    public static String decodeParam(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date convertDate(String textDate, Date defaultValue){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("BET"));
        try {
            return simpleDateFormat.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
