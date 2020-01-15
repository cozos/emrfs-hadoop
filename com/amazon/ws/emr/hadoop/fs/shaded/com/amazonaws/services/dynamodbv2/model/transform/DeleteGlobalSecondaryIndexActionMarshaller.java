package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteGlobalSecondaryIndexAction;

@SdkInternalApi
public class DeleteGlobalSecondaryIndexActionMarshaller
{
  private static final MarshallingInfo<String> INDEXNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("IndexName").build();
  private static final DeleteGlobalSecondaryIndexActionMarshaller instance = new DeleteGlobalSecondaryIndexActionMarshaller();
  
  public static DeleteGlobalSecondaryIndexActionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DeleteGlobalSecondaryIndexAction deleteGlobalSecondaryIndexAction, ProtocolMarshaller protocolMarshaller)
  {
    if (deleteGlobalSecondaryIndexAction == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(deleteGlobalSecondaryIndexAction.getIndexName(), INDEXNAME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteGlobalSecondaryIndexActionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */