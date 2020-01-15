package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.EncoderException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.StringEncoder;

public abstract class AbstractCaverphone
  implements StringEncoder
{
  public Object encode(Object source)
    throws EncoderException
  {
    if (!(source instanceof String)) {
      throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
    return encode((String)source);
  }
  
  public boolean isEncodeEqual(String str1, String str2)
    throws EncoderException
  {
    return encode(str1).equals(encode(str2));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.AbstractCaverphone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */