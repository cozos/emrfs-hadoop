package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest;
import java.util.List;

@SdkInternalApi
public class AddInstanceGroupsRequestMarshaller
{
  private static final MarshallingInfo<List> INSTANCEGROUPS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroups").build();
  private static final MarshallingInfo<String> JOBFLOWID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("JobFlowId").build();
  private static final AddInstanceGroupsRequestMarshaller instance = new AddInstanceGroupsRequestMarshaller();
  
  public static AddInstanceGroupsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(AddInstanceGroupsRequest addInstanceGroupsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (addInstanceGroupsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(addInstanceGroupsRequest.getInstanceGroups(), INSTANCEGROUPS_BINDING);
      protocolMarshaller.marshall(addInstanceGroupsRequest.getJobFlowId(), JOBFLOWID_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceGroupsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */