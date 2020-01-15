package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public abstract class DOMDeserializer<T>
  extends FromStringDeserializer<T>
{
  private static final long serialVersionUID = 1L;
  private static final DocumentBuilderFactory _parserFactory = ;
  
  static
  {
    _parserFactory.setNamespaceAware(true);
  }
  
  protected DOMDeserializer(Class<T> cls)
  {
    super(cls);
  }
  
  protected final Document parse(String value)
    throws IllegalArgumentException
  {
    try
    {
      return _parserFactory.newDocumentBuilder().parse(new InputSource(new StringReader(value)));
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException("Failed to parse JSON String as XML: " + e.getMessage(), e);
    }
  }
  
  public abstract T _deserialize(String paramString, DeserializationContext paramDeserializationContext);
  
  public static class NodeDeserializer
    extends DOMDeserializer<Node>
  {
    private static final long serialVersionUID = 1L;
    
    public NodeDeserializer()
    {
      super();
    }
    
    public Node _deserialize(String value, DeserializationContext ctxt)
      throws IllegalArgumentException
    {
      return parse(value);
    }
  }
  
  public static class DocumentDeserializer
    extends DOMDeserializer<Document>
  {
    private static final long serialVersionUID = 1L;
    
    public DocumentDeserializer()
    {
      super();
    }
    
    public Document _deserialize(String value, DeserializationContext ctxt)
      throws IllegalArgumentException
    {
      return parse(value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */