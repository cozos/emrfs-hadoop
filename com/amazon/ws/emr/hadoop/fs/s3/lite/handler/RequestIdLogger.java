package com.amazon.ws.emr.hadoop.fs.s3.lite.handler;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RequestIdLogger
  extends RequestHandler2
{
  private static final Logger logger = LoggerFactory.getLogger(RequestIdLogger.class);
  
  public void afterResponse(Request<?> request, Response<?> response)
  {
    if (logger.isDebugEnabled())
    {
      HttpResponse httpResponse = response.getHttpResponse();
      logger.debug("{} {}={} {}={}", new Object[] {httpResponse
        .getHttpRequest().getURI(), "x-amz-request-id", httpResponse
        
        .getHeader("x-amz-request-id"), "x-amz-id-2", httpResponse
        
        .getHeader("x-amz-id-2") });
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.handler.RequestIdLogger
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */