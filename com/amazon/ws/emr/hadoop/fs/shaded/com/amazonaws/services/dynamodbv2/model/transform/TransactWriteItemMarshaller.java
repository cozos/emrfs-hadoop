package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItem;

@SdkInternalApi
public class TransactWriteItemMarshaller
{
  private static final MarshallingInfo<StructuredPojo> CONDITIONCHECK_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ConditionCheck").build();
  private static final MarshallingInfo<StructuredPojo> PUT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Put").build();
  private static final MarshallingInfo<StructuredPojo> DELETE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Delete").build();
  private static final MarshallingInfo<StructuredPojo> UPDATE_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Update").build();
  private static final TransactWriteItemMarshaller instance = new TransactWriteItemMarshaller();
  
  public static TransactWriteItemMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(TransactWriteItem transactWriteItem, ProtocolMarshaller protocolMarshaller)
  {
    if (transactWriteItem == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(transactWriteItem.getConditionCheck(), CONDITIONCHECK_BINDING);
      protocolMarshaller.marshall(transactWriteItem.getPut(), PUT_BINDING);
      protocolMarshaller.marshall(transactWriteItem.getDelete(), DELETE_BINDING);
      protocolMarshaller.marshall(transactWriteItem.getUpdate(), UPDATE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactWriteItemMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */