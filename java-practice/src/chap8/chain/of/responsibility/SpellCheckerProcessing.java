package chap8.chain.of.responsibility;

public class SpellCheckerProcessing<T> extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
