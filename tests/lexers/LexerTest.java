package tests.lexers;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lexers.KeyValuePairCollection;
import lexers.Lexer;

public class LexerTest {
  @Test
  public void testExistence() {
    Lexer lexer = new Lexer(new Iterator<String>() {

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public String next() {
        return "";
      }
    });
  }

  @Test
  public void testLex() {
    String[][] testValues = {
        { "key1", "value1" },
        { "key2", "value2" }
    };

    Lexer lexer = new Lexer(new Iterator<String>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < testValues.length;
      }

      @Override
      public String next() {
        return String.format("%s %s", testValues[index][0], testValues[index][1]);
      }

    });

    KeyValuePairCollection pairs = lexer.lex();

    assertEquals(testValues[0][1], pairs.get(testValues[0][0]));
    assertEquals(testValues[1][1], pairs.get(testValues[1][0]));
    assertEquals("doesnt exist", null);
  }
}
