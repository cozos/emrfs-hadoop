package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.util.DebugUtils;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamPumper
  implements Runnable
{
  public static final int SLEEPING_TIME = 100;
  private final InputStream is;
  private final OutputStream os;
  private volatile boolean stop;
  
  public InputStreamPumper(InputStream is, OutputStream os)
  {
    this.is = is;
    this.os = os;
    stop = false;
  }
  
  public void run()
  {
    try
    {
      while (!stop)
      {
        while ((is.available() > 0) && (!stop)) {
          os.write(is.read());
        }
        os.flush();
        Thread.sleep(100L);
      }
    }
    catch (Exception e)
    {
      e = 
      
        e;String msg = "Got exception while reading/writing the stream";DebugUtils.handleException("Got exception while reading/writing the stream", e);
    }
    finally {}
  }
  
  public void stopProcessing()
  {
    stop = true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.InputStreamPumper
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */