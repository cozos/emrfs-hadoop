package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter
{
  List<String> tags = new ArrayList();
  StringBuilder sb = new StringBuilder();
  
  public XmlWriter start(String name)
  {
    sb.append("<").append(name).append(">");
    tags.add(name);
    return this;
  }
  
  public XmlWriter start(String name, String attr, String value)
  {
    sb.append("<").append(name);
    writeAttr(attr, value);
    sb.append(">");
    tags.add(name);
    return this;
  }
  
  public XmlWriter start(String name, String[] attrs, String[] values)
  {
    sb.append("<").append(name);
    for (int i = 0; i < Math.min(attrs.length, values.length); i++) {
      writeAttr(attrs[i], values[i]);
    }
    sb.append(">");
    tags.add(name);
    return this;
  }
  
  public XmlWriter end()
  {
    assert (tags.size() > 0);
    String name = (String)tags.remove(tags.size() - 1);
    sb.append("</").append(name).append(">");
    return this;
  }
  
  public byte[] getBytes()
  {
    assert (tags.size() == 0);
    return toString().getBytes(StringUtils.UTF8);
  }
  
  public String toString()
  {
    return sb.toString();
  }
  
  public XmlWriter value(String value)
  {
    appendEscapedString(value, sb);
    return this;
  }
  
  private void writeAttr(String name, String value)
  {
    sb.append(' ').append(name).append("=\"");
    appendEscapedString(value, sb);
    sb.append("\"");
  }
  
  private void appendEscapedString(String s, StringBuilder builder)
  {
    if (s == null) {
      s = "";
    }
    int start = 0;
    int len = s.length();
    for (int pos = 0; pos < len; pos++)
    {
      char ch = s.charAt(pos);
      String escape;
      String escape;
      String escape;
      String escape;
      String escape;
      String escape;
      String escape;
      String escape;
      switch (ch)
      {
      case '\t': 
        escape = "&#9;";
        break;
      case '\n': 
        escape = "&#10;";
        break;
      case '\r': 
        escape = "&#13;";
        break;
      case '&': 
        escape = "&amp;";
        break;
      case '"': 
        escape = "&quot;";
        break;
      case '<': 
        escape = "&lt;";
        break;
      case '>': 
        escape = "&gt;";
        break;
      default: 
        escape = null;
      }
      if (escape != null)
      {
        if (start < pos) {
          builder.append(s, start, pos);
        }
        sb.append(escape);
        start = pos + 1;
      }
    }
    if (start < pos) {
      sb.append(s, start, pos);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */