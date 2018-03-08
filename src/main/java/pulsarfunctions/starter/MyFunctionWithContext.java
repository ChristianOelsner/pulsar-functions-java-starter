package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.PulsarFunction;

public class MyFunctionWithContext implements PulsarFunction<String, String> {
    @Override
    public String process(String input, Context context) {
        return
    }
}
