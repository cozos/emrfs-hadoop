package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public abstract class ProgressInputStream
  extends SdkFilterInputStream
{
  private static final int DEFAULT_NOTIFICATION_THRESHOLD = 8192;
  private final ProgressListener listener;
  private final int notifyThresHold;
  private int unnotifiedByteCount;
  private boolean hasBeenRead;
  private boolean doneEOF;
  private long notifiedByteCount;
  
  @Deprecated
  public static InputStream inputStreamForRequest(InputStream is, AmazonWebServiceRequest req)
  {
    return req == null ? is : 
    
      inputStreamForRequest(is, req.getGeneralProgressListener());
  }
  
  @SdkInternalApi
  public static InputStream inputStreamForRequest(InputStream is, ProgressListener progressListener)
  {
    return progressListener == null ? is : new RequestProgressInputStream(is, progressListener);
  }
  
  public static InputStream inputStreamForResponse(InputStream is, AmazonWebServiceRequest req)
  {
    return req == null ? is : new ResponseProgressInputStream(is, req
    
      .getGeneralProgressListener());
  }
  
  public static InputStream inputStreamForResponse(InputStream is, ProgressListener progressListener)
  {
    return progressListener == null ? is : new ResponseProgressInputStream(is, progressListener);
  }
  
  public ProgressInputStream(InputStream is, ProgressListener listener)
  {
    this(is, listener, 8192);
  }
  
  public ProgressInputStream(InputStream is, ProgressListener listener, int notifyThresHold)
  {
    super(is);
    if ((is == null) || (listener == null)) {
      throw new IllegalArgumentException();
    }
    this.notifyThresHold = notifyThresHold;
    this.listener = listener;
  }
  
  protected void onFirstRead() {}
  
  protected void onEOF() {}
  
  protected void onClose()
  {
    eof();
  }
  
  protected void onReset() {}
  
  protected void onNotifyBytesRead() {}
  
  private void onBytesRead(int bytesRead)
  {
    unnotifiedByteCount += bytesRead;
    if (unnotifiedByteCount >= notifyThresHold)
    {
      onNotifyBytesRead();
      notifiedByteCount += unnotifiedByteCount;
      unnotifiedByteCount = 0;
    }
  }
  
  public int read()
    throws IOException
  {
    if (!hasBeenRead)
    {
      onFirstRead();
      hasBeenRead = true;
    }
    int ch = super.read();
    if (ch == -1) {
      eof();
    } else {
      onBytesRead(1);
    }
    return ch;
  }
  
  public void reset()
    throws IOException
  {
    super.reset();
    onReset();
    unnotifiedByteCount = 0;
    notifiedByteCount = 0L;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (!hasBeenRead)
    {
      onFirstRead();
      hasBeenRead = true;
    }
    int bytesRead = super.read(b, off, len);
    if (bytesRead == -1) {
      eof();
    } else {
      onBytesRead(bytesRead);
    }
    return bytesRead;
  }
  
  private void eof()
  {
    if (doneEOF) {
      return;
    }
    onEOF();
    unnotifiedByteCount = 0;
    doneEOF = true;
  }
  
  public final InputStream getWrappedInputStream()
  {
    return in;
  }
  
  protected final int getUnnotifiedByteCount()
  {
    return unnotifiedByteCount;
  }
  
  protected final long getNotifiedByteCount()
  {
    return notifiedByteCount;
  }
  
  public void close()
    throws IOException
  {
    onClose();
    super.close();
  }
  
  public final ProgressListener getListener()
  {
    return listener;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */