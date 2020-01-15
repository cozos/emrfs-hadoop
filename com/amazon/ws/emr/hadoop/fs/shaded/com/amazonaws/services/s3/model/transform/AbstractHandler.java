package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

abstract class AbstractHandler
  extends DefaultHandler
{
  private final StringBuilder text = new StringBuilder();
  private final LinkedList<String> context = new LinkedList();
  
  public final void startElement(String uri, String name, String qName, Attributes attrs)
  {
    text.setLength(0);
    doStartElement(uri, name, qName, attrs);
    context.add(name);
  }
  
  protected abstract void doStartElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes);
  
  public final void endElement(String uri, String name, String qName)
  {
    context.removeLast();
    doEndElement(uri, name, qName);
  }
  
  protected abstract void doEndElement(String paramString1, String paramString2, String paramString3);
  
  public final void characters(char[] ch, int start, int length)
  {
    text.append(ch, start, length);
  }
  
  protected final String getText()
  {
    return text.toString();
  }
  
  protected final boolean atTopLevel()
  {
    return context.isEmpty();
  }
  
  protected final boolean in(String... path)
  {
    if (path.length != context.size()) {
      return false;
    }
    int i = 0;
    for (String element : context)
    {
      String pattern = path[i];
      if ((!pattern.equals("*")) && (!pattern.equals(element))) {
        return false;
      }
      i++;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.AbstractHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */