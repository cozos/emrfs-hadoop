package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

final class JsonNodeDeserializer$ObjectDeserializer
  extends BaseNodeDeserializer<ObjectNode>
{
  private static final long serialVersionUID = 1L;
  protected static final ObjectDeserializer _instance = new ObjectDeserializer();
  
  protected JsonNodeDeserializer$ObjectDeserializer()
  {
    super(ObjectNode.class);
  }
  
  public static ObjectDeserializer getInstance()
  {
    return _instance;
  }
  
  public ObjectNode deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if ((p.isExpectedStartObjectToken()) || (p.hasToken(JsonToken.FIELD_NAME))) {
      return deserializeObject(p, ctxt, ctxt.getNodeFactory());
    }
    if (p.hasToken(JsonToken.END_OBJECT)) {
      return ctxt.getNodeFactory().objectNode();
    }
    throw ctxt.mappingException(ObjectNode.class);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer.ObjectDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */