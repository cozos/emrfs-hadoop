package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class Files$FileByteSource
  extends ByteSource
{
  private final File file;
  
  private Files$FileByteSource(File file)
  {
    this.file = ((File)Preconditions.checkNotNull(file));
  }
  
  public FileInputStream openStream()
    throws IOException
  {
    return new FileInputStream(file);
  }
  
  public long size()
    throws IOException
  {
    if (!file.isFile()) {
      throw new FileNotFoundException(file.toString());
    }
    return file.length();
  }
  
  public byte[] read()
    throws IOException
  {
    Closer closer = Closer.create();
    try
    {
      FileInputStream in = (FileInputStream)closer.register(openStream());
      return Files.readFile(in, in.getChannel().size());
    }
    catch (Throwable e)
    {
      throw closer.rethrow(e);
    }
    finally
    {
      closer.close();
    }
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(file));return 20 + str.length() + "Files.asByteSource(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Files.FileByteSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */