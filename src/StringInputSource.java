public class StringInputSource implements InputSource {
    private final String input;

    public StringInputSource(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }
}
