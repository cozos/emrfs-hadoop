package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.BackoffManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ConnectionBackoffStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class BackoffStrategyExec
  implements ClientExecChain
{
  private final ClientExecChain requestExecutor;
  private final ConnectionBackoffStrategy connectionBackoffStrategy;
  private final BackoffManager backoffManager;
  
  public BackoffStrategyExec(ClientExecChain requestExecutor, ConnectionBackoffStrategy connectionBackoffStrategy, BackoffManager backoffManager)
  {
    Args.notNull(requestExecutor, "HTTP client request executor");
    Args.notNull(connectionBackoffStrategy, "Connection backoff strategy");
    Args.notNull(backoffManager, "Backoff manager");
    this.requestExecutor = requestExecutor;
    this.connectionBackoffStrategy = connectionBackoffStrategy;
    this.backoffManager = backoffManager;
  }
  
  public CloseableHttpResponse execute(HttpRoute route, HttpRequestWrapper request, HttpClientContext context, HttpExecutionAware execAware)
    throws IOException, HttpException
  {
    Args.notNull(route, "HTTP route");
    Args.notNull(request, "HTTP request");
    Args.notNull(context, "HTTP context");
    CloseableHttpResponse out = null;
    try
    {
      out = requestExecutor.execute(route, request, context, execAware);
    }
    catch (Exception ex)
    {
      if (out != null) {
        out.close();
      }
      if (connectionBackoffStrategy.shouldBackoff(ex)) {
        backoffManager.backOff(route);
      }
      if ((ex instanceof RuntimeException)) {
        throw ((RuntimeException)ex);
      }
      if ((ex instanceof HttpException)) {
        throw ((HttpException)ex);
      }
      if ((ex instanceof IOException)) {
        throw ((IOException)ex);
      }
      throw new UndeclaredThrowableException(ex);
    }
    if (connectionBackoffStrategy.shouldBackoff(out)) {
      backoffManager.backOff(route);
    } else {
      backoffManager.probe(route);
    }
    return out;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.BackoffStrategyExec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */