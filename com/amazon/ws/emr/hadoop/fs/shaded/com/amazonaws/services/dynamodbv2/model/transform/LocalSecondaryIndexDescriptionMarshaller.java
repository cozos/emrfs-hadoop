package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexDescription;
import java.util.List;

@SdkInternalApi
public class LocalSecondaryIndexDescriptionMarshaller
{
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final MarshallingInfo<List> KEYSCHEMA_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySchema").build();
  private static final MarshallingInfo<StructuredPojo> PROJECTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Projection").build();
  private static final MarshallingInfo<Long> INDEXSIZEBYTES_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("IndexSizeBytes").build();
  private static final MarshallingInfo<Long> ITEMCOUNT_BINDING = MarshallingInfo.builder(MarshallingType.LONG).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ItemCount").build();
  private static final MarshallingInfo<String> INDEXARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexArn").build();
  private static final LocalSecondaryIndexDescriptionMarshaller instance = new LocalSecondaryIndexDescriptionMarshaller();
  
  public static LocalSecondaryIndexDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(LocalSecondaryIndexDescription localSecondaryIndexDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (localSecondaryIndexDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(localSecondaryIndexDescription.getIndexName(), INDEXNAME_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexDescription.getKeySchema(), KEYSCHEMA_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexDescription.getProjection(), PROJECTION_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexDescription.getIndexSizeBytes(), INDEXSIZEBYTES_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexDescription.getItemCount(), ITEMCOUNT_BINDING);
      protocolMarshaller.marshall(localSecondaryIndexDescription.getIndexArn(), INDEXARN_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LocalSecondaryIndexDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */