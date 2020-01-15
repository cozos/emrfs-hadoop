package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxUnmarshallerContext
{
  private XMLEvent currentEvent;
  private final XMLEventReader eventReader;
  public final Stack<String> stack = new Stack();
  private String stackString = "";
  private Map<String, String> metadata = new HashMap();
  private List<MetadataExpression> metadataExpressions = new ArrayList();
  private Iterator<?> attributeIterator;
  private final Map<String, String> headers;
  private String currentHeader;
  
  public void setCurrentHeader(String currentHeader)
  {
    this.currentHeader = currentHeader;
  }
  
  public boolean isInsideResponseHeader()
  {
    return currentEvent == null;
  }
  
  public StaxUnmarshallerContext(XMLEventReader eventReader)
  {
    this(eventReader, null);
  }
  
  public StaxUnmarshallerContext(XMLEventReader eventReader, Map<String, String> headers)
  {
    this.eventReader = eventReader;
    this.headers = headers;
  }
  
  public String getHeader(String header)
  {
    if (headers == null) {
      return null;
    }
    return (String)headers.get(header);
  }
  
  public String readText()
    throws XMLStreamException
  {
    if (isInsideResponseHeader()) {
      return getHeader(currentHeader);
    }
    if (currentEvent.isAttribute())
    {
      Attribute attribute = (Attribute)currentEvent;
      return attribute.getValue();
    }
    StringBuilder sb = new StringBuilder();
    for (;;)
    {
      XMLEvent event = eventReader.peek();
      if (event.getEventType() == 4)
      {
        eventReader.nextEvent();
        sb.append(event.asCharacters().getData());
      }
      else
      {
        if (event.getEventType() == 2) {
          return sb.toString();
        }
        throw new RuntimeException("Encountered unexpected event: " + event.toString());
      }
    }
  }
  
  public int getCurrentDepth()
  {
    return stack.size();
  }
  
  public boolean testExpression(String expression)
  {
    if (expression.equals(".")) {
      return true;
    }
    return stackString.endsWith(expression);
  }
  
  public boolean testExpression(String expression, int startingStackDepth)
  {
    if (expression.equals(".")) {
      return true;
    }
    int index = -1;
    while ((index = expression.indexOf("/", index + 1)) > -1) {
      if (expression.charAt(index + 1) != '@') {
        startingStackDepth++;
      }
    }
    return (startingStackDepth == getCurrentDepth()) && 
      (stackString.endsWith("/" + expression));
  }
  
  public boolean isStartOfDocument()
    throws XMLStreamException
  {
    return eventReader.peek().isStartDocument();
  }
  
  public XMLEvent nextEvent()
    throws XMLStreamException
  {
    if ((attributeIterator != null) && (attributeIterator.hasNext())) {
      currentEvent = ((XMLEvent)attributeIterator.next());
    } else {
      currentEvent = eventReader.nextEvent();
    }
    if (currentEvent.isStartElement()) {
      attributeIterator = currentEvent.asStartElement().getAttributes();
    }
    updateContext(currentEvent);
    XMLEvent nextEvent;
    if (eventReader.hasNext())
    {
      nextEvent = eventReader.peek();
      if ((nextEvent != null) && (nextEvent.isCharacters())) {
        for (MetadataExpression metadataExpression : metadataExpressions) {
          if (testExpression(expression, targetDepth)) {
            metadata.put(key, nextEvent.asCharacters().getData());
          }
        }
      }
    }
    return currentEvent;
  }
  
  public Map<String, String> getMetadata()
  {
    return metadata;
  }
  
  public void registerMetadataExpression(String expression, int targetDepth, String storageKey)
  {
    metadataExpressions.add(new MetadataExpression(expression, targetDepth, storageKey));
  }
  
  private static class MetadataExpression
  {
    public String expression;
    public int targetDepth;
    public String key;
    
    public MetadataExpression(String expression, int targetDepth, String key)
    {
      this.expression = expression;
      this.targetDepth = targetDepth;
      this.key = key;
    }
  }
  
  private void updateContext(XMLEvent event)
  {
    if (event == null) {
      return;
    }
    Iterator localIterator;
    String s;
    if (event.isEndElement())
    {
      stack.pop();
      stackString = "";
      for (localIterator = stack.iterator(); localIterator.hasNext();)
      {
        s = (String)localIterator.next();
        stackString = (stackString + "/" + s);
      }
    }
    else if (event.isStartElement())
    {
      stack.push(event.asStartElement().getName().getLocalPart());
      stackString = (stackString + "/" + event.asStartElement().getName().getLocalPart());
    }
    else if (event.isAttribute())
    {
      Attribute attribute = (Attribute)event;
      stackString = "";
      for (String s : stack) {
        stackString = (stackString + "/" + s);
      }
      stackString = (stackString + "/@" + attribute.getName().getLocalPart());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */