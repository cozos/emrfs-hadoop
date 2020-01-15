package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.IOException;
import java.io.InputStream;

class FileBackedOutputStream$2
  extends ByteSource
{
  FileBackedOutputStream$2(FileBackedOutputStream paramFileBackedOutputStream) {}
  
  public InputStream openStream()
    throws IOException
  {
    return FileBackedOutputStream.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.FileBackedOutputStream.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */