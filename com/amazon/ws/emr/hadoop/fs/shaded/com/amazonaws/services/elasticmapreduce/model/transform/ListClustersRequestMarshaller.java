package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersRequest;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class ListClustersRequestMarshaller
{
  private static final MarshallingInfo<Date> CREATEDAFTER_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreatedAfter").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> CREATEDBEFORE_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreatedBefore").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<List> CLUSTERSTATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ClusterStates").build();
  private static final MarshallingInfo<String> MARKER_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Marker").build();
  private static final ListClustersRequestMarshaller instance = new ListClustersRequestMarshaller();
  
  public static ListClustersRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ListClustersRequest listClustersRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (listClustersRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(listClustersRequest.getCreatedAfter(), CREATEDAFTER_BINDING);
      protocolMarshaller.marshall(listClustersRequest.getCreatedBefore(), CREATEDBEFORE_BINDING);
      protocolMarshaller.marshall(listClustersRequest.getClusterStates(), CLUSTERSTATES_BINDING);
      protocolMarshaller.marshall(listClustersRequest.getMarker(), MARKER_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListClustersRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */