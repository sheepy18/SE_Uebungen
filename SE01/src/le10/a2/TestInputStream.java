package le10.a2;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TestInputStream {

    InputStream input;
    String text = "";
    String readText = "";

    @Test
    public void read() {
        text = "abc";
        input = new UpperCharInputStream(new ByteArrayInputStream(text.getBytes()));
        try {
            for (int i = 0; i < text.length(); i++) {
                readText += (char) input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("ABC", readText);
    }

    @Test
    public void setInput() {
        text = "HAllo, Lukas!";
        input = new UpperCharInputStream(new ByteArrayInputStream(text.getBytes()));
        try {
            for (int i = 0; i < text.length(); i++) {
                readText += (char) input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("HALLO, LUKAS!", readText);
    }
}
