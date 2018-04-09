package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

import java.util.Arrays;

public class WordCountFunction implements Function<String, Void> {
    @Override
    public Void process(String input, Context context) {
        Arrays.asList(input.split(" ")).forEach(word -> context.incrCounter(word.toLowerCase(), 1));
        return null;
    }
}
