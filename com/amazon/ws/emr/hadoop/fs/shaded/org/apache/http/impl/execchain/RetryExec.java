package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NoHttpResponseException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.HttpRequestRetryHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.NonRepeatableRequestException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class RetryExec
  implements ClientExecChain
{
  private final Log log = LogFactory.getLog(getClass());
  private final ClientExecChain requestExecutor;
  private final HttpRequestRetryHandler retryHandler;
  
  public RetryExec(ClientExecChain requestExecutor, HttpRequestRetryHandler retryHandler)
  {
    Args.notNull(requestExecutor, "HTTP request executor");
    Args.notNull(retryHandler, "HTTP request retry handler");
    this.requestExecutor = requestExecutor;
    this.retryHandler = retryHandler;
  }
  
  public CloseableHttpResponse execute(HttpRoute route, HttpRequestWrapper request, HttpClientContext context, HttpExecutionAware execAware)
    throws IOException, HttpException
  {
    Args.notNull(route, "HTTP route");
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    Header[] origheaders = request.getAllHeaders();
    for (int execCount = 1;; execCount++) {
      try
      {
        return requestExecutor.execute(route, request, context, execAware);
      }
      catch (IOException ex)
      {
        if ((execAware != null) && (execAware.isAborted()))
        {
          log.debug("Request has been aborted");
          throw ex;
        }
        if (retryHandler.retryRequest(ex, execCount, context))
        {
          if (log.isInfoEnabled()) {
            log.info("I/O exception (" + ex.getClass().getName() + ") caught when processing request to " + route + ": " + ex.getMessage());
          }
          if (log.isDebugEnabled()) {
            log.debug(ex.getMessage(), ex);
          }
          if (!RequestEntityProxy.isRepeatable(request))
          {
            log.debug("Cannot retry non-repeatable request");
            throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", ex);
          }
          request.setHeaders(origheaders);
          if (log.isInfoEnabled()) {
            log.info("Retrying request to " + route);
          }
        }
        else
        {
          if ((ex instanceof NoHttpResponseException))
          {
            NoHttpResponseException updatedex = new NoHttpResponseException(route.getTargetHost().toHostString() + " failed to respond");
            
            updatedex.setStackTrace(ex.getStackTrace());
            throw updatedex;
          }
          throw ex;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.RetryExec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */