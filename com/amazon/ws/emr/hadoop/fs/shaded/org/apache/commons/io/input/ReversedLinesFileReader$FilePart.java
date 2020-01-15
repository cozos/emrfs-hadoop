package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input;

import java.io.IOException;
import java.io.RandomAccessFile;

class ReversedLinesFileReader$FilePart
{
  private final long no;
  private final byte[] data;
  private byte[] leftOver;
  private int currentLastBytePos;
  
  private ReversedLinesFileReader$FilePart(ReversedLinesFileReader arg1, long no, int length, byte[] leftOverOfLastFilePart)
    throws IOException
  {
    this.no = no;
    int dataLength = length + (leftOverOfLastFilePart != null ? leftOverOfLastFilePart.length : 0);
    data = new byte[dataLength];
    long off = (no - 1L) * ReversedLinesFileReader.access$300(???);
    if (no > 0L)
    {
      ReversedLinesFileReader.access$400(???).seek(off);
      int countRead = ReversedLinesFileReader.access$400(???).read(data, 0, length);
      if (countRead != length) {
        throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
      }
    }
    if (leftOverOfLastFilePart != null) {
      System.arraycopy(leftOverOfLastFilePart, 0, data, length, leftOverOfLastFilePart.length);
    }
    currentLastBytePos = (data.length - 1);
    leftOver = null;
  }
  
  private FilePart rollOver()
    throws IOException
  {
    if (currentLastBytePos > -1) {
      throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + currentLastBytePos);
    }
    if (no > 1L) {
      return new FilePart(this$0, no - 1L, ReversedLinesFileReader.access$300(this$0), leftOver);
    }
    if (leftOver != null) {
      throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(leftOver, ReversedLinesFileReader.access$500(this$0)));
    }
    return null;
  }
  
  private String readLine()
    throws IOException
  {
    String line = null;
    
    boolean isLastFilePart = no == 1L;
    
    int i = currentLastBytePos;
    while (i > -1) {
      if ((!isLastFilePart) && (i < ReversedLinesFileReader.access$600(this$0)))
      {
        createLeftOver();
      }
      else
      {
        int newLineMatchByteCount;
        if ((newLineMatchByteCount = getNewLineMatchByteCount(data, i)) > 0)
        {
          int lineStart = i + 1;
          int lineLengthBytes = currentLastBytePos - lineStart + 1;
          if (lineLengthBytes < 0) {
            throw new IllegalStateException("Unexpected negative line length=" + lineLengthBytes);
          }
          byte[] lineData = new byte[lineLengthBytes];
          System.arraycopy(data, lineStart, lineData, 0, lineLengthBytes);
          
          line = new String(lineData, ReversedLinesFileReader.access$500(this$0));
          
          currentLastBytePos = (i - newLineMatchByteCount);
        }
        else
        {
          i -= ReversedLinesFileReader.access$700(this$0);
          if (i < 0) {
            createLeftOver();
          }
        }
      }
    }
    if ((isLastFilePart) && (leftOver != null))
    {
      line = new String(leftOver, ReversedLinesFileReader.access$500(this$0));
      leftOver = null;
    }
    return line;
  }
  
  private void createLeftOver()
  {
    int lineLengthBytes = currentLastBytePos + 1;
    if (lineLengthBytes > 0)
    {
      leftOver = new byte[lineLengthBytes];
      System.arraycopy(data, 0, leftOver, 0, lineLengthBytes);
    }
    else
    {
      leftOver = null;
    }
    currentLastBytePos = -1;
  }
  
  private int getNewLineMatchByteCount(byte[] data, int i)
  {
    for (byte[] newLineSequence : ReversedLinesFileReader.access$800(this$0))
    {
      boolean match = true;
      for (int j = newLineSequence.length - 1; j >= 0; j--)
      {
        int k = i + j - (newLineSequence.length - 1);
        match &= ((k >= 0) && (data[k] == newLineSequence[j]));
      }
      if (match) {
        return newLineSequence.length;
      }
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.input.ReversedLinesFileReader.FilePart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */