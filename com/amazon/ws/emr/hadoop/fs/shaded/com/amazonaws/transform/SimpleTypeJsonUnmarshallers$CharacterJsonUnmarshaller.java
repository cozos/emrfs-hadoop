package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class SimpleTypeJsonUnmarshallers$CharacterJsonUnmarshaller
  implements Unmarshaller<Character, JsonUnmarshallerContext>
{
  public Character unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String charString = unmarshallerContext.readText();
    if (charString == null) {
      return null;
    }
    charString = charString.trim();
    if ((charString.isEmpty()) || (charString.length() > 1)) {
      throw new SdkClientException("'" + charString + "' cannot be converted to Character");
    }
    return Character.valueOf(charString.charAt(0));
  }
  
  private static final CharacterJsonUnmarshaller instance = new CharacterJsonUnmarshaller();
  
  public static CharacterJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.CharacterJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */