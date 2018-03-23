package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class MyFunctionWithContext implements Function<String, String> {
    @Override
    public String process(String input, Context context) {
        return input;
    }
}
