package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import java.util.Map;

@SdkInternalApi
public class ConsumedCapacityMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<Double> CAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CapacityUnits").build();
  private static final MarshallingInfo<Double> READCAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadCapacityUnits").build();
  private static final MarshallingInfo<Double> WRITECAPACITYUNITS_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("WriteCapacityUnits").build();
  private static final MarshallingInfo<StructuredPojo> TABLE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Table").build();
  private static final MarshallingInfo<Map> LOCALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LocalSecondaryIndexes").build();
  private static final MarshallingInfo<Map> GLOBALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.MAP)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalSecondaryIndexes").build();
  private static final ConsumedCapacityMarshaller instance = new ConsumedCapacityMarshaller();
  
  public static ConsumedCapacityMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ConsumedCapacity consumedCapacity, ProtocolMarshaller protocolMarshaller)
  {
    if (consumedCapacity == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(consumedCapacity.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(consumedCapacity.getCapacityUnits(), CAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(consumedCapacity.getReadCapacityUnits(), READCAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(consumedCapacity.getWriteCapacityUnits(), WRITECAPACITYUNITS_BINDING);
      protocolMarshaller.marshall(consumedCapacity.getTable(), TABLE_BINDING);
      protocolMarshaller.marshall(consumedCapacity.getLocalSecondaryIndexes(), LOCALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(consumedCapacity.getGlobalSecondaryIndexes(), GLOBALSECONDARYINDEXES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ConsumedCapacityMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */