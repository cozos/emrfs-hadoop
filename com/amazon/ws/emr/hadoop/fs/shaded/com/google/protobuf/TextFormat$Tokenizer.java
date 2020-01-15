package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TextFormat$Tokenizer
{
  private final CharSequence text;
  private final Matcher matcher;
  private String currentToken;
  private int pos = 0;
  private int line = 0;
  private int column = 0;
  private int previousLine = 0;
  private int previousColumn = 0;
  private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
  private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
  private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
  private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
  private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);
  
  private TextFormat$Tokenizer(CharSequence text)
  {
    this.text = text;
    matcher = WHITESPACE.matcher(text);
    skipWhitespace();
    nextToken();
  }
  
  public boolean atEnd()
  {
    return currentToken.length() == 0;
  }
  
  public void nextToken()
  {
    previousLine = line;
    previousColumn = column;
    while (pos < matcher.regionStart())
    {
      if (text.charAt(pos) == '\n')
      {
        line += 1;
        column = 0;
      }
      else
      {
        column += 1;
      }
      pos += 1;
    }
    if (matcher.regionStart() == matcher.regionEnd())
    {
      currentToken = "";
    }
    else
    {
      matcher.usePattern(TOKEN);
      if (matcher.lookingAt())
      {
        currentToken = matcher.group();
        matcher.region(matcher.end(), matcher.regionEnd());
      }
      else
      {
        currentToken = String.valueOf(text.charAt(pos));
        matcher.region(pos + 1, matcher.regionEnd());
      }
      skipWhitespace();
    }
  }
  
  private void skipWhitespace()
  {
    matcher.usePattern(WHITESPACE);
    if (matcher.lookingAt()) {
      matcher.region(matcher.end(), matcher.regionEnd());
    }
  }
  
  public boolean tryConsume(String token)
  {
    if (currentToken.equals(token))
    {
      nextToken();
      return true;
    }
    return false;
  }
  
  public void consume(String token)
    throws TextFormat.ParseException
  {
    if (!tryConsume(token)) {
      throw parseException("Expected \"" + token + "\".");
    }
  }
  
  public boolean lookingAtInteger()
  {
    if (currentToken.length() == 0) {
      return false;
    }
    char c = currentToken.charAt(0);
    return (('0' <= c) && (c <= '9')) || (c == '-') || (c == '+');
  }
  
  public String consumeIdentifier()
    throws TextFormat.ParseException
  {
    for (int i = 0; i < currentToken.length(); i++)
    {
      char c = currentToken.charAt(i);
      if ((('a' > c) || (c > 'z')) && (('A' > c) || (c > 'Z')) && (('0' > c) || (c > '9')) && (c != '_') && (c != '.')) {
        throw parseException("Expected identifier.");
      }
    }
    String result = currentToken;
    nextToken();
    return result;
  }
  
  public int consumeInt32()
    throws TextFormat.ParseException
  {
    try
    {
      int result = TextFormat.parseInt32(currentToken);
      nextToken();
      return result;
    }
    catch (NumberFormatException e)
    {
      throw integerParseException(e);
    }
  }
  
  public int consumeUInt32()
    throws TextFormat.ParseException
  {
    try
    {
      int result = TextFormat.parseUInt32(currentToken);
      nextToken();
      return result;
    }
    catch (NumberFormatException e)
    {
      throw integerParseException(e);
    }
  }
  
  public long consumeInt64()
    throws TextFormat.ParseException
  {
    try
    {
      long result = TextFormat.parseInt64(currentToken);
      nextToken();
      return result;
    }
    catch (NumberFormatException e)
    {
      throw integerParseException(e);
    }
  }
  
  public long consumeUInt64()
    throws TextFormat.ParseException
  {
    try
    {
      long result = TextFormat.parseUInt64(currentToken);
      nextToken();
      return result;
    }
    catch (NumberFormatException e)
    {
      throw integerParseException(e);
    }
  }
  
  public double consumeDouble()
    throws TextFormat.ParseException
  {
    if (DOUBLE_INFINITY.matcher(currentToken).matches())
    {
      boolean negative = currentToken.startsWith("-");
      nextToken();
      return negative ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    }
    if (currentToken.equalsIgnoreCase("nan"))
    {
      nextToken();
      return NaN.0D;
    }
    try
    {
      double result = Double.parseDouble(currentToken);
      nextToken();
      return result;
    }
    catch (NumberFormatException e)
    {
      throw floatParseException(e);
    }
  }
  
  public float consumeFloat()
    throws TextFormat.ParseException
  {
    if (FLOAT_INFINITY.matcher(currentToken).matches())
    {
      boolean negative = currentToken.startsWith("-");
      nextToken();
      return negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
    }
    if (FLOAT_NAN.matcher(currentToken).matches())
    {
      nextToken();
      return NaN.0F;
    }
    try
    {
      float result = Float.parseFloat(currentToken);
      nextToken();
      return result;
    }
    catch (NumberFormatException e)
    {
      throw floatParseException(e);
    }
  }
  
  public boolean consumeBoolean()
    throws TextFormat.ParseException
  {
    if ((currentToken.equals("true")) || (currentToken.equals("t")) || (currentToken.equals("1")))
    {
      nextToken();
      return true;
    }
    if ((currentToken.equals("false")) || (currentToken.equals("f")) || (currentToken.equals("0")))
    {
      nextToken();
      return false;
    }
    throw parseException("Expected \"true\" or \"false\".");
  }
  
  public String consumeString()
    throws TextFormat.ParseException
  {
    return consumeByteString().toStringUtf8();
  }
  
  public ByteString consumeByteString()
    throws TextFormat.ParseException
  {
    List<ByteString> list = new ArrayList();
    consumeByteString(list);
    while ((currentToken.startsWith("'")) || (currentToken.startsWith("\""))) {
      consumeByteString(list);
    }
    return ByteString.copyFrom(list);
  }
  
  private void consumeByteString(List<ByteString> list)
    throws TextFormat.ParseException
  {
    char quote = currentToken.length() > 0 ? currentToken.charAt(0) : '\000';
    if ((quote != '"') && (quote != '\'')) {
      throw parseException("Expected string.");
    }
    if ((currentToken.length() < 2) || (currentToken.charAt(currentToken.length() - 1) != quote)) {
      throw parseException("String missing ending quote.");
    }
    try
    {
      String escaped = currentToken.substring(1, currentToken.length() - 1);
      
      ByteString result = TextFormat.unescapeBytes(escaped);
      nextToken();
      list.add(result);
    }
    catch (TextFormat.InvalidEscapeSequenceException e)
    {
      throw parseException(e.getMessage());
    }
  }
  
  public TextFormat.ParseException parseException(String description)
  {
    return new TextFormat.ParseException(line + 1, column + 1, description);
  }
  
  public TextFormat.ParseException parseExceptionPreviousToken(String description)
  {
    return new TextFormat.ParseException(previousLine + 1, previousColumn + 1, description);
  }
  
  private TextFormat.ParseException integerParseException(NumberFormatException e)
  {
    return parseException("Couldn't parse integer: " + e.getMessage());
  }
  
  private TextFormat.ParseException floatParseException(NumberFormatException e)
  {
    return parseException("Couldn't parse number: " + e.getMessage());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.TextFormat.Tokenizer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */