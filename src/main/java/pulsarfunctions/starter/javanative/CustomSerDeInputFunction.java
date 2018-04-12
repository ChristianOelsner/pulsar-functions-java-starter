package pulsarfunctions.starter.javanative;

import pulsarfunctions.starter.serde.Tweet;

import java.util.function.Function;

public class CustomSerDeInputFunction implements Function<Tweet, String> {
    @Override
    public String apply(Tweet tweet) {
        return tweet.getUsername();
    }
}
