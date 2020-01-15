package com.amazon.ws.emr.hadoop.fs;

import java.io.IOException;
import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.hadoop.classification.InterfaceStability.Stable;

@InterfaceAudience.Public
@InterfaceStability.Stable
public class EmrFileSystemException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public EmrFileSystemException() {}
  
  public EmrFileSystemException(String message)
  {
    super(message);
  }
  
  public EmrFileSystemException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public EmrFileSystemException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.EmrFileSystemException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */