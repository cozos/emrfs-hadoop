package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;

@JacksonStdImpl
public class TokenBufferDeserializer
  extends StdScalarDeserializer<TokenBuffer>
{
  private static final long serialVersionUID = 1L;
  
  public TokenBufferDeserializer()
  {
    super(TokenBuffer.class);
  }
  
  public TokenBuffer deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    return createBufferInstance(p).deserialize(p, ctxt);
  }
  
  protected TokenBuffer createBufferInstance(JsonParser p)
  {
    return new TokenBuffer(p);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */