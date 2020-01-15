package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ExceptionLogger;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpServerConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpCoreContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpService;
import java.io.IOException;

class Worker
  implements Runnable
{
  private final HttpService httpservice;
  private final HttpServerConnection conn;
  private final ExceptionLogger exceptionLogger;
  
  Worker(HttpService httpservice, HttpServerConnection conn, ExceptionLogger exceptionLogger)
  {
    this.httpservice = httpservice;
    this.conn = conn;
    this.exceptionLogger = exceptionLogger;
  }
  
  public HttpServerConnection getConnection()
  {
    return conn;
  }
  
  public void run()
  {
    try
    {
      BasicHttpContext localContext = new BasicHttpContext();
      HttpCoreContext context = HttpCoreContext.adapt(localContext);
      while ((!Thread.interrupted()) && (conn.isOpen()))
      {
        httpservice.handleRequest(conn, context);
        localContext.clear();
      }
      conn.close(); return;
    }
    catch (Exception ex)
    {
      exceptionLogger.log(ex);
    }
    finally
    {
      try
      {
        conn.shutdown();
      }
      catch (IOException ex)
      {
        exceptionLogger.log(ex);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap.Worker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */