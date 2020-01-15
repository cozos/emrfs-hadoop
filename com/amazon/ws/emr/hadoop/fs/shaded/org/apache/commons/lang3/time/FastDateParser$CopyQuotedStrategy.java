package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

class FastDateParser$CopyQuotedStrategy
  extends FastDateParser.Strategy
{
  private final String formatField;
  
  FastDateParser$CopyQuotedStrategy(String formatField)
  {
    super(null);
    this.formatField = formatField;
  }
  
  boolean isNumber()
  {
    char c = formatField.charAt(0);
    if (c == '\'') {
      c = formatField.charAt(1);
    }
    return Character.isDigit(c);
  }
  
  boolean addRegex(FastDateParser parser, StringBuilder regex)
  {
    FastDateParser.access$100(regex, formatField, true);
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.FastDateParser.CopyQuotedStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */