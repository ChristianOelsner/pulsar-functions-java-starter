package pulsarfunctions.starter.serde;

import org.apache.pulsar.functions.api.SerDe;

public class TweetSerDe implements SerDe<Tweet> {
    @Override
    public Tweet deserialize(byte[] input) {
        String username = new String(input);
        Tweet t = new Tweet();
        t.setUsername(username);
        return t;
    }

    @Override
    public byte[] serialize(Tweet input) {
        return input.getUsername().getBytes();
    }
}
