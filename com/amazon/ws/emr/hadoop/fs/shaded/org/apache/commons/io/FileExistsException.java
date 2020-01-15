package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class FileExistsException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public FileExistsException() {}
  
  public FileExistsException(String message)
  {
    super(message);
  }
  
  public FileExistsException(File file)
  {
    super("File " + file + " exists");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileExistsException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */