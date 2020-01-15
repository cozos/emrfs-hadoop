package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import java.util.List;

@SdkInternalApi
public class UpdateGlobalTableRequestMarshaller
{
  private static final MarshallingInfo<String> GLOBALTABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableName").build();
  private static final MarshallingInfo<List> REPLICAUPDATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicaUpdates").build();
  private static final UpdateGlobalTableRequestMarshaller instance = new UpdateGlobalTableRequestMarshaller();
  
  public static UpdateGlobalTableRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(UpdateGlobalTableRequest updateGlobalTableRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (updateGlobalTableRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(updateGlobalTableRequest.getGlobalTableName(), GLOBALTABLENAME_BINDING);
      protocolMarshaller.marshall(updateGlobalTableRequest.getReplicaUpdates(), REPLICAUPDATES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */