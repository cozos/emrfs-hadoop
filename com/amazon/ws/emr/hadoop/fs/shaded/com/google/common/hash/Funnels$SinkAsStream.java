package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.OutputStream;

class Funnels$SinkAsStream
  extends OutputStream
{
  final PrimitiveSink sink;
  
  Funnels$SinkAsStream(PrimitiveSink sink)
  {
    this.sink = ((PrimitiveSink)Preconditions.checkNotNull(sink));
  }
  
  public void write(int b)
  {
    sink.putByte((byte)b);
  }
  
  public void write(byte[] bytes)
  {
    sink.putBytes(bytes);
  }
  
  public void write(byte[] bytes, int off, int len)
  {
    sink.putBytes(bytes, off, len);
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(sink));return 24 + str.length() + "Funnels.asOutputStream(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Funnels.SinkAsStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */