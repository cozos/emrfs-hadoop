package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

@SdkInternalApi
public class ProvisionedThroughputMarshaller
{
  private static final MarshallingInfo<Long> READCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadCapacityUnits").build();
  private static final MarshallingInfo<Long> WRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("WriteCapacityUnits").build();
  private static final ProvisionedThroughputMarshaller instance = new ProvisionedThroughputMarshaller();
  
  public static ProvisionedThroughputMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ProvisionedThroughput provisionedThroughput, ProtocolMarshaller protocolMarshaller)
  {
    if (provisionedThroughput == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(provisionedThroughput.getReadCapacityUnits(), READCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(provisionedThroughput.getWriteCapacityUnits(), WRITECAPACITYUNITS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */