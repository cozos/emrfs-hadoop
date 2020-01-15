package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Progress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.EndEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.StatsEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Stats;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.NotThreadSafe;
import lombok.NonNull;
import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.classification.InterfaceStability.Unstable;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@InterfaceAudience.Private
@InterfaceStability.Unstable
@NotThreadSafe
public class InputStreamWithInfo
  extends InputStream
{
  public static final Logger LOG = LoggerFactory.getLogger(InputStreamWithInfo.class);
  private final InputStream in;
  private final long contentLength;
  private final String key;
  private final Optional<Configuration> selectOptions;
  private final AtomicBoolean isSelectResultComplete = new AtomicBoolean(false);
  private final AtomicLong selectByteScanned = new AtomicLong(0L);
  private final AtomicLong selectByteReturned = new AtomicLong(0L);
  private boolean wasClosedSuccessfully = false;
  
  public InputStreamWithInfo(@NonNull InputStream inputStream, @NonNull String key, long contentLength)
  {
    if (inputStream == null) {
      throw new NullPointerException("inputStream");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    in = inputStream;
    this.contentLength = contentLength;
    this.key = key;
    selectOptions = Optional.empty();
  }
  
  public InputStreamWithInfo(@NonNull SelectObjectContentEventStream eventStream, @NonNull final String key, @NonNull Configuration selectOptions, long contentLength)
  {
    if (eventStream == null) {
      throw new NullPointerException("eventStream");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    if (selectOptions == null) {
      throw new NullPointerException("selectOptions");
    }
    in = eventStream.getRecordsInputStream(new SelectObjectContentEventVisitor()
    {
      public void visit(SelectObjectContentEvent.EndEvent event)
      {
        InputStreamWithInfo.LOG.debug("Select object content of '{}' received EndEvent", key);
        isSelectResultComplete.set(true);
      }
      
      public void visit(SelectObjectContentEvent.ProgressEvent event)
      {
        selectByteScanned.set(event.getDetails().getBytesScanned().longValue());
        selectByteReturned.set(event.getDetails().getBytesReturned().longValue());
        InputStreamWithInfo.this.logSelectProcessDetails();
      }
      
      public void visit(SelectObjectContentEvent.StatsEvent event)
      {
        selectByteScanned.set(event.getDetails().getBytesScanned().longValue());
        selectByteReturned.set(event.getDetails().getBytesReturned().longValue());
        InputStreamWithInfo.this.logSelectProcessDetails();
      }
    });
    this.key = key;
    this.selectOptions = Optional.of(selectOptions);
    this.contentLength = contentLength;
  }
  
  public Optional<Configuration> getSelectOptions()
  {
    if (isSelect()) {
      return Optional.of(new Configuration((Configuration)selectOptions.get()));
    }
    return Optional.empty();
  }
  
  public boolean isSelect()
  {
    return selectOptions.isPresent();
  }
  
  boolean isSelectResultComplete()
  {
    return isSelectResultComplete.get();
  }
  
  public long getSelectByteScanned()
  {
    return selectByteScanned.get();
  }
  
  long getSelectByteReturned()
  {
    return selectByteReturned.get();
  }
  
  public boolean atEndOfStreamIfKnown(long pos)
  {
    if (!isSelect()) {
      return pos == getContentLength();
    }
    return (isSelectResultComplete()) && (pos == getSelectByteReturned());
  }
  
  public boolean shouldBreakReadRetry(long pos)
  {
    return (contentLength == -1L) || (atEndOfStreamIfKnown(pos));
  }
  
  private void logSelectProcessDetails()
  {
    LOG.debug("Select object content of '{}' scanned {} bytes, returned {} bytes", new Object[] { getKey(), 
      Long.valueOf(selectByteScanned.get()), Long.valueOf(selectByteReturned.get()) });
  }
  
  public long getContentLength()
  {
    return contentLength;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public boolean wasClosedSuccessfully()
  {
    return wasClosedSuccessfully;
  }
  
  public int read()
    throws IOException
  {
    return in.read();
  }
  
  public int read(byte[] bytes)
    throws IOException
  {
    return in.read(bytes);
  }
  
  public int read(byte[] bytes, int off, int len)
    throws IOException
  {
    return in.read(bytes, off, len);
  }
  
  public long skip(long num)
    throws IOException
  {
    return in.skip(num);
  }
  
  public int available()
    throws IOException
  {
    return in.available();
  }
  
  public void close()
    throws IOException
  {
    if (wasClosedSuccessfully) {
      return;
    }
    try
    {
      if ((in instanceof SdkFilterInputStream)) {
        ((SdkFilterInputStream)in).abort();
      } else {
        in.close();
      }
      wasClosedSuccessfully = true;
    }
    catch (Exception e)
    {
      LOG.warn("Exception closing input stream. ", e);
    }
  }
  
  public synchronized void mark(int readlimit)
  {
    in.mark(readlimit);
  }
  
  public synchronized void reset()
    throws IOException
  {
    in.reset();
  }
  
  public boolean markSupported()
  {
    return in.markSupported();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */