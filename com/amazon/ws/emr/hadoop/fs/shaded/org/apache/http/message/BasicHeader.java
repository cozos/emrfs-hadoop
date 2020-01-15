package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;

@Contract(threading=ThreadingBehavior.IMMUTABLE)
public class BasicHeader
  implements Header, Cloneable, Serializable
{
  private static final HeaderElement[] EMPTY_HEADER_ELEMENTS = new HeaderElement[0];
  private static final long serialVersionUID = -5427236326487562174L;
  private final String name;
  private final String value;
  
  public BasicHeader(String name, String value)
  {
    this.name = ((String)Args.notNull(name, "Name"));
    this.value = value;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public HeaderElement[] getElements()
    throws ParseException
  {
    if (getValue() != null) {
      return BasicHeaderValueParser.parseElements(getValue(), null);
    }
    return EMPTY_HEADER_ELEMENTS;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public String toString()
  {
    return BasicLineFormatter.INSTANCE.formatHeader(null, this).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */