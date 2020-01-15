package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.adapters.types;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

@SdkProtectedApi
public class StringToInputStreamAdapter
  implements TypeAdapter<String, InputStream>
{
  public InputStream adapt(String source)
  {
    if (source == null) {
      return null;
    }
    try
    {
      return new StringInputStream(source);
    }
    catch (UnsupportedEncodingException e)
    {
      throw new SdkClientException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.adapters.types.StringToInputStreamAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */