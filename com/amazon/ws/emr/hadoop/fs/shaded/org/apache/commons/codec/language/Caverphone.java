package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.EncoderException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.StringEncoder;

@Deprecated
public class Caverphone
  implements StringEncoder
{
  private final Caverphone2 encoder = new Caverphone2();
  
  public String caverphone(String source)
  {
    return encoder.encode(source);
  }
  
  public Object encode(Object obj)
    throws EncoderException
  {
    if (!(obj instanceof String)) {
      throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
    return caverphone((String)obj);
  }
  
  public String encode(String str)
  {
    return caverphone(str);
  }
  
  public boolean isCaverphoneEqual(String str1, String str2)
  {
    return caverphone(str1).equals(caverphone(str2));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.language.Caverphone
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */