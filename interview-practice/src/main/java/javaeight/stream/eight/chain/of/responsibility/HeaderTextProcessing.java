package javaeight.stream.eight.chain.of.responsibility;

public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
