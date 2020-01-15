package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.CloseableHttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpExecutionAware;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.HttpClientContext;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import java.io.IOException;

public abstract interface ClientExecChain
{
  public abstract CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware)
    throws IOException, HttpException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.ClientExecChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */