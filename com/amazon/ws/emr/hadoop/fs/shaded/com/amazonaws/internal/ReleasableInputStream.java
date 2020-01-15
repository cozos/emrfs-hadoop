package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.FileInputStream;
import java.io.InputStream;

@NotThreadSafe
public class ReleasableInputStream
  extends SdkFilterInputStream
  implements Releasable
{
  private static final Log log = LogFactory.getLog(ReleasableInputStream.class);
  private boolean closeDisabled;
  
  protected ReleasableInputStream(InputStream is)
  {
    super(is);
  }
  
  public final void close()
  {
    if (!closeDisabled) {
      doRelease();
    }
  }
  
  public final void release()
  {
    doRelease();
  }
  
  private void doRelease()
  {
    try
    {
      in.close();
    }
    catch (Exception ex)
    {
      if (log.isDebugEnabled()) {
        log.debug("FYI", ex);
      }
    }
    if ((in instanceof Releasable))
    {
      Releasable r = (Releasable)in;
      r.release();
    }
    abortIfNeeded();
  }
  
  public final boolean isCloseDisabled()
  {
    return closeDisabled;
  }
  
  public final <T extends ReleasableInputStream> T disableClose()
  {
    closeDisabled = true;
    
    T t = this;
    return t;
  }
  
  public static ReleasableInputStream wrap(InputStream is)
  {
    if ((is instanceof ReleasableInputStream)) {
      return (ReleasableInputStream)is;
    }
    if ((is instanceof FileInputStream)) {
      return ResettableInputStream.newResettableInputStream((FileInputStream)is);
    }
    return new ReleasableInputStream(is);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ReleasableInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */