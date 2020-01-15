package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.File;

 enum Files$FilePredicate$2
{
  Files$FilePredicate$2()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean apply(File file)
  {
    return file.isFile();
  }
  
  public String toString()
  {
    return "Files.isFile()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.Files.FilePredicate.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */