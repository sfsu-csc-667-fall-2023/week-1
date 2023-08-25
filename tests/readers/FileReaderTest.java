package tests.readers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import readers.FileReader;

public class FileReaderTest {

  private String createTestFile(List<String> content) throws IOException {
    File file = File.createTempFile("tempFile", null);

    FileWriter writer = new FileWriter(file);

    for (int index = 0; index < content.size(); index++) {
      writer.write(
          String.format("%s%s", content.get(index), System.lineSeparator()));
    }

    writer.close();

    return file.getAbsolutePath();
  }

  @Test
  public void testStringConstructor() {
    FileReader reader = new FileReader("hello");
  }

  @Test
  public void testHasNextNonExistentFile() {
    FileReader reader = new FileReader("nonexistentfile");

    assertFalse(reader.hasNext());
  }

  @Test
  public void testHasNextEmptyFile() throws IOException {
    String path = createTestFile(Arrays.asList());

    FileReader reader = new FileReader(path);

    assertFalse(reader.hasNext());
  }

  @Test
  public void testNextSingleLine() throws IOException {
    String path = createTestFile(Arrays.asList("this is a line"));

    FileReader reader = new FileReader(path);

    assertTrue(reader.hasNext());
    reader.next();
    assertFalse(reader.hasNext());
  }

  @Test
  public void testNextFourLine() throws IOException {
    String path = createTestFile(Arrays.asList("line1", "line2", "line3", "line4"));

    FileReader reader = new FileReader(path);

    assertTrue(reader.hasNext());
    reader.next();
    assertTrue(reader.hasNext());
    reader.next();
    assertTrue(reader.hasNext());
    reader.next();
    assertTrue(reader.hasNext());
    reader.next();

    assertFalse(reader.hasNext());
  }

  @Test
  public void testNext() throws IOException {
    String first = "line1", second = "line2", third = "line3", fourth = "line4";

    String path = createTestFile(Arrays.asList(first, second, third, fourth));

    FileReader reader = new FileReader(path);

    assertEquals(first, reader.next());
    assertEquals(second, reader.next());
    assertEquals(third, reader.next());
    assertEquals(fourth, reader.next());
  }
}