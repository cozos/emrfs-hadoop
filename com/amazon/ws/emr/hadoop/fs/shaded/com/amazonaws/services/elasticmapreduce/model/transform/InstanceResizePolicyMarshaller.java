package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceResizePolicy;
import java.util.List;

@SdkInternalApi
public class InstanceResizePolicyMarshaller
{
  private static final MarshallingInfo<List> INSTANCESTOTERMINATE_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstancesToTerminate").build();
  private static final MarshallingInfo<List> INSTANCESTOPROTECT_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstancesToProtect").build();
  private static final MarshallingInfo<Integer> INSTANCETERMINATIONTIMEOUT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceTerminationTimeout").build();
  private static final InstanceResizePolicyMarshaller instance = new InstanceResizePolicyMarshaller();
  
  public static InstanceResizePolicyMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceResizePolicy instanceResizePolicy, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceResizePolicy == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceResizePolicy.getInstancesToTerminate(), INSTANCESTOTERMINATE_BINDING);
      protocolMarshaller.marshall(instanceResizePolicy.getInstancesToProtect(), INSTANCESTOPROTECT_BINDING);
      protocolMarshaller.marshall(instanceResizePolicy.getInstanceTerminationTimeout(), INSTANCETERMINATIONTIMEOUT_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceResizePolicyMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */