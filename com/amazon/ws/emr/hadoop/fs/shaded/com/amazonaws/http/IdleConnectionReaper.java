package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.HttpClientConnectionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@SdkInternalApi
public final class IdleConnectionReaper
  extends Thread
{
  private static final Log LOG = LogFactory.getLog(IdleConnectionReaper.class);
  private static final int PERIOD_MILLISECONDS = 60000;
  @Deprecated
  private static final int DEFAULT_MAX_IDLE_MILLIS = 60000;
  private static final Map<HttpClientConnectionManager, Long> connectionManagers = new ConcurrentHashMap();
  private static volatile IdleConnectionReaper instance;
  private volatile boolean shuttingDown;
  
  private IdleConnectionReaper()
  {
    super("java-sdk-http-connection-reaper");
    setDaemon(true);
  }
  
  @Deprecated
  public static boolean registerConnectionManager(HttpClientConnectionManager connectionManager)
  {
    return registerConnectionManager(connectionManager, 60000L);
  }
  
  public static boolean registerConnectionManager(HttpClientConnectionManager connectionManager, long maxIdleInMs)
  {
    if (instance == null) {
      synchronized (IdleConnectionReaper.class)
      {
        if (instance == null)
        {
          instance = new IdleConnectionReaper();
          instance.start();
        }
      }
    }
    return connectionManagers.put(connectionManager, Long.valueOf(maxIdleInMs)) == null;
  }
  
  public static boolean removeConnectionManager(HttpClientConnectionManager connectionManager)
  {
    boolean wasRemoved = connectionManagers.remove(connectionManager) != null;
    if (connectionManagers.isEmpty()) {
      shutdown();
    }
    return wasRemoved;
  }
  
  @SdkTestInternalApi
  public static List<HttpClientConnectionManager> getRegisteredConnectionManagers()
  {
    return new ArrayList(connectionManagers.keySet());
  }
  
  public static synchronized boolean shutdown()
  {
    if (instance != null)
    {
      instance.markShuttingDown();
      instance.interrupt();
      connectionManagers.clear();
      instance = null;
      return true;
    }
    return false;
  }
  
  static int size()
  {
    return connectionManagers.size();
  }
  
  private void markShuttingDown()
  {
    shuttingDown = true;
  }
  
  public void run()
  {
    while (!shuttingDown) {
      try
      {
        for (Map.Entry<HttpClientConnectionManager, Long> entry : connectionManagers.entrySet()) {
          try
          {
            ((HttpClientConnectionManager)entry.getKey()).closeIdleConnections(((Long)entry.getValue()).longValue(), TimeUnit.MILLISECONDS);
          }
          catch (Exception t)
          {
            LOG.warn("Unable to close idle connections", t);
          }
        }
        Thread.sleep(60000L);
      }
      catch (Throwable t)
      {
        LOG.debug("Reaper thread: ", t);
      }
    }
    LOG.debug("Shutting down reaper thread.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.IdleConnectionReaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */