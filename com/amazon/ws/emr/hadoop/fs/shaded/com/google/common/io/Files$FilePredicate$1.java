package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.File;

 enum Files$FilePredicate$1
{
  Files$FilePredicate$1()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean apply(File file)
  {
    return file.isDirectory();
  }
  
  public String toString()
  {
    return "Files.isDirectory()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Files.FilePredicate.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */