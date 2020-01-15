package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import java.util.List;

@SdkInternalApi
public class CreateGlobalTableRequestMarshaller
{
  private static final MarshallingInfo<String> GLOBALTABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalTableName").build();
  private static final MarshallingInfo<List> REPLICATIONGROUP_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReplicationGroup").build();
  private static final CreateGlobalTableRequestMarshaller instance = new CreateGlobalTableRequestMarshaller();
  
  public static CreateGlobalTableRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(CreateGlobalTableRequest createGlobalTableRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (createGlobalTableRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(createGlobalTableRequest.getGlobalTableName(), GLOBALTABLENAME_BINDING);
      protocolMarshaller.marshall(createGlobalTableRequest.getReplicationGroup(), REPLICATIONGROUP_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */