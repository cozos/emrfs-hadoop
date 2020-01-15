package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;

@SdkInternalApi
public class DescribeLimitsRequestMarshaller
{
  private static final DescribeLimitsRequestMarshaller instance = new DescribeLimitsRequestMarshaller();
  
  public static DescribeLimitsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DescribeLimitsRequest describeLimitsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (describeLimitsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */