package pulsarfunctions.starter.sdk;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

public class UserConfigFunction implements Function<String, String> {
    @Override
    public String process(String input, Context context) {
        Logger LOG = context.getLogger();
        String secretWord = (String)context.getUserConfigValueOrDefault("secret", "Open Sesame");

        context.getUserConfigMap().forEach((key, value) -> {
            LOG.info("{\"{}\": \"{}\"}", key, value);
        });

        return (secretWord.equals(input)) ? secretWord : "YOU DIDN'T SAY THE MAGIC WORD!";
    }
}
