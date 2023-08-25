package readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileReader implements Iterator<String> {
  private List<String> contents;
  private int index;

  public FileReader(String path) {
    this.index = 0;

    try {
      this.contents = Files.readAllLines(Path.of(path));
    } catch (IOException e) {
      this.contents = Arrays.asList();
    }
  }

  public boolean hasNext() {
    return this.index < this.contents.size();
  }

  public String next() {
    if (!this.hasNext()) {
      return "";
    }

    return this.contents.get(this.index++);
  }

}
