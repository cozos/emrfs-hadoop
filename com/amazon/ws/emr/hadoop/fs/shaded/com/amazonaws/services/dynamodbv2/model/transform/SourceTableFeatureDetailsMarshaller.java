package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SourceTableFeatureDetails;
import java.util.List;

@SdkInternalApi
public class SourceTableFeatureDetailsMarshaller
{
  private static final MarshallingInfo<List> LOCALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LocalSecondaryIndexes").build();
  private static final MarshallingInfo<List> GLOBALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalSecondaryIndexes").build();
  private static final MarshallingInfo<StructuredPojo> STREAMDESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamDescription").build();
  private static final MarshallingInfo<StructuredPojo> TIMETOLIVEDESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TimeToLiveDescription").build();
  private static final MarshallingInfo<StructuredPojo> SSEDESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SSEDescription").build();
  private static final SourceTableFeatureDetailsMarshaller instance = new SourceTableFeatureDetailsMarshaller();
  
  public static SourceTableFeatureDetailsMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SourceTableFeatureDetails sourceTableFeatureDetails, ProtocolMarshaller protocolMarshaller)
  {
    if (sourceTableFeatureDetails == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(sourceTableFeatureDetails.getLocalSecondaryIndexes(), LOCALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(sourceTableFeatureDetails.getGlobalSecondaryIndexes(), GLOBALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(sourceTableFeatureDetails.getStreamDescription(), STREAMDESCRIPTION_BINDING);
      protocolMarshaller.marshall(sourceTableFeatureDetails.getTimeToLiveDescription(), TIMETOLIVEDESCRIPTION_BINDING);
      protocolMarshaller.marshall(sourceTableFeatureDetails.getSSEDescription(), SSEDESCRIPTION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SourceTableFeatureDetailsMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */