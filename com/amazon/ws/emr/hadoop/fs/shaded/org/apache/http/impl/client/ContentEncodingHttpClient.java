package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.RequestAcceptEncoding;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.protocol.ResponseContentEncoding;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.HttpParams;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.BasicHttpProcessor;

@Deprecated
@Contract(threading=ThreadingBehavior.SAFE_CONDITIONAL)
public class ContentEncodingHttpClient
  extends DefaultHttpClient
{
  public ContentEncodingHttpClient(ClientConnectionManager conman, HttpParams params)
  {
    super(conman, params);
  }
  
  public ContentEncodingHttpClient(HttpParams params)
  {
    this(null, params);
  }
  
  public ContentEncodingHttpClient()
  {
    this(null);
  }
  
  protected BasicHttpProcessor createHttpProcessor()
  {
    BasicHttpProcessor result = super.createHttpProcessor();
    
    result.addRequestInterceptor(new RequestAcceptEncoding());
    result.addResponseInterceptor(new ResponseContentEncoding());
    
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.ContentEncodingHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */