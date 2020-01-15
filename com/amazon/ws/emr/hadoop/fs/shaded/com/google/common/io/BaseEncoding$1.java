package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;
import java.io.OutputStream;

class BaseEncoding$1
  extends ByteSink
{
  BaseEncoding$1(BaseEncoding paramBaseEncoding, CharSink paramCharSink) {}
  
  public OutputStream openStream()
    throws IOException
  {
    return this$0.encodingStream(val$encodedSink.openStream());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */