package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.ByteArrayOutputStream;

class FileBackedOutputStream$MemoryOutput
  extends ByteArrayOutputStream
{
  byte[] getBuffer()
  {
    return buf;
  }
  
  int getCount()
  {
    return count;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.FileBackedOutputStream.MemoryOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */