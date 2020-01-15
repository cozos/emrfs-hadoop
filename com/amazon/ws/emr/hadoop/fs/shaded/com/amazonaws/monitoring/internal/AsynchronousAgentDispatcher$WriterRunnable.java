package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.BlockingQueue;

class AsynchronousAgentDispatcher$WriterRunnable
  implements Runnable
{
  private AsynchronousAgentDispatcher$WriterRunnable(AsynchronousAgentDispatcher paramAsynchronousAgentDispatcher) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        AsynchronousAgentDispatcher.WriteTask wt = (AsynchronousAgentDispatcher.WriteTask)AsynchronousAgentDispatcher.access$100(this$0).take();
        byte[] eventBytes = AsynchronousAgentDispatcher.access$300(this$0, AsynchronousAgentDispatcher.WriteTask.access$200(wt));
        if (eventBytes.length > AsynchronousAgentDispatcher.WriteTask.access$400(wt))
        {
          if (AsynchronousAgentDispatcher.access$500().isDebugEnabled()) {
            AsynchronousAgentDispatcher.access$500().debug("Event exceeds the send maximum event size of " + AsynchronousAgentDispatcher.WriteTask.access$400(wt) + ". Dropping event.");
          }
        }
        else {
          AsynchronousAgentDispatcher.WriteTask.access$600(wt).write(ByteBuffer.wrap(eventBytes));
        }
      }
    }
    catch (InterruptedException ie)
    {
      Thread.currentThread().interrupt();
      AsynchronousAgentDispatcher.access$500().debug("Writer thread interrupted", ie);
    }
    catch (Exception e)
    {
      AsynchronousAgentDispatcher.access$500().debug("Exception thrown while attempting to send event to agent", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.AsynchronousAgentDispatcher.WriterRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */