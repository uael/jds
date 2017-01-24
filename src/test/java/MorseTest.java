import org.junit.Assert;
import org.junit.Test;
import org.uael.Morse;

public class MorseTest {
  private final static String morse = ".-/.-../--./--- .-/...-";
  private final static String morseDecoded = "ALGO AV";

  @Test
  public void decodeChar() throws Exception {
    Assert.assertEquals('V', Morse.decodeChar("...-"));
    Assert.assertEquals('K', Morse.decodeChar("-.-"));
  }

  @Test
  public void decode() throws Exception {
    Assert.assertEquals(morseDecoded, Morse.decode(morse));
  }

  @Test
  public void encode() throws Exception {
    Assert.assertEquals(morse, Morse.encode(morseDecoded));
    Assert.assertEquals("...-", Morse.encode('V'));
    Assert.assertEquals("-.-", Morse.encode('K'));
  }
}
