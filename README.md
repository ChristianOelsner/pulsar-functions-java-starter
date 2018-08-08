# Pulsar Functions Java Starter

This repo houses some example [Pulsar Functions](http://pulsar.incubator.apache.org/docs/latest/functions/overview/) written in Java. These functions can all be run either in [local mode](http://pulsar.incubator.apache.org/docs/latest/functions/overview#local-run) or in [cluster mode](http://pulsar.incubator.apache.org/docs/latest/functions/overview#cluster-mode).

## Requirements

You'll need to have [Maven](https://maven.apache.org) installed.

## Setup

Pulsar Functions written in Java need to be packaged as a "fat" jar. To create a fat jar:

```bash
$ mvn package
```

To deploy and run the functions in this repo, you'll need to navigate to the [Pulsar repo](https://github.com/apache/incubator-pulsar) and use the `pulsar-admin` executable in the `bin` folder. We recommend setting the path to the jar file created in this repo as an environment variable:

```bash
$ export PULSAR_FUNCTIONS_JAR=`pwd`/target/pulsar-functions-0.1.0-SNAPSHOT-jar-with-dependencies.jar
$ cd /path/to/incubator-pulsar

# Example create command
$ bin/pulsar-admin functions create \
  --jar $PULSAR_FUNCTIONS_JAR \
  --className pulsarfunctions.starter.javanative.SimpleStringFunction \
  --inputs input_topic \
  --output output_topic
```

## Included functions

The following example functions are included in this repo:

Function name | Description | API used
:-------------|:------------|:--------
[`ExclamationFunction`](src/main/java/pulsarfunctions/starter/javanative/ExclamationFunction.java) | Treats incoming message as string and appends exclamation('!') to it | [Java native API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-native)
[`SimpleStringFunction`](src/main/java/pulsarfunctions/starter/javanative/SimpleStringFunction.java) | Ignores the input to the function and simply outputs the string `"This is my function!"` every time a message arrives | [Java native API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-native)
[`CustomSerDeInputFunction`](src/main/java/pulsarfunctions/starter/javanative/CustomSerDeInputFunction.java) | This function uses a custom serialization class for deserializing input message ([`TweetSerDe`](src/main/java/pulsarfunctions/starter/serde/TweetSerDe.java)) to type [`Tweet`](src/main/java/pulsarfunctions/starter/serde/Tweet.java) objects | [Java native API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-native)
[`CustomSerDeOutputFunction`](src/main/java/pulsarfunctions/starter/javanative/CustomSerDeOutputFunction.java) | This function uses a custom serialization class for serializing output message ([`TweetSerDe`](src/main/java/pulsarfunctions/starter/serde/TweetSerDe.java)) from type [`Tweet`](src/main/java/pulsarfunctions/starter/serde/Tweet.java) objects | [Java native API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-native)
[`LogFunction`](src/main/java/pulsarfunctions/starter/sdk/LogFunction.java) | This function uses the inbuilt sdk's functionality to route log messages to a log topic | [Java SDK API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-sdk)
[`PublishFunction`](src/main/java/pulsarfunctions/starter/sdk/PublishFunction.java) | This function uses the inbuilt sdk's functionality to publish messages to a specific topic | [Java SDK API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-sdk)
[`UserConfigFunction`](src/main/java/pulsarfunctions/starter/sdk/UserConfigFunction.java) | This function uses the inbuilt sdk's functionality to get command line parameters inside the function runtime | [Java SDK API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-sdk)
[`WordCountFunction`](src/main/java/pulsarfunctions/starter/sdk/WordCountFunction.java) | This function uses the inbuilt sdk's state functionality to do word count | [Java SDK API](http://pulsar.incubator.apache.org/docs/latest/functions/api#java-sdk)