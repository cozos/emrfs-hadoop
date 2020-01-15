package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary;

import java.util.Arrays;

class BaseNCodec$Context
{
  int ibitWorkArea;
  long lbitWorkArea;
  byte[] buffer;
  int pos;
  int readPos;
  boolean eof;
  int currentLinePos;
  int modulus;
  
  public String toString()
  {
    return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[] { getClass().getSimpleName(), Arrays.toString(buffer), Integer.valueOf(currentLinePos), Boolean.valueOf(eof), Integer.valueOf(ibitWorkArea), Long.valueOf(lbitWorkArea), Integer.valueOf(modulus), Integer.valueOf(pos), Integer.valueOf(readPos) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.BaseNCodec.Context
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */