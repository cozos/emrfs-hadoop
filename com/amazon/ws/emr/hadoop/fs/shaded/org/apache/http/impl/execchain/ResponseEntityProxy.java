package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.EofSensorInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.EofSensorWatcher;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

class ResponseEntityProxy
  extends HttpEntityWrapper
  implements EofSensorWatcher
{
  private final ConnectionHolder connHolder;
  
  public static void enchance(HttpResponse response, ConnectionHolder connHolder)
  {
    HttpEntity entity = response.getEntity();
    if ((entity != null) && (entity.isStreaming()) && (connHolder != null)) {
      response.setEntity(new ResponseEntityProxy(entity, connHolder));
    }
  }
  
  ResponseEntityProxy(HttpEntity entity, ConnectionHolder connHolder)
  {
    super(entity);
    this.connHolder = connHolder;
  }
  
  private void cleanup()
    throws IOException
  {
    if (connHolder != null) {
      connHolder.close();
    }
  }
  
  private void abortConnection()
    throws IOException
  {
    if (connHolder != null) {
      connHolder.abortConnection();
    }
  }
  
  public void releaseConnection()
    throws IOException
  {
    if (connHolder != null) {
      connHolder.releaseConnection();
    }
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new EofSensorInputStream(wrappedEntity.getContent(), this);
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {
    releaseConnection();
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    try
    {
      if (outstream != null) {
        wrappedEntity.writeTo(outstream);
      }
      releaseConnection();
    }
    catch (IOException ex)
    {
      throw ex;
    }
    catch (RuntimeException ex)
    {
      throw ex;
    }
    finally
    {
      cleanup();
    }
  }
  
  public boolean eofDetected(InputStream wrapped)
    throws IOException
  {
    try
    {
      if (wrapped != null) {
        wrapped.close();
      }
      releaseConnection();
    }
    catch (IOException ex)
    {
      throw ex;
    }
    catch (RuntimeException ex)
    {
      throw ex;
    }
    finally
    {
      cleanup();
    }
    return false;
  }
  
  public boolean streamClosed(InputStream wrapped)
    throws IOException
  {
    try
    {
      boolean open = (connHolder != null) && (!connHolder.isReleased());
      try
      {
        if (wrapped != null) {
          wrapped.close();
        }
        releaseConnection();
      }
      catch (SocketException ex)
      {
        if (open) {
          throw ex;
        }
      }
    }
    catch (IOException ex)
    {
      throw ex;
    }
    catch (RuntimeException ex)
    {
      throw ex;
    }
    finally
    {
      cleanup();
    }
    return false;
  }
  
  public boolean streamAbort(InputStream wrapped)
    throws IOException
  {
    cleanup();
    return false;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder("ResponseEntityProxy{");
    sb.append(wrappedEntity);
    sb.append('}');
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.ResponseEntityProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */