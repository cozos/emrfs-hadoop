package com.amazon.ws.emr.hadoop.fs.consistency.exception;

import com.amazon.ws.emr.hadoop.fs.EmrFileSystemException;
import java.util.List;
import org.apache.hadoop.fs.Path;

public class ConsistencyException
  extends EmrFileSystemException
{
  private List<Path> inconsistentPaths;
  
  public ConsistencyException(List<Path> inconsistentPaths)
  {
    this.inconsistentPaths = inconsistentPaths;
  }
  
  public ConsistencyException(String message, List<Path> inconsistentPaths)
  {
    super(message);
    this.inconsistentPaths = inconsistentPaths;
  }
  
  public ConsistencyException(String message, Throwable cause, List<Path> inconsistentPaths)
  {
    super(message, cause);
    this.inconsistentPaths = inconsistentPaths;
  }
  
  public ConsistencyException(Throwable cause, List<Path> inconsistentPaths)
  {
    super(cause);
    this.inconsistentPaths = inconsistentPaths;
  }
  
  public List<Path> getPaths()
  {
    return inconsistentPaths;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.exception.ConsistencyException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */