package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import pulsarfunctions.starter.serde.Tweet;

public class CustomSerDeInputFunction implements Function<Tweet, String> {
    @Override
    public String process(Tweet tweet, Context context) {
        return tweet.getUsername();
    }
}
