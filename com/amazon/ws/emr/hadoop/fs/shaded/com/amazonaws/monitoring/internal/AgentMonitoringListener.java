package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

@SdkInternalApi
public final class AgentMonitoringListener
  extends MonitoringListener
{
  private static final Log LOG = LogFactory.getLog(AgentMonitoringListener.class);
  private static final String SIMPLE_NAME = "AgentMonitoringListener";
  private static final int MAX_BUFFER_SIZE = 8192;
  private AsynchronousAgentDispatcher dispatcher;
  private final DatagramChannel channel;
  private final int maxSize;
  
  public AgentMonitoringListener(String host, int port)
    throws SdkClientException
  {
    try
    {
      dispatcher = AsynchronousAgentDispatcher.getInstance();
      dispatcher.init();
      
      channel = DatagramChannel.open();
      channel.configureBlocking(false);
      if (channel.socket().getSendBufferSize() < 8192) {
        channel.socket().setSendBufferSize(8192);
      }
      maxSize = Math.min(8192, channel.socket().getSendBufferSize());
      if ((maxSize < 8192) && (LOG.isDebugEnabled())) {
        LOG.debug(String.format("System socket buffer size %d is less than 8K. Any events larger than the buffer size will be dropped", new Object[] {
          Integer.valueOf(maxSize) }));
      }
      channel.connect(new InetSocketAddress(host, port));
    }
    catch (Exception e)
    {
      if (dispatcher != null) {
        dispatcher.release();
      }
      throw new SdkClientException("Failed to initialize AgentMonitoringListener", e);
    }
  }
  
  @SdkTestInternalApi
  AgentMonitoringListener(DatagramChannel channel, AsynchronousAgentDispatcher dispatcher, int maxSize)
  {
    this.channel = channel;
    this.dispatcher = dispatcher;
    this.maxSize = maxSize;
  }
  
  public void handleEvent(MonitoringEvent event)
  {
    dispatcher.addWriteTask(event, channel, maxSize);
  }
  
  public String toString()
  {
    return "AgentMonitoringListener";
  }
  
  public void shutdown()
  {
    dispatcher.release();
    try
    {
      channel.close();
    }
    catch (IOException ioe)
    {
      LOG.error("Could not close datagram channel", ioe);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.internal.AgentMonitoringListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */