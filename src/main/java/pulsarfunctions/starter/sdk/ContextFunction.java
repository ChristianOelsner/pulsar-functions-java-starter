package pulsarfunctions.starter.sdk;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

import java.util.stream.Collectors;

public class ContextFunction implements Function<String, String> {
    @Override
    public String process(String input, Context context) {
        Logger LOG = context.getLogger();

        String functionTenant = context.getTenant();
        String functionNamespace = context.getNamespace();
        String functionName = context.getFunctionName();
        String fullyQualifiedFunctionName = String.format("%s/%s/%s", functionTenant, functionNamespace, functionName);
        String functionId = context.getFunctionId();
        String instanceId = context.getInstanceId();
        String functionVersion = context.getFunctionVersion();
        String inputTopics = context.getInputTopics().stream().collect(Collectors.joining(", "));
        String outputTopic = context.getOutputTopic();
        String messageId = new String(context.getMessageId());
        String messageTopic = context.getTopicName();
        String userValue = context.getUserConfigValueOrDefault("key1", "No value specified");

        LOG.info("Function info\n=============");
        LOG.info("  Function tenant: {}", functionTenant);
        LOG.info("  Function namespace: {}", functionNamespace);
        LOG.info("  Function name: {}", functionName);
        LOG.info("  Fully qualified function name (aka FQFN), in tenant/namespace/name form: {}", fullyQualifiedFunctionName);
        LOG.info("  Function ID: {}", functionId);
        LOG.info("  Function instance ID: {}", instanceId);
        LOG.info("  Function version: {}", functionVersion);
        LOG.info("  Function input topics: {}", inputTopics);
        LOG.info("  Function output topic: {}", outputTopic);
        LOG.info("  Message ID: {}", messageId);
        LOG.info("  Message produced on topic: {}", messageTopic);
        LOG.info("  User config for the key key1: {}", userValue);

        String counterKey = String.format("%s-invocations", fullyQualifiedFunctionName);
        context.incrCounter(counterKey, 1);

        return input;
    }
}
