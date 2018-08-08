package pulsarfunctions.starter.sdk;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

public class LogFunction implements Function<String, Void> {
    private boolean stringIsTooLong(String s, int max) {
        return (s.length() > max);
    }

    @Override
    public Void process(String input, Context context) {
        Logger LOG = context.getLogger();
        int maxLength = Integer.parseInt((String)context.getUserConfigValueOrDefault("max-length", "25"));

        if (stringIsTooLong(input, maxLength)) {
            LOG.info("The incoming string \"{}\" was within the allowable limit of {}", input, maxLength);
        } else {
            LOG.error("The incoming string \"{}\" is too long! Exceeds the limit of {}", input, maxLength);
        }

        return null;
    }
}
