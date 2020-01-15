package com.amazon.ws.emr.hadoop.fs.consistency;

import java.io.IOException;

public class FileDirectoryMismatchException
  extends IOException
{
  public FileDirectoryMismatchException(String message)
  {
    super(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.FileDirectoryMismatchException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */