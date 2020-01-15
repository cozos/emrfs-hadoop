package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextFormat
{
  private static final Printer DEFAULT_PRINTER = new Printer(null);
  private static final Printer SINGLE_LINE_PRINTER = new Printer(null).setSingleLineMode(true);
  private static final Printer UNICODE_PRINTER = new Printer(null).setEscapeNonAscii(false);
  private static final int BUFFER_SIZE = 4096;
  
  public static void print(MessageOrBuilder message, Appendable output)
    throws IOException
  {
    DEFAULT_PRINTER.print(message, new TextGenerator(output, null));
  }
  
  public static void print(UnknownFieldSet fields, Appendable output)
    throws IOException
  {
    DEFAULT_PRINTER.printUnknownFields(fields, new TextGenerator(output, null));
  }
  
  public static String shortDebugString(MessageOrBuilder message)
  {
    try
    {
      StringBuilder sb = new StringBuilder();
      SINGLE_LINE_PRINTER.print(message, new TextGenerator(sb, null));
      
      return sb.toString().trim();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String shortDebugString(UnknownFieldSet fields)
  {
    try
    {
      StringBuilder sb = new StringBuilder();
      SINGLE_LINE_PRINTER.printUnknownFields(fields, new TextGenerator(sb, null));
      
      return sb.toString().trim();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String printToString(MessageOrBuilder message)
  {
    try
    {
      StringBuilder text = new StringBuilder();
      print(message, text);
      return text.toString();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String printToString(UnknownFieldSet fields)
  {
    try
    {
      StringBuilder text = new StringBuilder();
      print(fields, text);
      return text.toString();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String printToUnicodeString(MessageOrBuilder message)
  {
    try
    {
      StringBuilder text = new StringBuilder();
      UNICODE_PRINTER.print(message, new TextGenerator(text, null));
      return text.toString();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static String printToUnicodeString(UnknownFieldSet fields)
  {
    try
    {
      StringBuilder text = new StringBuilder();
      UNICODE_PRINTER.printUnknownFields(fields, new TextGenerator(text, null));
      return text.toString();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static void printField(Descriptors.FieldDescriptor field, Object value, Appendable output)
    throws IOException
  {
    DEFAULT_PRINTER.printField(field, value, new TextGenerator(output, null));
  }
  
  public static String printFieldToString(Descriptors.FieldDescriptor field, Object value)
  {
    try
    {
      StringBuilder text = new StringBuilder();
      printField(field, value, text);
      return text.toString();
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static void printFieldValue(Descriptors.FieldDescriptor field, Object value, Appendable output)
    throws IOException
  {
    DEFAULT_PRINTER.printFieldValue(field, value, new TextGenerator(output, null));
  }
  
  public static void printUnknownFieldValue(int tag, Object value, Appendable output)
    throws IOException
  {
    printUnknownFieldValue(tag, value, new TextGenerator(output, null));
  }
  
  private static void printUnknownFieldValue(int tag, Object value, TextGenerator generator)
    throws IOException
  {
    switch (WireFormat.getTagWireType(tag))
    {
    case 0: 
      generator.print(unsignedToString(((Long)value).longValue()));
      break;
    case 5: 
      generator.print(String.format((Locale)null, "0x%08x", new Object[] { (Integer)value }));
      
      break;
    case 1: 
      generator.print(String.format((Locale)null, "0x%016x", new Object[] { (Long)value }));
      break;
    case 2: 
      generator.print("\"");
      generator.print(escapeBytes((ByteString)value));
      generator.print("\"");
      break;
    case 3: 
      DEFAULT_PRINTER.printUnknownFields((UnknownFieldSet)value, generator);
      break;
    case 4: 
    default: 
      throw new IllegalArgumentException("Bad tag: " + tag);
    }
  }
  
  private static final class Printer
  {
    boolean singleLineMode = false;
    boolean escapeNonAscii = true;
    
    private Printer setSingleLineMode(boolean singleLineMode)
    {
      this.singleLineMode = singleLineMode;
      return this;
    }
    
    private Printer setEscapeNonAscii(boolean escapeNonAscii)
    {
      this.escapeNonAscii = escapeNonAscii;
      return this;
    }
    
    private void print(MessageOrBuilder message, TextFormat.TextGenerator generator)
      throws IOException
    {
      for (Map.Entry<Descriptors.FieldDescriptor, Object> field : message.getAllFields().entrySet()) {
        printField((Descriptors.FieldDescriptor)field.getKey(), field.getValue(), generator);
      }
      printUnknownFields(message.getUnknownFields(), generator);
    }
    
    private void printField(Descriptors.FieldDescriptor field, Object value, TextFormat.TextGenerator generator)
      throws IOException
    {
      if (field.isRepeated()) {
        for (Object element : (List)value) {
          printSingleField(field, element, generator);
        }
      } else {
        printSingleField(field, value, generator);
      }
    }
    
    private void printSingleField(Descriptors.FieldDescriptor field, Object value, TextFormat.TextGenerator generator)
      throws IOException
    {
      if (field.isExtension())
      {
        generator.print("[");
        if ((field.getContainingType().getOptions().getMessageSetWireFormat()) && (field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) && (field.isOptional()) && (field.getExtensionScope() == field.getMessageType())) {
          generator.print(field.getMessageType().getFullName());
        } else {
          generator.print(field.getFullName());
        }
        generator.print("]");
      }
      else if (field.getType() == Descriptors.FieldDescriptor.Type.GROUP)
      {
        generator.print(field.getMessageType().getName());
      }
      else
      {
        generator.print(field.getName());
      }
      if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
      {
        if (singleLineMode)
        {
          generator.print(" { ");
        }
        else
        {
          generator.print(" {\n");
          generator.indent();
        }
      }
      else {
        generator.print(": ");
      }
      printFieldValue(field, value, generator);
      if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
      {
        if (singleLineMode)
        {
          generator.print("} ");
        }
        else
        {
          generator.outdent();
          generator.print("}\n");
        }
      }
      else if (singleLineMode) {
        generator.print(" ");
      } else {
        generator.print("\n");
      }
    }
    
    private void printFieldValue(Descriptors.FieldDescriptor field, Object value, TextFormat.TextGenerator generator)
      throws IOException
    {
      switch (TextFormat.1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[field.getType().ordinal()])
      {
      case 1: 
      case 2: 
      case 3: 
        generator.print(((Integer)value).toString());
        break;
      case 4: 
      case 5: 
      case 6: 
        generator.print(((Long)value).toString());
        break;
      case 7: 
        generator.print(((Boolean)value).toString());
        break;
      case 8: 
        generator.print(((Float)value).toString());
        break;
      case 9: 
        generator.print(((Double)value).toString());
        break;
      case 10: 
      case 11: 
        generator.print(TextFormat.unsignedToString(((Integer)value).intValue()));
        break;
      case 12: 
      case 13: 
        generator.print(TextFormat.unsignedToString(((Long)value).longValue()));
        break;
      case 14: 
        generator.print("\"");
        generator.print(escapeNonAscii ? TextFormat.escapeText((String)value) : (String)value);
        
        generator.print("\"");
        break;
      case 15: 
        generator.print("\"");
        generator.print(TextFormat.escapeBytes((ByteString)value));
        generator.print("\"");
        break;
      case 16: 
        generator.print(((Descriptors.EnumValueDescriptor)value).getName());
        break;
      case 17: 
      case 18: 
        print((Message)value, generator);
      }
    }
    
    private void printUnknownFields(UnknownFieldSet unknownFields, TextFormat.TextGenerator generator)
      throws IOException
    {
      for (Iterator i$ = unknownFields.asMap().entrySet().iterator(); i$.hasNext();)
      {
        entry = (Map.Entry)i$.next();
        int number = ((Integer)entry.getKey()).intValue();
        UnknownFieldSet.Field field = (UnknownFieldSet.Field)entry.getValue();
        printUnknownField(number, 0, field.getVarintList(), generator);
        
        printUnknownField(number, 5, field.getFixed32List(), generator);
        
        printUnknownField(number, 1, field.getFixed64List(), generator);
        
        printUnknownField(number, 2, field.getLengthDelimitedList(), generator);
        for (UnknownFieldSet value : field.getGroupList())
        {
          generator.print(((Integer)entry.getKey()).toString());
          if (singleLineMode)
          {
            generator.print(" { ");
          }
          else
          {
            generator.print(" {\n");
            generator.indent();
          }
          printUnknownFields(value, generator);
          if (singleLineMode)
          {
            generator.print("} ");
          }
          else
          {
            generator.outdent();
            generator.print("}\n");
          }
        }
      }
      Map.Entry<Integer, UnknownFieldSet.Field> entry;
    }
    
    private void printUnknownField(int number, int wireType, List<?> values, TextFormat.TextGenerator generator)
      throws IOException
    {
      for (Object value : values)
      {
        generator.print(String.valueOf(number));
        generator.print(": ");
        TextFormat.printUnknownFieldValue(wireType, value, generator);
        generator.print(singleLineMode ? " " : "\n");
      }
    }
  }
  
  private static String unsignedToString(int value)
  {
    if (value >= 0) {
      return Integer.toString(value);
    }
    return Long.toString(value & 0xFFFFFFFF);
  }
  
  private static String unsignedToString(long value)
  {
    if (value >= 0L) {
      return Long.toString(value);
    }
    return BigInteger.valueOf(value & 0x7FFFFFFFFFFFFFFF).setBit(63).toString();
  }
  
  private static final class TextGenerator
  {
    private final Appendable output;
    private final StringBuilder indent = new StringBuilder();
    private boolean atStartOfLine = true;
    
    private TextGenerator(Appendable output)
    {
      this.output = output;
    }
    
    public void indent()
    {
      indent.append("  ");
    }
    
    public void outdent()
    {
      int length = indent.length();
      if (length == 0) {
        throw new IllegalArgumentException(" Outdent() without matching Indent().");
      }
      indent.delete(length - 2, length);
    }
    
    public void print(CharSequence text)
      throws IOException
    {
      int size = text.length();
      int pos = 0;
      for (int i = 0; i < size; i++) {
        if (text.charAt(i) == '\n')
        {
          write(text.subSequence(pos, size), i - pos + 1);
          pos = i + 1;
          atStartOfLine = true;
        }
      }
      write(text.subSequence(pos, size), size - pos);
    }
    
    private void write(CharSequence data, int size)
      throws IOException
    {
      if (size == 0) {
        return;
      }
      if (atStartOfLine)
      {
        atStartOfLine = false;
        output.append(indent);
      }
      output.append(data);
    }
  }
  
  private static final class Tokenizer
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
    
    private Tokenizer(CharSequence text)
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
  
  public static class ParseException
    extends IOException
  {
    private static final long serialVersionUID = 3196188060225107702L;
    private final int line;
    private final int column;
    
    public ParseException(String message)
    {
      this(-1, -1, message);
    }
    
    public ParseException(int line, int column, String message)
    {
      super();
      this.line = line;
      this.column = column;
    }
    
    public int getLine()
    {
      return line;
    }
    
    public int getColumn()
    {
      return column;
    }
  }
  
  public static void merge(Readable input, Message.Builder builder)
    throws IOException
  {
    merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
  }
  
  public static void merge(CharSequence input, Message.Builder builder)
    throws TextFormat.ParseException
  {
    merge(input, ExtensionRegistry.getEmptyRegistry(), builder);
  }
  
  public static void merge(Readable input, ExtensionRegistry extensionRegistry, Message.Builder builder)
    throws IOException
  {
    merge(toStringBuilder(input), extensionRegistry, builder);
  }
  
  private static StringBuilder toStringBuilder(Readable input)
    throws IOException
  {
    StringBuilder text = new StringBuilder();
    CharBuffer buffer = CharBuffer.allocate(4096);
    for (;;)
    {
      int n = input.read(buffer);
      if (n == -1) {
        break;
      }
      buffer.flip();
      text.append(buffer, 0, n);
    }
    return text;
  }
  
  public static void merge(CharSequence input, ExtensionRegistry extensionRegistry, Message.Builder builder)
    throws TextFormat.ParseException
  {
    Tokenizer tokenizer = new Tokenizer(input, null);
    while (!tokenizer.atEnd()) {
      mergeField(tokenizer, extensionRegistry, builder);
    }
  }
  
  private static void mergeField(Tokenizer tokenizer, ExtensionRegistry extensionRegistry, Message.Builder builder)
    throws TextFormat.ParseException
  {
    Descriptors.Descriptor type = builder.getDescriptorForType();
    ExtensionRegistry.ExtensionInfo extension = null;
    Descriptors.FieldDescriptor field;
    Descriptors.FieldDescriptor field;
    if (tokenizer.tryConsume("["))
    {
      StringBuilder name = new StringBuilder(tokenizer.consumeIdentifier());
      while (tokenizer.tryConsume("."))
      {
        name.append('.');
        name.append(tokenizer.consumeIdentifier());
      }
      extension = extensionRegistry.findExtensionByName(name.toString());
      if (extension == null) {
        throw tokenizer.parseExceptionPreviousToken("Extension \"" + name + "\" not found in the ExtensionRegistry.");
      }
      if (descriptor.getContainingType() != type) {
        throw tokenizer.parseExceptionPreviousToken("Extension \"" + name + "\" does not extend message type \"" + type.getFullName() + "\".");
      }
      tokenizer.consume("]");
      
      field = descriptor;
    }
    else
    {
      String name = tokenizer.consumeIdentifier();
      field = type.findFieldByName(name);
      if (field == null)
      {
        String lowerName = name.toLowerCase(Locale.US);
        field = type.findFieldByName(lowerName);
        if ((field != null) && (field.getType() != Descriptors.FieldDescriptor.Type.GROUP)) {
          field = null;
        }
      }
      if ((field != null) && (field.getType() == Descriptors.FieldDescriptor.Type.GROUP) && (!field.getMessageType().getName().equals(name))) {
        field = null;
      }
      if (field == null) {
        throw tokenizer.parseExceptionPreviousToken("Message type \"" + type.getFullName() + "\" has no field named \"" + name + "\".");
      }
    }
    Object value = null;
    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
    {
      tokenizer.tryConsume(":");
      String endToken;
      String endToken;
      if (tokenizer.tryConsume("<"))
      {
        endToken = ">";
      }
      else
      {
        tokenizer.consume("{");
        endToken = "}";
      }
      Message.Builder subBuilder;
      Message.Builder subBuilder;
      if (extension == null) {
        subBuilder = builder.newBuilderForField(field);
      } else {
        subBuilder = defaultInstance.newBuilderForType();
      }
      while (!tokenizer.tryConsume(endToken))
      {
        if (tokenizer.atEnd()) {
          throw tokenizer.parseException("Expected \"" + endToken + "\".");
        }
        mergeField(tokenizer, extensionRegistry, subBuilder);
      }
      value = subBuilder.buildPartial();
    }
    else
    {
      tokenizer.consume(":");
      switch (field.getType())
      {
      case INT32: 
      case SINT32: 
      case SFIXED32: 
        value = Integer.valueOf(tokenizer.consumeInt32());
        break;
      case INT64: 
      case SINT64: 
      case SFIXED64: 
        value = Long.valueOf(tokenizer.consumeInt64());
        break;
      case UINT32: 
      case FIXED32: 
        value = Integer.valueOf(tokenizer.consumeUInt32());
        break;
      case UINT64: 
      case FIXED64: 
        value = Long.valueOf(tokenizer.consumeUInt64());
        break;
      case FLOAT: 
        value = Float.valueOf(tokenizer.consumeFloat());
        break;
      case DOUBLE: 
        value = Double.valueOf(tokenizer.consumeDouble());
        break;
      case BOOL: 
        value = Boolean.valueOf(tokenizer.consumeBoolean());
        break;
      case STRING: 
        value = tokenizer.consumeString();
        break;
      case BYTES: 
        value = tokenizer.consumeByteString();
        break;
      case ENUM: 
        Descriptors.EnumDescriptor enumType = field.getEnumType();
        if (tokenizer.lookingAtInteger())
        {
          int number = tokenizer.consumeInt32();
          value = enumType.findValueByNumber(number);
          if (value == null) {
            throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + number + '.');
          }
        }
        else
        {
          String id = tokenizer.consumeIdentifier();
          value = enumType.findValueByName(id);
          if (value == null) {
            throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value named \"" + id + "\".");
          }
        }
        break;
      case MESSAGE: 
      case GROUP: 
        throw new RuntimeException("Can't get here.");
      }
    }
    if (field.isRepeated()) {
      builder.addRepeatedField(field, value);
    } else {
      builder.setField(field, value);
    }
  }
  
  static String escapeBytes(ByteString input)
  {
    StringBuilder builder = new StringBuilder(input.size());
    for (int i = 0; i < input.size(); i++)
    {
      byte b = input.byteAt(i);
      switch (b)
      {
      case 7: 
        builder.append("\\a"); break;
      case 8: 
        builder.append("\\b"); break;
      case 12: 
        builder.append("\\f"); break;
      case 10: 
        builder.append("\\n"); break;
      case 13: 
        builder.append("\\r"); break;
      case 9: 
        builder.append("\\t"); break;
      case 11: 
        builder.append("\\v"); break;
      case 92: 
        builder.append("\\\\"); break;
      case 39: 
        builder.append("\\'"); break;
      case 34: 
        builder.append("\\\""); break;
      default: 
        if (b >= 32)
        {
          builder.append((char)b);
        }
        else
        {
          builder.append('\\');
          builder.append((char)(48 + (b >>> 6 & 0x3)));
          builder.append((char)(48 + (b >>> 3 & 0x7)));
          builder.append((char)(48 + (b & 0x7)));
        }
        break;
      }
    }
    return builder.toString();
  }
  
  static ByteString unescapeBytes(CharSequence charString)
    throws TextFormat.InvalidEscapeSequenceException
  {
    ByteString input = ByteString.copyFromUtf8(charString.toString());
    
    byte[] result = new byte[input.size()];
    int pos = 0;
    for (int i = 0; i < input.size(); i++)
    {
      byte c = input.byteAt(i);
      if (c == 92)
      {
        if (i + 1 < input.size())
        {
          i++;
          c = input.byteAt(i);
          if (isOctal(c))
          {
            int code = digitValue(c);
            if ((i + 1 < input.size()) && (isOctal(input.byteAt(i + 1))))
            {
              i++;
              code = code * 8 + digitValue(input.byteAt(i));
            }
            if ((i + 1 < input.size()) && (isOctal(input.byteAt(i + 1))))
            {
              i++;
              code = code * 8 + digitValue(input.byteAt(i));
            }
            result[(pos++)] = ((byte)code);
          }
          else
          {
            switch (c)
            {
            case 97: 
              result[(pos++)] = 7; break;
            case 98: 
              result[(pos++)] = 8; break;
            case 102: 
              result[(pos++)] = 12; break;
            case 110: 
              result[(pos++)] = 10; break;
            case 114: 
              result[(pos++)] = 13; break;
            case 116: 
              result[(pos++)] = 9; break;
            case 118: 
              result[(pos++)] = 11; break;
            case 92: 
              result[(pos++)] = 92; break;
            case 39: 
              result[(pos++)] = 39; break;
            case 34: 
              result[(pos++)] = 34; break;
            case 120: 
              int code = 0;
              if ((i + 1 < input.size()) && (isHex(input.byteAt(i + 1))))
              {
                i++;
                code = digitValue(input.byteAt(i));
              }
              else
              {
                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
              }
              if ((i + 1 < input.size()) && (isHex(input.byteAt(i + 1))))
              {
                i++;
                code = code * 16 + digitValue(input.byteAt(i));
              }
              result[(pos++)] = ((byte)code);
              break;
            default: 
              throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + (char)c + '\'');
            }
          }
        }
        else
        {
          throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
        }
      }
      else {
        result[(pos++)] = c;
      }
    }
    return ByteString.copyFrom(result, 0, pos);
  }
  
  static class InvalidEscapeSequenceException
    extends IOException
  {
    private static final long serialVersionUID = -8164033650142593304L;
    
    InvalidEscapeSequenceException(String description)
    {
      super();
    }
  }
  
  static String escapeText(String input)
  {
    return escapeBytes(ByteString.copyFromUtf8(input));
  }
  
  static String unescapeText(String input)
    throws TextFormat.InvalidEscapeSequenceException
  {
    return unescapeBytes(input).toStringUtf8();
  }
  
  private static boolean isOctal(byte c)
  {
    return (48 <= c) && (c <= 55);
  }
  
  private static boolean isHex(byte c)
  {
    return ((48 <= c) && (c <= 57)) || ((97 <= c) && (c <= 102)) || ((65 <= c) && (c <= 70));
  }
  
  private static int digitValue(byte c)
  {
    if ((48 <= c) && (c <= 57)) {
      return c - 48;
    }
    if ((97 <= c) && (c <= 122)) {
      return c - 97 + 10;
    }
    return c - 65 + 10;
  }
  
  static int parseInt32(String text)
    throws NumberFormatException
  {
    return (int)parseInteger(text, true, false);
  }
  
  static int parseUInt32(String text)
    throws NumberFormatException
  {
    return (int)parseInteger(text, false, false);
  }
  
  static long parseInt64(String text)
    throws NumberFormatException
  {
    return parseInteger(text, true, true);
  }
  
  static long parseUInt64(String text)
    throws NumberFormatException
  {
    return parseInteger(text, false, true);
  }
  
  private static long parseInteger(String text, boolean isSigned, boolean isLong)
    throws NumberFormatException
  {
    int pos = 0;
    
    boolean negative = false;
    if (text.startsWith("-", pos))
    {
      if (!isSigned) {
        throw new NumberFormatException("Number must be positive: " + text);
      }
      pos++;
      negative = true;
    }
    int radix = 10;
    if (text.startsWith("0x", pos))
    {
      pos += 2;
      radix = 16;
    }
    else if (text.startsWith("0", pos))
    {
      radix = 8;
    }
    String numberText = text.substring(pos);
    
    long result = 0L;
    if (numberText.length() < 16)
    {
      result = Long.parseLong(numberText, radix);
      if (negative) {
        result = -result;
      }
      if (!isLong) {
        if (isSigned)
        {
          if ((result > 2147483647L) || (result < -2147483648L)) {
            throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
          }
        }
        else if ((result >= 4294967296L) || (result < 0L)) {
          throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
        }
      }
    }
    else
    {
      BigInteger bigValue = new BigInteger(numberText, radix);
      if (negative) {
        bigValue = bigValue.negate();
      }
      if (!isLong)
      {
        if (isSigned)
        {
          if (bigValue.bitLength() > 31) {
            throw new NumberFormatException("Number out of range for 32-bit signed integer: " + text);
          }
        }
        else if (bigValue.bitLength() > 32) {
          throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + text);
        }
      }
      else if (isSigned)
      {
        if (bigValue.bitLength() > 63) {
          throw new NumberFormatException("Number out of range for 64-bit signed integer: " + text);
        }
      }
      else if (bigValue.bitLength() > 64) {
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + text);
      }
      result = bigValue.longValue();
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.TextFormat
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */