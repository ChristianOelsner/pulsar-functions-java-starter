package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

import java.util.Map;

public class LogFunction implements Function<String, Void> {
    @Override
    public Void process(String input, Context context) {
        Logger LOG = context.getLogger();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Message received with ID %s and payload %s\n",
                new String(context.getMessageId()), input));
        stringBuilder.append(String.format("  Fully qualified function name (tenant/namespace/name): %s/%s/%s\n",
                context.getTenant(),
                context.getNamespace(),
                context.getFunctionName()));
        stringBuilder.append(String.format("  Function ID: %s. Function version: %s.",
                context.getFunctionId(),
                context.getFunctionVersion()));

        Map<String, String> userConfigs = context.getUserConfigMap();

        if (userConfigs.size() > 0) {
            stringBuilder.append("  User configs:");
            userConfigs.forEach((k, v) -> {
                stringBuilder.append(String.format("    %s: %s", k, v));
            });
        }

        LOG.info(stringBuilder.toString());

        return null;
    }
}
