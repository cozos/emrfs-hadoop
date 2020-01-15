package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersRequest;
import java.util.List;

@SdkInternalApi
public class SetVisibleToAllUsersRequestMarshaller
{
  private static final MarshallingInfo<List> JOBFLOWIDS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("JobFlowIds").build();
  private static final MarshallingInfo<Boolean> VISIBLETOALLUSERS_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("VisibleToAllUsers").build();
  private static final SetVisibleToAllUsersRequestMarshaller instance = new SetVisibleToAllUsersRequestMarshaller();
  
  public static SetVisibleToAllUsersRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SetVisibleToAllUsersRequest setVisibleToAllUsersRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (setVisibleToAllUsersRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(setVisibleToAllUsersRequest.getJobFlowIds(), JOBFLOWIDS_BINDING);
      protocolMarshaller.marshall(setVisibleToAllUsersRequest.getVisibleToAllUsers(), VISIBLETOALLUSERS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SetVisibleToAllUsersRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */