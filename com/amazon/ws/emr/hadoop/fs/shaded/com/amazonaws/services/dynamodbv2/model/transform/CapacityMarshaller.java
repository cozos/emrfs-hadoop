package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Capacity;

@SdkInternalApi
public class CapacityMarshaller
{
  private static final MarshallingInfo<Double> READCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadCapacityUnits").build();
  private static final MarshallingInfo<Double> WRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("WriteCapacityUnits").build();
  private static final MarshallingInfo<Double> CAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CapacityUnits").build();
  private static final CapacityMarshaller instance = new CapacityMarshaller();
  
  public static CapacityMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Capacity capacity, ProtocolMarshaller protocolMarshaller)
  {
    if (capacity == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(capacity.getReadCapacityUnits(), READCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(capacity.getWriteCapacityUnits(), WRITECAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(capacity.getCapacityUnits(), CAPACITYUNITS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CapacityMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */