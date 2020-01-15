package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import org.w3c.dom.Document;

public class DOMDeserializer$DocumentDeserializer
  extends DOMDeserializer<Document>
{
  private static final long serialVersionUID = 1L;
  
  public DOMDeserializer$DocumentDeserializer()
  {
    super(Document.class);
  }
  
  public Document _deserialize(String value, DeserializationContext ctxt)
    throws IllegalArgumentException
  {
    return parse(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */