package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.CharMatcher;
import java.io.IOException;

class BaseEncoding$StandardBaseEncoding$2
  implements GwtWorkarounds.ByteInput
{
  int bitBuffer = 0;
  int bitBufferLength = 0;
  int readChars = 0;
  boolean hitPadding = false;
  final CharMatcher paddingMatcher = this$0.padding();
  
  BaseEncoding$StandardBaseEncoding$2(BaseEncoding.StandardBaseEncoding paramStandardBaseEncoding, GwtWorkarounds.CharInput paramCharInput) {}
  
  public int read()
    throws IOException
  {
    for (;;)
    {
      int readChar = val$reader.read();
      if (readChar == -1)
      {
        if ((!hitPadding) && (!BaseEncoding.StandardBaseEncoding.access$000(this$0).isValidPaddingStartPosition(readChars)))
        {
          int i = readChars;throw new BaseEncoding.DecodingException(32 + "Invalid input length " + i);
        }
        return -1;
      }
      readChars += 1;
      char ch = (char)readChar;
      int j;
      if (paddingMatcher.matches(ch))
      {
        if ((!hitPadding) && ((readChars == 1) || (!BaseEncoding.StandardBaseEncoding.access$000(this$0).isValidPaddingStartPosition(readChars - 1))))
        {
          j = readChars;throw new BaseEncoding.DecodingException(41 + "Padding cannot start at index " + j);
        }
        hitPadding = true;
      }
      else
      {
        if (hitPadding)
        {
          j = ch;int k = readChars;throw new BaseEncoding.DecodingException(61 + "Expected padding character but found '" + j + "' at index " + k);
        }
        bitBuffer <<= access$000this$0).bitsPerChar;
        bitBuffer |= BaseEncoding.StandardBaseEncoding.access$000(this$0).decode(ch);
        bitBufferLength += access$000this$0).bitsPerChar;
        if (bitBufferLength >= 8)
        {
          bitBufferLength -= 8;
          return bitBuffer >> bitBufferLength & 0xFF;
        }
      }
    }
  }
  
  public void close()
    throws IOException
  {
    val$reader.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.BaseEncoding.StandardBaseEncoding.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */