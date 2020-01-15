package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;

public abstract interface AuthErrorRetryStrategy
{
  public abstract AuthRetryParameters shouldRetryWithAuthParam(Request<?> paramRequest, HttpResponse paramHttpResponse, AmazonServiceException paramAmazonServiceException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthErrorRetryStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */