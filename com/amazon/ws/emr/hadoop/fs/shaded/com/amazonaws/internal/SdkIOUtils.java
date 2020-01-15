package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import java.io.Closeable;
import java.io.IOException;

 enum SdkIOUtils
{
  private static final InternalLogApi defaultLog = InternalLogFactory.getLog(SdkIOUtils.class);
  
  private SdkIOUtils() {}
  
  static void closeQuietly(Closeable is)
  {
    closeQuietly(is, null);
  }
  
  static void closeQuietly(Closeable is, InternalLogApi log)
  {
    if (is != null) {
      try
      {
        is.close();
      }
      catch (IOException ex)
      {
        InternalLogApi logger = log == null ? defaultLog : log;
        if (logger.isDebugEnabled()) {
          logger.debug("Ignore failure in closing the Closeable", ex);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkIOUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */