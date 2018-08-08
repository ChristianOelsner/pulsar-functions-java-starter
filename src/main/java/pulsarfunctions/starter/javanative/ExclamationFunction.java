package pulsarfunctions.starter.javanative;

import java.util.function.Function;

public class ExclamationFunction implements Function<String, String> {
    @Override
    public String apply(String input) {
        return input + "!";
    }
}
