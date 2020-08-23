package core.rest;

import core.models.Exchange;
import core.models.Rate;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GetRestData {

    final static String BASE_URL = "https://api.ratesapi.io/api/";

    public static Exchange getLatestForeignExchangeRates(){
        return getDataByOptions("latest");
    }

    public static Exchange getLatestForeignExchangeRatesWithSymbols(String symbols){
        return getDataByOptions("latest?symbols=" + symbols);
    }

    public static Exchange getLatestForeignExchangeRatesWithBase(String base){
        return getDataByOptions("latest?base=" + base);
    }

    public static Exchange getLatestForeignExchangeRatesWithSymbolsAndBase(String symbols, String base){
        return getDataByOptions("latest?base=" + base + "&symbols=" + symbols);
    }

    public static Exchange getSpecificDateForeignExchangeRates(String date){
        return getDataByOptions(date);
    }

    public static Exchange getSpecificDateForeignExchangeRatesWithSymbols(String date, String symbols){
        return getDataByOptions(date + "?symbols=" + symbols);
    }

    public static Exchange getSpecificDateForeignExchangeRatesWithBase(String date, String base){
        return getDataByOptions(date + "?base=" + base);
    }

    public static Exchange getSpecificDateForeignExchangeRatesWithSymbolsAndBase(String date, String symbols, String base){
        return getDataByOptions(date + "?base=" + base + "&symbols=" + symbols);
    }

    private static Exchange getDataByOptions(String options) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get(options);

        assertThat(response.getStatusCode()).isEqualTo(200);

        String jsonString = response.asString();
        String base = JsonPath.from(jsonString).get("base");
        String date = JsonPath.from(jsonString).get("date");
        HashMap<String, Float> rates = JsonPath.from(jsonString).get("rates");
        List<Rate> rateList = new ArrayList<>();

        rates.forEach((exchange, cost) -> rateList.add(new Rate(exchange, cost)));

        return new Exchange(base, rateList, date);
    }
}
