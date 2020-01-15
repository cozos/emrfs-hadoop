package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

public class CompositeFormat
  extends Format
{
  private static final long serialVersionUID = -4329119827877627683L;
  private final Format parser;
  private final Format formatter;
  
  public CompositeFormat(Format parser, Format formatter)
  {
    this.parser = parser;
    this.formatter = formatter;
  }
  
  public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos)
  {
    return formatter.format(obj, toAppendTo, pos);
  }
  
  public Object parseObject(String source, ParsePosition pos)
  {
    return parser.parseObject(source, pos);
  }
  
  public Format getParser()
  {
    return parser;
  }
  
  public Format getFormatter()
  {
    return formatter;
  }
  
  public String reformat(String input)
    throws ParseException
  {
    return format(parseObject(input));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.text.CompositeFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */