# Week 1 Programming Prompt

## Prompt 1

### Specification 1
Create a program that can:
* Accept the name of a file as a command line argument
* Read from that file, assuming it contains content in the following format
  ```
  key value\n
  key2 value2\n
  ```
    * Any amount of whitespace may exist between keys and values
    * Line terminators will be system dependent
* Record the key/value pairs such that a value can be retrieved by its key
* Output the key/value pairs as a list, with a special terminal string:
  ```
  key: value\n
  key2: value2\n
  END\n
  ```

### Design 1
* What do we need to create?
    * What is the data? 
      - text file (contents of the text file)
      - pair (key, value)
    * What are the roles that objects in this system will play?
      - KeyValuePairCollection: insert(k, v), read(k) => v
      - Line: process() => 2 values
      - Lexer: lex() => KeyValuePairCollection
      - ~~Reader: next(), hasNext()~~
      - Driver
















* How can we guard against change?
    * Multiple values for a single key
    * Fetch keys by value
    * Comments or blank lines
    * Output format may change
    * Input format may change (why just a file?)
    * Anything else?