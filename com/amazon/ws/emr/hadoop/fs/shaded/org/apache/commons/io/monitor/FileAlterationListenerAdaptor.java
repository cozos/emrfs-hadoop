package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.monitor;

import java.io.File;

public class FileAlterationListenerAdaptor
  implements FileAlterationListener
{
  public void onStart(FileAlterationObserver observer) {}
  
  public void onDirectoryCreate(File directory) {}
  
  public void onDirectoryChange(File directory) {}
  
  public void onDirectoryDelete(File directory) {}
  
  public void onFileCreate(File file) {}
  
  public void onFileChange(File file) {}
  
  public void onFileDelete(File file) {}
  
  public void onStop(FileAlterationObserver observer) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.monitor.FileAlterationListenerAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */