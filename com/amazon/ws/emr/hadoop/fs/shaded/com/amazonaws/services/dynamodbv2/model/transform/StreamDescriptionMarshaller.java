package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamDescription;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class StreamDescriptionMarshaller
{
  private static final MarshallingInfo<String> STREAMARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("StreamArn").build();
  private static final MarshallingInfo<String> STREAMLABEL_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamLabel").build();
  private static final MarshallingInfo<String> STREAMSTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamStatus").build();
  private static final MarshallingInfo<String> STREAMVIEWTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamViewType").build();
  private static final MarshallingInfo<Date> CREATIONREQUESTDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationRequestDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<List> KEYSCHEMA_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySchema").build();
  private static final MarshallingInfo<List> SHARDS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Shards").build();
  private static final MarshallingInfo<String> LASTEVALUATEDSHARDID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastEvaluatedShardId").build();
  private static final StreamDescriptionMarshaller instance = new StreamDescriptionMarshaller();
  
  public static StreamDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(StreamDescription streamDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (streamDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(streamDescription.getStreamArn(), STREAMARN_BINDING);
      protocolMarshaller.marshall(streamDescription.getStreamLabel(), STREAMLABEL_BINDING);
      protocolMarshaller.marshall(streamDescription.getStreamStatus(), STREAMSTATUS_BINDING);
      protocolMarshaller.marshall(streamDescription.getStreamViewType(), STREAMVIEWTYPE_BINDING);
      protocolMarshaller.marshall(streamDescription.getCreationRequestDateTime(), CREATIONREQUESTDATETIME_BINDING);
      protocolMarshaller.marshall(streamDescription.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(streamDescription.getKeySchema(), KEYSCHEMA_BINDING);
      protocolMarshaller.marshall(streamDescription.getShards(), SHARDS_BINDING);
      protocolMarshaller.marshall(streamDescription.getLastEvaluatedShardId(), LASTEVALUATEDSHARDID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */