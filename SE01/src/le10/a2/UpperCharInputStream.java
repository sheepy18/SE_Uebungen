package le10.a2;

import java.io.IOException;
import java.io.InputStream;

public class UpperCharInputStream extends InputStream{
    private InputStream stream;

    public UpperCharInputStream(InputStream stream) {
        super();
        this.stream = stream;
    }

    @Override
    public int read() throws IOException {
        return Character.toUpperCase(stream.read());
    }
}
