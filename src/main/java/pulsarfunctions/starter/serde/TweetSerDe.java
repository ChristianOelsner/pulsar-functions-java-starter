package pulsarfunctions.starter.serde;

import org.apache.pulsar.functions.api.SerDe;

public class TweetSerDe implements SerDe<Tweet> {
    @Override
    public Tweet deserialize(byte[] input) {
        String username = new String(input);
        return new Tweet();
    }

    @Override
    public byte[] serialize(Tweet input) {
        return new byte[]{};
    }
}
