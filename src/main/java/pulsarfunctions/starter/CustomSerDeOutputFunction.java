package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import pulsarfunctions.starter.serde.Tweet;

public class CustomSerDeOutputFunction implements Function<String, Tweet> {
    @Override
    public Tweet process(String input, Context context) {
        Tweet tweet = new Tweet();
        tweet.setUsername(input);
        return tweet;
    }
}
