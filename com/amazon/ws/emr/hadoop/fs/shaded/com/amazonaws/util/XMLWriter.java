package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Stack;

public class XMLWriter
{
  private static final String PROLOG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  private final Writer writer;
  private final String xmlns;
  private Stack<String> elementStack = new Stack();
  private boolean rootElement = true;
  
  public XMLWriter(Writer w)
  {
    this(w, null);
  }
  
  public XMLWriter(Writer w, String xmlns)
  {
    writer = w;
    this.xmlns = xmlns;
    append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
  }
  
  public XMLWriter startElement(String element)
  {
    append("<" + element);
    if ((rootElement) && (xmlns != null))
    {
      append(" xmlns=\"" + xmlns + "\"");
      rootElement = false;
    }
    append(">");
    elementStack.push(element);
    return this;
  }
  
  public XMLWriter endElement()
  {
    String lastElement = (String)elementStack.pop();
    append("</" + lastElement + ">");
    return this;
  }
  
  public XMLWriter value(String s)
  {
    append(escapeXMLEntities(s));
    return this;
  }
  
  public XMLWriter value(ByteBuffer b)
  {
    append(escapeXMLEntities(Base64.encodeAsString(BinaryUtils.copyBytesFrom(b))));
    return this;
  }
  
  public XMLWriter value(Date date)
  {
    append(escapeXMLEntities(StringUtils.fromDate(date)));
    return this;
  }
  
  public XMLWriter value(Object obj)
  {
    append(escapeXMLEntities(obj.toString()));
    return this;
  }
  
  private void append(String s)
  {
    try
    {
      writer.append(s);
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to write XML document", e);
    }
  }
  
  private String escapeXMLEntities(String s)
  {
    if (s.contains("&"))
    {
      s = s.replace("&quot;", "\"");
      s = s.replace("&apos;", "'");
      s = s.replace("&lt;", "<");
      s = s.replace("&gt;", ">");
      
      s = s.replace("&amp;", "&");
    }
    s = s.replace("&", "&amp;");
    s = s.replace("\"", "&quot;");
    s = s.replace("'", "&apos;");
    s = s.replace("<", "&lt;");
    s = s.replace(">", "&gt;");
    return s;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XMLWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */