package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

@SdkInternalApi
public class AsynchronousAgentDispatcher
{
  private static final Log LOG = LogFactory.getLog(AsynchronousAgentDispatcher.class);
  private static final int QUEUE_SIZE = 4096;
  private static AsynchronousAgentDispatcher instance;
  private final ObjectWriter writer;
  private int refCount = 0;
  private volatile BlockingQueue<WriteTask> tasks;
  private ExecutorService exec;
  private volatile boolean initialized = false;
  
  private AsynchronousAgentDispatcher()
  {
    writer = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).setPropertyNamingStrategy(new PropertyNamingStrategy.PascalCaseStrategy()).writer();
  }
  
  @SdkTestInternalApi
  AsynchronousAgentDispatcher(ObjectWriter writer)
  {
    this.writer = writer;
  }
  
  public void addWriteTask(MonitoringEvent event, DatagramChannel channel, int maxSize)
  {
    if (!initialized) {
      throw new IllegalStateException("Dispatcher is not initialized!");
    }
    tasks.add(new WriteTask(event, channel, maxSize));
  }
  
  public synchronized void init()
  {
    if (!initialized)
    {
      tasks = new LinkedBlockingQueue(4096);
      exec = Executors.newSingleThreadExecutor();
      exec.submit(new WriterRunnable(null));
      initialized = true;
    }
    refCount += 1;
  }
  
  public synchronized void release()
  {
    if (refCount > 0) {
      refCount -= 1;
    }
    if ((refCount == 0) && (initialized))
    {
      exec.shutdown();
      tasks.clear();
      exec = null;
      tasks = null;
      initialized = false;
    }
  }
  
  public static synchronized AsynchronousAgentDispatcher getInstance()
  {
    if (instance == null) {
      instance = new AsynchronousAgentDispatcher();
    }
    return instance;
  }
  
  private byte[] serialize(MonitoringEvent event)
    throws IOException
  {
    return writer.writeValueAsBytes(event);
  }
  
  private class WriterRunnable
    implements Runnable
  {
    private WriterRunnable() {}
    
    public void run()
    {
      try
      {
        for (;;)
        {
          AsynchronousAgentDispatcher.WriteTask wt = (AsynchronousAgentDispatcher.WriteTask)tasks.take();
          byte[] eventBytes = AsynchronousAgentDispatcher.this.serialize(event);
          if (eventBytes.length > maxSize)
          {
            if (AsynchronousAgentDispatcher.LOG.isDebugEnabled()) {
              AsynchronousAgentDispatcher.LOG.debug("Event exceeds the send maximum event size of " + maxSize + ". Dropping event.");
            }
          }
          else {
            channel.write(ByteBuffer.wrap(eventBytes));
          }
        }
      }
      catch (InterruptedException ie)
      {
        Thread.currentThread().interrupt();
        AsynchronousAgentDispatcher.LOG.debug("Writer thread interrupted", ie);
      }
      catch (Exception e)
      {
        AsynchronousAgentDispatcher.LOG.debug("Exception thrown while attempting to send event to agent", e);
      }
    }
  }
  
  private static class WriteTask
  {
    private final MonitoringEvent event;
    private final DatagramChannel channel;
    private final int maxSize;
    
    public WriteTask(MonitoringEvent event, DatagramChannel channel, int maxSize)
    {
      this.event = event;
      this.channel = channel;
      this.maxSize = maxSize;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.AsynchronousAgentDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */