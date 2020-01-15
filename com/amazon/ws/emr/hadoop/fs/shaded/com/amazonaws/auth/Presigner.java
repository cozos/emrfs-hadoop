package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazonaws.auth.AWSCredentials;
import java.util.Date;

public abstract interface Presigner
{
  public abstract void presignRequest(SignableRequest<?> paramSignableRequest, AWSCredentials paramAWSCredentials, Date paramDate);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Presigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */