package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ServiceUnavailableRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class ServiceUnavailableRetryExec
  implements ClientExecChain
{
  private final Log log = LogFactory.getLog(getClass());
  private final ClientExecChain requestExecutor;
  private final ServiceUnavailableRetryStrategy retryStrategy;
  
  public ServiceUnavailableRetryExec(ClientExecChain requestExecutor, ServiceUnavailableRetryStrategy retryStrategy)
  {
    Args.notNull(requestExecutor, "HTTP request executor");
    Args.notNull(retryStrategy, "Retry strategy");
    this.requestExecutor = requestExecutor;
    this.retryStrategy = retryStrategy;
  }
  
  public CloseableHttpResponse execute(HttpRoute route, HttpRequestWrapper request, HttpClientContext context, HttpExecutionAware execAware)
    throws IOException, HttpException
  {
    Header[] origheaders = request.getAllHeaders();
    for (int c = 1;; c++)
    {
      CloseableHttpResponse response = requestExecutor.execute(route, request, context, execAware);
      try
      {
        if ((retryStrategy.retryRequest(response, c, context)) && (RequestEntityProxy.isRepeatable(request)))
        {
          response.close();
          long nextInterval = retryStrategy.getRetryInterval();
          if (nextInterval > 0L) {
            try
            {
              log.trace("Wait for " + nextInterval);
              Thread.sleep(nextInterval);
            }
            catch (InterruptedException e)
            {
              Thread.currentThread().interrupt();
              throw new InterruptedIOException();
            }
          }
          request.setHeaders(origheaders);
        }
        else
        {
          return response;
        }
      }
      catch (RuntimeException ex)
      {
        response.close();
        throw ex;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.ServiceUnavailableRetryExec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */