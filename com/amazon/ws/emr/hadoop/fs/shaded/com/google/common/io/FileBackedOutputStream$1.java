package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;
import java.io.InputStream;

class FileBackedOutputStream$1
  extends ByteSource
{
  FileBackedOutputStream$1(FileBackedOutputStream paramFileBackedOutputStream) {}
  
  public InputStream openStream()
    throws IOException
  {
    return FileBackedOutputStream.access$100(this$0);
  }
  
  protected void finalize()
  {
    try
    {
      this$0.reset();
    }
    catch (Throwable t)
    {
      t.printStackTrace(System.err);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.FileBackedOutputStream.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */