package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract interface ArnConverter<T extends AwsResource>
{
  public abstract T convertArn(Arn paramArn);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn.ArnConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */