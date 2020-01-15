package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringEvent;
import java.nio.channels.DatagramChannel;

class AsynchronousAgentDispatcher$WriteTask
{
  private final MonitoringEvent event;
  private final DatagramChannel channel;
  private final int maxSize;
  
  public AsynchronousAgentDispatcher$WriteTask(MonitoringEvent event, DatagramChannel channel, int maxSize)
  {
    this.event = event;
    this.channel = channel;
    this.maxSize = maxSize;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.AsynchronousAgentDispatcher.WriteTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */