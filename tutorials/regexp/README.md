# Regular Expressions

A regular expression (regex or regexp) is a powerful tool used for pattern matching within strings. It provides a
concise and flexible means for searching, matching, and manipulating text based on patterns.

## Basic Concepts

### Characters

- **Literal Characters**: Match characters exactly as they appear.

  Example: To match the word "hello," the regex would be `hello`.

- **Metacharacters**: Special characters with symbolic meaning.

  Example: The dot (`.`) is a metacharacter that matches any single character.

### Character Classes

In regular expressions, a character class is defined using square brackets `[]`. It allows you to match any single
character from a set of characters.

- **`[abc]`**: Matches any one character that is either 'a', 'b', or 'c'.

You can also use ranges within a character class. For instance:

- **`[a-z]`**: Matches any lowercase letter from 'a' to 'z'.
- **`[0-9]`**: Matches any digit from '0' to '9'.

Additionally, you can use predefined character classes and Unicode property escapes for more specific character sets:

- **`\d`**: Matches any digit (equivalent to `[0-9]`).
- **`\D`**: Matches any non-digit.
- **`\w`**: Matches any word character (alphanumeric + underscore).
- **`\W`**: Matches any non-word character.
- **`\s`**: Matches any whitespace character.
- **`\S`**: Matches any non-whitespace character.
- **`\b`**: Asserts a word boundary.
- **`\B`**: Asserts a position where a word boundary is not present.

When working with Unicode:

- **`\p{L}`**: Matches any kind of letter from any language.
- **`\p{S}`**: Matches any symbol character.

You can combine characters, ranges, and predefined character classes in a single character class:

- **`[a-zA-Z]`**: Matches any uppercase or lowercase letter.
- **`[0-9a-fA-F]`**: Matches any hexadecimal digit.

Character classes are versatile and powerful, allowing you to specify a broad or narrow range of characters to match.

### Anchors

- `^`: Anchors the regex at the beginning of the line.
- `$`: Anchors the regex at the end of the line.

### Escaped Characters

- `\\`: Escapes a metacharacter, allowing it to be treated as a literal character.
- `\.`: Matches a literal dot.

### Groups and Lookarounds

- `()`: Creates a capturing group.
- `(?:)`: Creates a non-capturing group.
- `(?=...)`: Positive lookahead.
- `(?!...)`: Negative lookahead.

### Quantifiers

- `?`: Matches 0 or 1 occurrence of the preceding element.
- `+`: Matches 1 or more occurrences of the preceding element.
- `*`: Matches 0 or more occurrences of the preceding element.
- `{n}`: Matches exactly n occurrences of the preceding element.
- `{n,}`: Matches n or more occurrences.
- `{n,m}`: Matches between n and m occurrences.

### Alternation

- `|`: Acts as an OR operator.

### Unicode Categories

- `\p{L}` or `\p{Letter}`: Matches any kind of letter from any language.
- `\p{Ll}` or `\p{Lowercase_Letter}`: Matches a lowercase letter that has an uppercase variant.
- `\p{Lu}` or `\p{Uppercase_Letter}`: Matches an uppercase letter that has a lowercase variant.
- `\p{Lt}` or `\p{Titlecase_Letter}`: Matches a letter that appears at the start of a word when only the first letter of
  the word is capitalized.
- `\p{L&}` or `\p{Cased_Letter}`: Matches a letter that exists in lowercase and uppercase variants (combination of Ll,
  Lu, and Lt).
- `\p{Lm}` or `\p{Modifier_Letter}`: Matches a special character that is used like a letter.
- `\p{Lo}` or `\p{Other_Letter}`: Matches a letter or ideograph that does not have lowercase and uppercase variants.
- `\p{M}` or `\p{Mark}`: Matches a character intended to be combined with another character (e.g., accents, umlauts,
  enclosing boxes, etc.).
- `\p{Mn}` or `\p{Non_Spacing_Mark}`: Matches a character intended to be combined with another character without taking
  up extra space (e.g., accents, umlauts, etc.).
- `\p{Mc}` or `\p{Spacing_Combining_Mark}`: Matches a character intended to be combined with another character that
  takes up extra space (vowel signs in many Eastern languages).
- `\p{Me}` or `\p{Enclosing_Mark}`: Matches a character that encloses the character it is combined with (circle, square,
  keycap, etc.).
- `\p{Z}` or `\p{Separator}`: Matches any kind of whitespace or invisible separator.
- `\p{Zs}` or `\p{Space_Separator}`: Matches a whitespace character that is invisible but does take up space.
- `\p{Zl}` or `\p{Line_Separator}`: Matches line separator character U+2028.
- `\p{Zp}` or `\p{Paragraph_Separator}`: Matches paragraph separator character U+2029.
- `\p{S}` or `\p{Symbol}`: Matches math symbols, currency signs, dingbats, box-drawing characters, etc.
- `\p{Sm}` or `\p{Math_Symbol}`: Matches any mathematical symbol.
- `\p{Sc}` or `\p{Currency_Symbol}`: Matches any currency sign.
- `\p{Sk}` or `\p{Modifier_Symbol}`: Matches a combining character (mark) as a full character on its own.
- `\p{So}` or `\p{Other_Symbol}`: Matches various symbols that are not math symbols, currency signs, or combining
  characters.
- `\p{N}` or `\p{Number}`: Matches any kind of numeric character in any script.
- `\p{Nd}` or `\p{Decimal_Digit_Number}`: Matches a digit zero through nine in any script except ideographic scripts.
- `\p{Nl}` or `\p{Letter_Number}`: Matches a number that looks like a letter, such as a Roman numeral.
- `\p{No}` or `\p{Other_Number}`: Matches a superscript or subscript digit, or a number that is not a digit 0–9 (
  excluding numbers from ideographic scripts).
- `\p{P}` or `\p{Punctuation}`: Matches any kind of punctuation character.
- `\p{Pd}` or `\p{Dash_Punctuation}`: Matches any kind of hyphen or dash.
- `\p{Ps}` or `\p{Open_Punctuation}`: Matches any kind of opening bracket.
- `\p{Pe}` or `\p{Close_Punctuation}`: Matches any kind of closing bracket.
- `\p{Pi}` or `\p{Initial_Punctuation}`: Matches any kind of opening quote.
- `\p{Pf}` or `\p{Final_Punctuation}`: Matches any kind of closing quote.
- `\p{Pc}` or `\p{Connector_Punctuation}`: Matches a punctuation character such as an underscore that connects words.
- `\p{Po}` or `\p{Other_Punctuation}`: Matches any kind of punctuation character that is not a dash, bracket, quote, or
  connector.
- `\p{C}` or `\p{Other}`: Matches invisible control characters and unused code points.
- `\p{Cc}` or `\p{Control}`: Matches an ASCII or Latin-1 control character: 0x00–0x1F and 0x7F–0x9F.
- `\p{Cf}` or `\p{Format}`: Matches invisible formatting indicator.
- `\p{Co}` or `\p{Private_Use}`: Matches any code point reserved for private use.
- `\p{Cs}` or `\p{Surrogate}`: Matches one half of a surrogate pair in UTF-16 encoding.
- `\p{Cn}` or `\p{Unassigned}`: Matches any code point to which no character has been assigned.

## Examples

```regexp
1. ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$  
   - Matches a typical email address pattern.

2. ^\+\d{1,3}\s?\(\d{1,4}\)\s?\d{6,}$
   - Matches phone numbers with an optional country code.

3. ^\d{4}-\d{2}-\d{2}$
   - Matches dates in the format YYYY-MM-DD.

4. \b\d{3}-\d{2}-\d{4}\b
   - Matches social security numbers (SSN) in the format 123-45-6789.

5. \b\d{1,3}(,\d{3})*\b
   - Matches comma-separated numbers, such as 1,000 or 100,000,000.

6. ^[a-zA-Z]+\s\d+$
   - Matches a pattern with one or more letters followed by whitespace and one or more digits.

7. (?i)^[a-z]+$
   - Matches lowercase words case-insensitively.

8. \b(?:https?|ftp)://\S+\b
   - Matches URLs starting with http, https, or ftp.

9. ^\d{1,2}:\d{2} (AM|PM)$
   - Matches time in 12-hour format with AM/PM.

10. \b(?:[0-9]{1,3}\.){3}[0-9]{1,3}\b
    - Matches IPv4 addresses.

11. \d{1,3}(?:,\d{3})*(?:\.\d{2})?
    - Matches numbers with optional commas for thousands and optional decimal places.

```

## How to Build a Regular Expression

1. **Define the Pattern**: Clearly define the pattern you want to match.
2. **Choose Metacharacters, Quantifiers, and Character Classes**: Select appropriate metacharacters, quantifiers, and
   character classes to define the quantity and type of characters in your pattern.
3. **Use Unicode Categories and Anchors**: Incorporate Unicode categories and anchors for more robust pattern matching.
4. **Escape Characters and Use Groups and Lookarounds**: Employ escaped characters, groups, and lookarounds for more
   complex patterns.
5. **Test and Refine**: Test your regex with sample data and refine it as needed until it accurately matches the desired
   patterns.

## Useful Websites for Regular Expressions

If you're looking to enhance your understanding of regular expressions or need a platform for testing and debugging your
regex patterns, check out these useful websites:

1. [Regular-Expressions.info Tutorial](https://www.regular-expressions.info/tutorial.html)
    - A comprehensive tutorial on regular expressions covering basic to advanced topics. It provides in-depth
      explanations and examples.

2. [regex101](https://regex101.com/)
    - An interactive online regex tester and debugger. It allows you to test your regular expressions against sample
      text and provides detailed explanations of each part of your pattern.

3. [RegexPlanet](https://www.regexplanet.com/advanced/java/index.html)
    - A regex testing tool that supports various programming languages. It provides a platform to test your regex
      patterns in a specific programming language context.

