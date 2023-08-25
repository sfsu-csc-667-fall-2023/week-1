package lexers;

import java.util.HashMap;
import java.util.Map;

public class KeyValuePairCollection {
  private Map<String, String> keyValues;

  public KeyValuePairCollection() {
    this.keyValues = new HashMap<>();
  }

  public void insert(String key, String value) {
    this.keyValues.put(key, value);
  }

  public String get(String key) {
    return this.keyValues.get(key);
  }
}
