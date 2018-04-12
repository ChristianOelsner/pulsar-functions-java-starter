package pulsarfunctions.starter.javanative;

import java.util.function.Function;

public class SimpleStringFunction implements Function<String, String> {
    @Override
    public String apply(String input) {
        return "This is my function!";
    }
}
