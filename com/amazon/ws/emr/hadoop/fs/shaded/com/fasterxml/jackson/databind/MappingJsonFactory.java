package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.InputAccessor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.format.MatchStrength;
import java.io.IOException;

public class MappingJsonFactory
  extends JsonFactory
{
  private static final long serialVersionUID = -6744103724013275513L;
  
  public MappingJsonFactory()
  {
    this(null);
  }
  
  public MappingJsonFactory(ObjectMapper mapper)
  {
    super(mapper);
    if (mapper == null) {
      setCodec(new ObjectMapper(this));
    }
  }
  
  public MappingJsonFactory(JsonFactory src, ObjectMapper mapper)
  {
    super(src, mapper);
    if (mapper == null) {
      setCodec(new ObjectMapper(this));
    }
  }
  
  public final ObjectMapper getCodec()
  {
    return (ObjectMapper)_objectCodec;
  }
  
  public JsonFactory copy()
  {
    _checkInvalidCopy(MappingJsonFactory.class);
    
    return new MappingJsonFactory(this, null);
  }
  
  public String getFormatName()
  {
    return "JSON";
  }
  
  public MatchStrength hasFormat(InputAccessor acc)
    throws IOException
  {
    if (getClass() == MappingJsonFactory.class) {
      return hasJSONFormat(acc);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MappingJsonFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */