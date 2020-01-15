package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import java.io.IOException;

public abstract interface HttpClientConnection
  extends HttpConnection
{
  public abstract boolean isResponseAvailable(int paramInt)
    throws IOException;
  
  public abstract void sendRequestHeader(HttpRequest paramHttpRequest)
    throws HttpException, IOException;
  
  public abstract void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
    throws HttpException, IOException;
  
  public abstract HttpResponse receiveResponseHeader()
    throws HttpException, IOException;
  
  public abstract void receiveResponseEntity(HttpResponse paramHttpResponse)
    throws HttpException, IOException;
  
  public abstract void flush()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpClientConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */