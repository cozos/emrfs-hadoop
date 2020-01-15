package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class Files$FileByteSink
  extends ByteSink
{
  private final File file;
  private final ImmutableSet<FileWriteMode> modes;
  
  private Files$FileByteSink(File file, FileWriteMode... modes)
  {
    this.file = ((File)Preconditions.checkNotNull(file));
    this.modes = ImmutableSet.copyOf(modes);
  }
  
  public FileOutputStream openStream()
    throws IOException
  {
    return new FileOutputStream(file, modes.contains(FileWriteMode.APPEND));
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(file));String str2 = String.valueOf(String.valueOf(modes));return 20 + str1.length() + str2.length() + "Files.asByteSink(" + str1 + ", " + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Files.FileByteSink
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */