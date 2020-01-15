package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkMetricsSocket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkSSLMetricsSocket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ManagedHttpClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestExecutor;
import java.io.IOException;
import java.net.Socket;

public class SdkHttpRequestExecutor
  extends HttpRequestExecutor
{
  protected HttpResponse doSendRequest(HttpRequest request, HttpClientConnection conn, HttpContext context)
    throws IOException, HttpException
  {
    AWSRequestMetrics awsRequestMetrics = (AWSRequestMetrics)context.getAttribute(AWSRequestMetrics.SIMPLE_NAME);
    if (awsRequestMetrics == null) {
      return super.doSendRequest(request, conn, context);
    }
    ManagedHttpClientConnection managedConn;
    if ((conn instanceof ManagedHttpClientConnection))
    {
      managedConn = (ManagedHttpClientConnection)conn;
      Socket sock = managedConn.getSocket();
      if ((sock instanceof SdkMetricsSocket))
      {
        SdkMetricsSocket sdkMetricsSocket = (SdkMetricsSocket)sock;
        sdkMetricsSocket.setMetrics(awsRequestMetrics);
      }
      else if ((sock instanceof SdkSSLMetricsSocket))
      {
        SdkSSLMetricsSocket sdkSSLMetricsSocket = (SdkSSLMetricsSocket)sock;
        sdkSSLMetricsSocket.setMetrics(awsRequestMetrics);
      }
    }
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.HttpClientSendRequestTime);
    try
    {
      return super.doSendRequest(request, conn, context);
    }
    finally
    {
      awsRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpClientSendRequestTime);
    }
  }
  
  protected HttpResponse doReceiveResponse(HttpRequest request, HttpClientConnection conn, HttpContext context)
    throws HttpException, IOException
  {
    AWSRequestMetrics awsRequestMetrics = (AWSRequestMetrics)context.getAttribute(AWSRequestMetrics.SIMPLE_NAME);
    if (awsRequestMetrics == null) {
      return super.doReceiveResponse(request, conn, context);
    }
    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
    try
    {
      return super.doReceiveResponse(request, conn, context);
    }
    finally
    {
      awsRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.protocol.SdkHttpRequestExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */