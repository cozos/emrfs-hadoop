package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class MessageDecoder
{
  private ByteBuffer buf;
  
  public MessageDecoder()
  {
    buf = ByteBuffer.allocate(131072);
  }
  
  public boolean hasPendingContent()
  {
    return buf.position() != 0;
  }
  
  public List<Message> feed(byte[] bytes)
  {
    return feed(bytes, 0, bytes.length);
  }
  
  public List<Message> feed(byte[] bytes, int offset, int length)
  {
    buf.put(bytes, offset, length);
    ByteBuffer readView = (ByteBuffer)buf.duplicate().flip();
    int bytesConsumed = 0;
    
    List<Message> result = new ArrayList();
    while (readView.remaining() >= 15)
    {
      int totalMessageLength = Utils.toIntExact(Prelude.decode(readView.duplicate()).getTotalLength());
      if (readView.remaining() < totalMessageLength) {
        break;
      }
      Message decoded = Message.decode(readView);
      result.add(decoded);
      bytesConsumed += totalMessageLength;
    }
    if (bytesConsumed > 0)
    {
      buf.flip();
      buf.position(buf.position() + bytesConsumed);
      buf.compact();
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.MessageDecoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */