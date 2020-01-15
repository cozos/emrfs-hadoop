package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;

@SdkInternalApi
public class GlobalSecondaryIndexUpdateMarshaller
{
  private static final MarshallingInfo<StructuredPojo> UPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Update").build();
  private static final MarshallingInfo<StructuredPojo> CREATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Create").build();
  private static final MarshallingInfo<StructuredPojo> DELETE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Delete").build();
  private static final GlobalSecondaryIndexUpdateMarshaller instance = new GlobalSecondaryIndexUpdateMarshaller();
  
  public static GlobalSecondaryIndexUpdateMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(GlobalSecondaryIndexUpdate globalSecondaryIndexUpdate, ProtocolMarshaller protocolMarshaller)
  {
    if (globalSecondaryIndexUpdate == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(globalSecondaryIndexUpdate.getUpdate(), UPDATE_BINDING);
      protocolMarshaller.marshall(globalSecondaryIndexUpdate.getCreate(), CREATE_BINDING);
      protocolMarshaller.marshall(globalSecondaryIndexUpdate.getDelete(), DELETE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalSecondaryIndexUpdateMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */