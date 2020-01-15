package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexInfo;
import java.util.List;

@SdkInternalApi
public class LocalSecondaryIndexInfoMarshaller
{
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final MarshallingInfo<List> KEYSCHEMA_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySchema").build();
  private static final MarshallingInfo<StructuredPojo> PROJECTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Projection").build();
  private static final LocalSecondaryIndexInfoMarshaller instance = new LocalSecondaryIndexInfoMarshaller();
  
  public static LocalSecondaryIndexInfoMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(LocalSecondaryIndexInfo localSecondaryIndexInfo, ProtocolMarshaller protocolMarshaller)
  {
    if (localSecondaryIndexInfo == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(localSecondaryIndexInfo.getIndexName(), INDEXNAME_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexInfo.getKeySchema(), KEYSCHEMA_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexInfo.getProjection(), PROJECTION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LocalSecondaryIndexInfoMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */