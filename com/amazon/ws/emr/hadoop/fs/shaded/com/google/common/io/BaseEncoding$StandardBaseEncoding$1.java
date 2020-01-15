package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;

class BaseEncoding$StandardBaseEncoding$1
  implements GwtWorkarounds.ByteOutput
{
  int bitBuffer = 0;
  int bitBufferLength = 0;
  int writtenChars = 0;
  
  BaseEncoding$StandardBaseEncoding$1(BaseEncoding.StandardBaseEncoding paramStandardBaseEncoding, GwtWorkarounds.CharOutput paramCharOutput) {}
  
  public void write(byte b)
    throws IOException
  {
    bitBuffer <<= 8;
    bitBuffer |= b & 0xFF;
    bitBufferLength += 8;
    while (bitBufferLength >= access$000this$0).bitsPerChar)
    {
      int charIndex = bitBuffer >> bitBufferLength - access$000this$0).bitsPerChar & access$000this$0).mask;
      
      val$out.write(BaseEncoding.StandardBaseEncoding.access$000(this$0).encode(charIndex));
      writtenChars += 1;
      bitBufferLength -= access$000this$0).bitsPerChar;
    }
  }
  
  public void flush()
    throws IOException
  {
    val$out.flush();
  }
  
  public void close()
    throws IOException
  {
    if (bitBufferLength > 0)
    {
      int charIndex = bitBuffer << access$000this$0).bitsPerChar - bitBufferLength & access$000this$0).mask;
      
      val$out.write(BaseEncoding.StandardBaseEncoding.access$000(this$0).encode(charIndex));
      writtenChars += 1;
      if (BaseEncoding.StandardBaseEncoding.access$100(this$0) != null) {
        while (writtenChars % access$000this$0).charsPerChunk != 0)
        {
          val$out.write(BaseEncoding.StandardBaseEncoding.access$100(this$0).charValue());
          writtenChars += 1;
        }
      }
    }
    val$out.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.StandardBaseEncoding.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */