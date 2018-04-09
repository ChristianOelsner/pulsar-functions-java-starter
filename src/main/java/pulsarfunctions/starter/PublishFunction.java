package pulsarfunctions.starter;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

public class PublishFunction implements Function<String, Void> {
    private static final String TOPIC_1 = "persistent://sample/standalone/ns1/topic-1";
    private static final String TOPIC_2 = "persistent://sample/standalone/ns1/topic-2";

    @Override
    public Void process(String input, Context context) {
        Logger LOG = context.getLogger();

        if (input.contains("some-word")) {
            context.publish(TOPIC_1, input);
        } else if (input.contains("other-word")) {
            context.publish(TOPIC_2, input.toLowerCase());
        } else {

        }

        return null;
    }
}
