package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;

final class JsonNodeDeserializer$ArrayDeserializer
  extends BaseNodeDeserializer<ArrayNode>
{
  private static final long serialVersionUID = 1L;
  protected static final ArrayDeserializer _instance = new ArrayDeserializer();
  
  protected JsonNodeDeserializer$ArrayDeserializer()
  {
    super(ArrayNode.class);
  }
  
  public static ArrayDeserializer getInstance()
  {
    return _instance;
  }
  
  public ArrayNode deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.isExpectedStartArrayToken()) {
      return deserializeArray(p, ctxt, ctxt.getNodeFactory());
    }
    throw ctxt.mappingException(ArrayNode.class);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer.ArrayDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */