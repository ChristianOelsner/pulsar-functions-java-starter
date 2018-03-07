package org.apache.pulsar.functions.api.starter;

import java.util.function.Function;

public class MyFunction implements Function<String, String> {
    @Override
    public String apply(String input) {
        return "This is my function!";
    }
}
