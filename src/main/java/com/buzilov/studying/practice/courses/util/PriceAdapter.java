package com.buzilov.studying.practice.courses.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.Locale;

public class PriceAdapter {

    private static double priceAdaptee;
    private static final Locale locale = new Locale("ua", "UA");
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceAdapter.class);

    private PriceAdapter() {
    }

    public static double convertPrice(Locale targetLocale) {
        Double convertedPrice = null;

        HttpURLConnection con = null;

        try {
            String rate = Currency.getInstance(locale).getCurrencyCode() + "_" + Currency.getInstance(locale).getCurrencyCode();
            URL url = new URL("https://free.currconv.com/api/v7/convert?q=" + rate + "&compact=ultra&apiKey=41fd8c894f3241c3a491");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(in);
            JsonNode priceNode = root.path(rate);

            convertedPrice = priceAdaptee / priceNode.asDouble();
        } catch (Exception e) {
            LOGGER.error("Error ocured during converting price: ", e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        return convertedPrice;
    }

}
