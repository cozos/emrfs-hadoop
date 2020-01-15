package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.FormattedHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;

public class BufferedHeader
  implements FormattedHeader, Cloneable, Serializable
{
  private static final long serialVersionUID = -2768352615787625448L;
  private final String name;
  private final CharArrayBuffer buffer;
  private final int valuePos;
  
  public BufferedHeader(CharArrayBuffer buffer)
    throws ParseException
  {
    Args.notNull(buffer, "Char array buffer");
    int colon = buffer.indexOf(58);
    if (colon == -1) {
      throw new ParseException("Invalid header: " + buffer.toString());
    }
    String s = buffer.substringTrimmed(0, colon);
    if (s.length() == 0) {
      throw new ParseException("Invalid header: " + buffer.toString());
    }
    this.buffer = buffer;
    name = s;
    valuePos = (colon + 1);
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getValue()
  {
    return buffer.substringTrimmed(valuePos, buffer.length());
  }
  
  public HeaderElement[] getElements()
    throws ParseException
  {
    ParserCursor cursor = new ParserCursor(0, buffer.length());
    cursor.updatePos(valuePos);
    return BasicHeaderValueParser.INSTANCE.parseElements(buffer, cursor);
  }
  
  public int getValuePos()
  {
    return valuePos;
  }
  
  public CharArrayBuffer getBuffer()
  {
    return buffer;
  }
  
  public String toString()
  {
    return buffer.toString();
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BufferedHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */