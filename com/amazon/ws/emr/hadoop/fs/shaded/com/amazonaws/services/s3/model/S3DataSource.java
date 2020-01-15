package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.io.File;
import java.io.InputStream;

public abstract interface S3DataSource
{
  public abstract File getFile();
  
  public abstract void setFile(File paramFile);
  
  public abstract InputStream getInputStream();
  
  public abstract void setInputStream(InputStream paramInputStream);
  
  public static enum Utils
  {
    private Utils() {}
    
    public static void cleanupDataSource(S3DataSource req, File fileOrig, InputStream inputStreamOrig, InputStream inputStreamCurr, Log log)
    {
      if (fileOrig != null) {
        IOUtils.release(inputStreamCurr, log);
      }
      req.setInputStream(inputStreamOrig);
      req.setFile(fileOrig);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3DataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */