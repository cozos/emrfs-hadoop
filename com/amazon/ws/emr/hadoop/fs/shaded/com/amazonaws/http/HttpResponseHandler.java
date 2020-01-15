package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

public abstract interface HttpResponseHandler<T>
{
  public static final String X_AMZN_REQUEST_ID_HEADER = "x-amzn-RequestId";
  public static final String X_AMZN_EXTENDED_REQUEST_ID_HEADER = "x-amz-id-2";
  
  public abstract T handle(HttpResponse paramHttpResponse)
    throws Exception;
  
  public abstract boolean needsConnectionLeftOpen();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */