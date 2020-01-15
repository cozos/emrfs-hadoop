package com.amazon.ws.emr.hadoop.fs.notification;

import java.util.List;
import org.apache.hadoop.fs.Path;

public abstract interface Notifier
{
  public abstract void inconsistency(Api paramApi, Path paramPath1, Path paramPath2, List<Path> paramList);
  
  public static enum Api
  {
    Create,  Delete,  GetFileStatus,  ListStatus,  Mkdirs,  Open,  Rename;
    
    private Api() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.notification.Notifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */