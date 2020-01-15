package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$CharacterDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Character>
{
  private static final long serialVersionUID = 1L;
  static final CharacterDeserializer primitiveInstance = new CharacterDeserializer(Character.TYPE, Character.valueOf('\000'));
  static final CharacterDeserializer wrapperInstance = new CharacterDeserializer(Character.class, null);
  
  public NumberDeserializers$CharacterDeserializer(Class<Character> cls, Character nvl)
  {
    super(cls, nvl);
  }
  
  public Character deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    switch (p.getCurrentTokenId())
    {
    case 7: 
      int value = p.getIntValue();
      if ((value >= 0) && (value <= 65535)) {
        return Character.valueOf((char)value);
      }
      break;
    case 6: 
      String text = p.getText();
      if (text.length() == 1) {
        return Character.valueOf(text.charAt(0));
      }
      if (text.length() == 0) {
        return (Character)getEmptyValue(ctxt);
      }
      break;
    case 3: 
      if (ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        p.nextToken();
        Character C = deserialize(p, ctxt);
        if (p.nextToken() != JsonToken.END_ARRAY) {
          throw ctxt.wrongTokenException(p, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _valueClass.getName() + "' value but there was more than a single value in the array");
        }
        return C;
      }
      break;
    }
    throw ctxt.mappingException(_valueClass, p.getCurrentToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.CharacterDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */