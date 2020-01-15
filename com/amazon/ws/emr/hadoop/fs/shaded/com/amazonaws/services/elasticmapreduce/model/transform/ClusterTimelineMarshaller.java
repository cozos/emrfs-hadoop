package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ClusterTimeline;
import java.util.Date;

@SdkInternalApi
public class ClusterTimelineMarshaller
{
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> READYDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadyDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> ENDDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EndDateTime").timestampFormat("unixTimestamp").build();
  private static final ClusterTimelineMarshaller instance = new ClusterTimelineMarshaller();
  
  public static ClusterTimelineMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ClusterTimeline clusterTimeline, ProtocolMarshaller protocolMarshaller)
  {
    if (clusterTimeline == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(clusterTimeline.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(clusterTimeline.getReadyDateTime(), READYDATETIME_BINDING);
      protocolMarshaller.marshall(clusterTimeline.getEndDateTime(), ENDDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ClusterTimelineMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */