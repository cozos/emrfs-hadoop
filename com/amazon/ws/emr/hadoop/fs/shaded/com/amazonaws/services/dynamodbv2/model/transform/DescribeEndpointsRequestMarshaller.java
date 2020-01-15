package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;

@SdkInternalApi
public class DescribeEndpointsRequestMarshaller
{
  private static final DescribeEndpointsRequestMarshaller instance = new DescribeEndpointsRequestMarshaller();
  
  public static DescribeEndpointsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DescribeEndpointsRequest describeEndpointsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (describeEndpointsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */