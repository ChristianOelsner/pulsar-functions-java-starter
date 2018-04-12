package pulsarfunctions.starter.javanative;

import pulsarfunctions.starter.serde.Tweet;

import java.util.function.Function;

public class CustomSerDeOutputFunction implements Function<String, Tweet> {
    @Override
    public Tweet apply(String input) {
        Tweet tweet = new Tweet();
        tweet.setUsername(input);
        return tweet;
    }
}
