package com.ntc.hive.udf;

/**
 * Copyright @2015 R&D, NTC Inc. (ntc.com)
 *
 * Author: Eric x.sun <eric.x.sun@gmail.com>
 */

public class TestParseJsonWithPath {
    public static void main(String[] args) {
        String jsonPath;
        ParseJsonWithPath parseJsonWithPath = new ParseJsonWithPath();

        String json = "{\n" +
            "    \"store\": {\n" +
            "        \"book\": [\n" +
            "            {\"price\": \"10.1\"},\n" +
            "            {\"price\": 8.95},\n" +
            "            {\"price\": 12.99},\n" +
            "            {\"price\": 8.99},\n" +
            "            {\"price\": 22.99}\n" +
            "        ],\n" +
            "    },\n" +
            "    \"expensive\": 10\n" +
            "}";

        jsonPath = "$.store.book[?(@.price)].price";
        System.out.println("price<=90: " + parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[?(@.price != 90)].price";
        System.out.println("price >90: " + parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[*].price";
        System.out.println("All Price: " + parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[1:3].price";
        System.out.println("First three price: " + parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[3:].price";
        System.out.println(parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[-3:].price";
        System.out.println(parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[?(@.price <= 12)].price";
        System.out.println(parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[?(@.author=~/.*rees/i)]";
        System.out.println(parseJsonWithPath.evaluate(json, jsonPath));

        jsonPath = "$.store.book[*]['price', 'title']";
        System.out.println(parseJsonWithPath.evaluate(json, jsonPath));
    }
}
