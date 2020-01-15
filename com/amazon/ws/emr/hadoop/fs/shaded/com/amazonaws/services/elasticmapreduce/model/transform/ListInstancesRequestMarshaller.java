package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest;
import java.util.List;

@SdkInternalApi
public class ListInstancesRequestMarshaller
{
  private static final MarshallingInfo<String> CLUSTERID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ClusterId").build();
  private static final MarshallingInfo<String> INSTANCEGROUPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupId").build();
  private static final MarshallingInfo<List> INSTANCEGROUPTYPES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupTypes").build();
  private static final MarshallingInfo<String> INSTANCEFLEETID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleetId").build();
  private static final MarshallingInfo<String> INSTANCEFLEETTYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleetType").build();
  private static final MarshallingInfo<List> INSTANCESTATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceStates").build();
  private static final MarshallingInfo<String> MARKER_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Marker").build();
  private static final ListInstancesRequestMarshaller instance = new ListInstancesRequestMarshaller();
  
  public static ListInstancesRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ListInstancesRequest listInstancesRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (listInstancesRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(listInstancesRequest.getClusterId(), CLUSTERID_BINDING);
      protocolMarshaller.marshall(listInstancesRequest.getInstanceGroupId(), INSTANCEGROUPID_BINDING);
      protocolMarshaller.marshall(listInstancesRequest.getInstanceGroupTypes(), INSTANCEGROUPTYPES_BINDING);
      protocolMarshaller.marshall(listInstancesRequest.getInstanceFleetId(), INSTANCEFLEETID_BINDING);
      protocolMarshaller.marshall(listInstancesRequest.getInstanceFleetType(), INSTANCEFLEETTYPE_BINDING);
      protocolMarshaller.marshall(listInstancesRequest.getInstanceStates(), INSTANCESTATES_BINDING);
      protocolMarshaller.marshall(listInstancesRequest.getMarker(), MARKER_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstancesRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */