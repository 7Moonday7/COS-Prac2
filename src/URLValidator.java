import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class URLValidator {
    // Регулярное выражение для проверки URL
    private static final String URL_PATTERN = "^(https?://)?([a-zA-Z0-9-]{2,}\\.)+[a-zA-Z]{2,}(:\\d+)?(/[^\\s]*)?(\\?[^#\\s]*)?(#[^\\s]*)?$";

    private final Pattern pattern;

    public URLValidator() {
        pattern = Pattern.compile(URL_PATTERN);
    }

    public boolean isValidURL(String url) {
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
