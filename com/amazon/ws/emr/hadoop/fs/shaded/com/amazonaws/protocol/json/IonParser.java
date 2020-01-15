package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import software.amazon.ion.IonReader;
import software.amazon.ion.IonType;
import software.amazon.ion.Timestamp;

final class IonParser
  extends JsonParser
{
  private final IonReader reader;
  private final boolean shouldCloseReader;
  
  private static enum State
  {
    BEFORE_VALUE,  END_OF_CONTAINER,  EOF,  FIELD_NAME,  VALUE;
    
    private State() {}
  }
  
  private State state = State.BEFORE_VALUE;
  private JsonToken currentToken;
  private JsonToken lastClearedToken;
  private boolean shouldSkipContainer;
  private boolean closed;
  
  public IonParser(IonReader reader, boolean shouldCloseReader)
  {
    super(JsonParser.Feature.collectDefaults());
    this.reader = reader;
    this.shouldCloseReader = shouldCloseReader;
  }
  
  public ObjectCodec getCodec()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setCodec(ObjectCodec c)
  {
    throw new UnsupportedOperationException();
  }
  
  public Version version()
  {
    throw new UnsupportedOperationException();
  }
  
  public void close()
    throws IOException
  {
    if (shouldCloseReader) {
      reader.close();
    } else if (JsonParser.Feature.AUTO_CLOSE_SOURCE.enabledIn(_features)) {
      reader.close();
    }
    closed = true;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    currentToken = doNextToken();
    return currentToken;
  }
  
  private JsonToken doNextToken()
  {
    for (;;)
    {
      switch (state)
      {
      case BEFORE_VALUE: 
        IonType currentType = reader.next();
        if (currentType == null)
        {
          boolean topLevel = reader.getDepth() == 0;
          if (topLevel)
          {
            state = State.EOF;
          }
          else
          {
            state = State.END_OF_CONTAINER;
            return reader.isInStruct() ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
          }
        }
        else
        {
          if (reader.isInStruct())
          {
            state = State.FIELD_NAME;
            return JsonToken.FIELD_NAME;
          }
          state = State.VALUE;
          return getJsonToken();
        }
        break;
      case END_OF_CONTAINER: 
        reader.stepOut();
        state = State.BEFORE_VALUE;
        break;
      case EOF: 
        return null;
      case FIELD_NAME: 
        state = State.VALUE;
        return getJsonToken();
      case VALUE: 
        state = State.BEFORE_VALUE;
        if ((IonType.isContainer(reader.getType())) && (!reader.isNullValue()) && (!shouldSkipContainer)) {
          reader.stepIn();
        }
        shouldSkipContainer = false;
      }
    }
  }
  
  public JsonToken nextValue()
    throws IOException, JsonParseException
  {
    JsonToken token = nextToken();
    return token == JsonToken.FIELD_NAME ? 
      nextToken() : token;
  }
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    IonType currentType = reader.getType();
    if (IonType.isContainer(currentType))
    {
      shouldSkipContainer = true;
      currentToken = (currentType == IonType.STRUCT ? JsonToken.END_OBJECT : JsonToken.END_ARRAY);
    }
    return this;
  }
  
  public boolean isClosed()
  {
    return closed;
  }
  
  public JsonToken getCurrentToken()
  {
    return currentToken;
  }
  
  public int getCurrentTokenId()
  {
    return currentToken == null ? 0 : currentToken
    
      .id();
  }
  
  public boolean hasCurrentToken()
  {
    return currentToken != null;
  }
  
  public boolean hasTokenId(int id)
  {
    return getCurrentTokenId() == id;
  }
  
  public boolean hasToken(JsonToken t)
  {
    return currentToken == t;
  }
  
  public String getCurrentName()
    throws IOException
  {
    return reader.getFieldName();
  }
  
  public JsonStreamContext getParsingContext()
  {
    throw new UnsupportedOperationException();
  }
  
  public JsonLocation getTokenLocation()
  {
    throw new UnsupportedOperationException();
  }
  
  public JsonLocation getCurrentLocation()
  {
    throw new UnsupportedOperationException();
  }
  
  public void clearCurrentToken()
  {
    lastClearedToken = currentToken;
    currentToken = null;
  }
  
  public JsonToken getLastClearedToken()
  {
    return lastClearedToken;
  }
  
  public void overrideCurrentName(String name)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getText()
    throws IOException
  {
    if (state == State.FIELD_NAME) {
      return reader.getFieldName();
    }
    if (IonType.isText(reader.getType())) {
      return reader.stringValue();
    }
    if (currentToken == null) {
      return null;
    }
    if (currentToken.isNumeric()) {
      return getNumberValue().toString();
    }
    return currentToken.asString();
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public int getTextLength()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public int getTextOffset()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public Number getNumberValue()
    throws IOException
  {
    JsonParser.NumberType numberType = getNumberType();
    if (numberType == null) {
      throw new SdkClientException(String.format("Unable to get number value for non-numeric token %s", new Object[] { reader.getType() }));
    }
    switch (numberType)
    {
    case BIG_DECIMAL: 
      return reader.bigDecimalValue();
    case BIG_INTEGER: 
      return reader.bigIntegerValue();
    case DOUBLE: 
      return Double.valueOf(reader.doubleValue());
    }
    throw new SdkClientException(String.format("Unable to get number value for number type %s", new Object[] { numberType }));
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    switch (reader.getType())
    {
    case DECIMAL: 
      return JsonParser.NumberType.BIG_DECIMAL;
    case FLOAT: 
      return JsonParser.NumberType.DOUBLE;
    case INT: 
      return JsonParser.NumberType.BIG_INTEGER;
    }
    return null;
  }
  
  public int getIntValue()
    throws IOException
  {
    return reader.intValue();
  }
  
  public long getLongValue()
    throws IOException
  {
    return reader.longValue();
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    return reader.bigIntegerValue();
  }
  
  public float getFloatValue()
    throws IOException
  {
    return (float)reader.doubleValue();
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return reader.doubleValue();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    return reader.decimalValue();
  }
  
  public Object getEmbeddedObject()
    throws IOException
  {
    if (currentToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
      return null;
    }
    IonType currentType = reader.getType();
    switch (currentType)
    {
    case BLOB: 
    case CLOB: 
      return ByteBuffer.wrap(reader.newBytes());
    case TIMESTAMP: 
      return reader.timestampValue().dateValue();
    }
    throw new SdkClientException(String.format("Cannot return embedded object for Ion type %s", new Object[] { currentType }));
  }
  
  public byte[] getBinaryValue(Base64Variant bv)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public String getValueAsString(String defaultValue)
    throws IOException
  {
    if ((currentToken != JsonToken.VALUE_STRING) && (
      (currentToken == null) || (currentToken == JsonToken.VALUE_NULL) || (!currentToken.isScalarValue()))) {
      return defaultValue;
    }
    return getText();
  }
  
  private JsonToken getJsonToken()
  {
    if (reader.isNullValue()) {
      return JsonToken.VALUE_NULL;
    }
    IonType currentType = reader.getType();
    switch (currentType)
    {
    case BLOB: 
    case CLOB: 
      return JsonToken.VALUE_EMBEDDED_OBJECT;
    case BOOL: 
      return reader.booleanValue() ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
    case DECIMAL: 
      return JsonToken.VALUE_NUMBER_FLOAT;
    case FLOAT: 
      return JsonToken.VALUE_NUMBER_FLOAT;
    case INT: 
      return JsonToken.VALUE_NUMBER_INT;
    case LIST: 
      return JsonToken.START_ARRAY;
    case SEXP: 
      return JsonToken.START_ARRAY;
    case STRING: 
      return JsonToken.VALUE_STRING;
    case STRUCT: 
      return JsonToken.START_OBJECT;
    case SYMBOL: 
      return JsonToken.VALUE_STRING;
    case TIMESTAMP: 
      return JsonToken.VALUE_EMBEDDED_OBJECT;
    }
    throw new SdkClientException(String.format("Unhandled Ion type %s", new Object[] { currentType }));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.IonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */