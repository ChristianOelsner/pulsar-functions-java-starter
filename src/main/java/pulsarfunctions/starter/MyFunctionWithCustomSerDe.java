package pulsarfunctions.starter;

import pulsarfunctions.starter.serde.Tweet;

import java.util.function.Function;

public class MyFunctionWithCustomSerDe implements Function<Tweet, String> {
    @Override
    public String apply(Tweet input) {
        String username = input.getUsername();
        return username;
    }
}
