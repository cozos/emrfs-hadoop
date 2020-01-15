package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import org.w3c.dom.Node;

public class DOMDeserializer$NodeDeserializer
  extends DOMDeserializer<Node>
{
  private static final long serialVersionUID = 1L;
  
  public DOMDeserializer$NodeDeserializer()
  {
    super(Node.class);
  }
  
  public Node _deserialize(String value, DeserializationContext ctxt)
    throws IllegalArgumentException
  {
    return parse(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ext.DOMDeserializer.NodeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */