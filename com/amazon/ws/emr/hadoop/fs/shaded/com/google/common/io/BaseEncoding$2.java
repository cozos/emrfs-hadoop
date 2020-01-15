package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;
import java.io.InputStream;

class BaseEncoding$2
  extends ByteSource
{
  BaseEncoding$2(BaseEncoding paramBaseEncoding, CharSource paramCharSource) {}
  
  public InputStream openStream()
    throws IOException
  {
    return this$0.decodingStream(val$encodedSource.openStream());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */