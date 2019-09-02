package javaeight.stream.eight.chain.of.responsibility;

public class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
