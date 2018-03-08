package pulsarfunctions.starter;

import pulsarfunctions.starter.serde.Tweet;

import java.util.function.Function;

public class MyFunctionWithCustomSerDe implements Function<Tweet, Void> {
    @Override
    public void apply(Tweet input) {
        return null;
    }
}
