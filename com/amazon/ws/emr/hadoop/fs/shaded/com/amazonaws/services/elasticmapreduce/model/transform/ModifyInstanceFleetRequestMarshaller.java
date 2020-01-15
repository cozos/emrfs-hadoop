package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetRequest;

@SdkInternalApi
public class ModifyInstanceFleetRequestMarshaller
{
  private static final MarshallingInfo<String> CLUSTERID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ClusterId").build();
  private static final MarshallingInfo<StructuredPojo> INSTANCEFLEET_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleet").build();
  private static final ModifyInstanceFleetRequestMarshaller instance = new ModifyInstanceFleetRequestMarshaller();
  
  public static ModifyInstanceFleetRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ModifyInstanceFleetRequest modifyInstanceFleetRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (modifyInstanceFleetRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(modifyInstanceFleetRequest.getClusterId(), CLUSTERID_BINDING);
      protocolMarshaller.marshall(modifyInstanceFleetRequest.getInstanceFleet(), INSTANCEFLEET_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ModifyInstanceFleetRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */