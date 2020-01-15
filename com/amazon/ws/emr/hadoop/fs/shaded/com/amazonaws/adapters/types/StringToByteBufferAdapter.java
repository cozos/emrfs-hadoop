package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.adapters.types;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.nio.ByteBuffer;

@SdkProtectedApi
public class StringToByteBufferAdapter
  implements TypeAdapter<String, ByteBuffer>
{
  public ByteBuffer adapt(String source)
  {
    if (source == null) {
      return null;
    }
    return ByteBuffer.wrap(source.getBytes(StringUtils.UTF8));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.adapters.types.StringToByteBufferAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */