package chap8.chain.of.responsibility;

public class HeaderTextProcessing<T> extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
