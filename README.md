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
        - filename string (input to the program via command line) [input to system - args param in main]
        - key/value pairs
            - Assuming: k/v are strings
            - Map
    * What are the roles that objects in this system will play?
        - A reader of bytes (data in a specific format)
            - IKeyValueReader: read -> returns the next k/v line (the string terminator by system line terminator) Iterator?
        - An outputter (UI?)
            - inputs: data maintainer, output stream, output: the data in the correct format
            - toOutput
        - A data maintainer - hold all the KVs
            - IDataMaintainer: getValue, put (Map we talked about above)
        - A k/v pair data thing
            - IKVThing: getKey, getValue
        - A k/v line parser
            - ILineParser: parseLine(String line) -> KV object (return String[] (0 index is the key, 1+ indeces are the values))
        - An error handler
* How can we guard against change?
    * Multiple values for a single key
    * Fetch keys by value
    * Comments or blank lines
    * Output format may change
    * Input format may change (why just a file?)
    * Anything else?