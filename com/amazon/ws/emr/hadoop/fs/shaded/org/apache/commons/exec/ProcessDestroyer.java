package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

public abstract interface ProcessDestroyer
{
  public abstract boolean add(Process paramProcess);
  
  public abstract boolean remove(Process paramProcess);
  
  public abstract int size();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.ProcessDestroyer
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */