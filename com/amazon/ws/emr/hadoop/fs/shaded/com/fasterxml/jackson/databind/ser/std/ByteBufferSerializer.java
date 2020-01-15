package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferSerializer
  extends StdScalarSerializer<ByteBuffer>
{
  public ByteBufferSerializer()
  {
    super(ByteBuffer.class);
  }
  
  public void serialize(ByteBuffer bbuf, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (bbuf.hasArray())
    {
      gen.writeBinary(bbuf.array(), 0, bbuf.limit());
      return;
    }
    ByteBuffer copy = bbuf.asReadOnlyBuffer();
    if (copy.position() > 0) {
      copy.rewind();
    }
    InputStream in = new ByteBufferBackedInputStream(copy);
    gen.writeBinary(in, copy.remaining());
    in.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */