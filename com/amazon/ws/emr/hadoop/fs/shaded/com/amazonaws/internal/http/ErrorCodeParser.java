package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContent;

@SdkInternalApi
public abstract interface ErrorCodeParser
{
  public abstract String parseErrorCode(HttpResponse paramHttpResponse, JsonContent paramJsonContent);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.ErrorCodeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */