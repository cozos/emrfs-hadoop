package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

public class NullifyingDeserializer
  extends StdDeserializer<Object>
{
  private static final long serialVersionUID = 1L;
  public static final NullifyingDeserializer instance = new NullifyingDeserializer();
  
  public NullifyingDeserializer()
  {
    super(Object.class);
  }
  
  public Object deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.hasToken(JsonToken.FIELD_NAME)) {
      for (;;)
      {
        JsonToken t = p.nextToken();
        if ((t == null) || (t == JsonToken.END_OBJECT)) {
          break;
        }
        p.skipChildren();
      }
    }
    p.skipChildren();
    
    return null;
  }
  
  public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    switch (p.getCurrentTokenId())
    {
    case 1: 
    case 3: 
    case 5: 
      return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */