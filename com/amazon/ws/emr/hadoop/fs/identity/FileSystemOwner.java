package com.amazon.ws.emr.hadoop.fs.identity;

public abstract interface FileSystemOwner
{
  public abstract String getFullUserName();
  
  public abstract String getShortUserName();
  
  public abstract String getGroup();
  
  public abstract String[] getGroupNames();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.identity.FileSystemOwner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */