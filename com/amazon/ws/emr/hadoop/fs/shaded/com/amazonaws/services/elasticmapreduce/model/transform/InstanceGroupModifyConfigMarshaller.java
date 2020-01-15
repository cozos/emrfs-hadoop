package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig;
import java.util.List;

@SdkInternalApi
public class InstanceGroupModifyConfigMarshaller
{
  private static final MarshallingInfo<String> INSTANCEGROUPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupId").build();
  private static final MarshallingInfo<Integer> INSTANCECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceCount").build();
  private static final MarshallingInfo<List> EC2INSTANCEIDSTOTERMINATE_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EC2InstanceIdsToTerminate").build();
  private static final MarshallingInfo<StructuredPojo> SHRINKPOLICY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ShrinkPolicy").build();
  private static final MarshallingInfo<List> CONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Configurations").build();
  private static final InstanceGroupModifyConfigMarshaller instance = new InstanceGroupModifyConfigMarshaller();
  
  public static InstanceGroupModifyConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceGroupModifyConfig instanceGroupModifyConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceGroupModifyConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceGroupModifyConfig.getInstanceGroupId(), INSTANCEGROUPID_BINDING);
      protocolMarshaller.marshall(instanceGroupModifyConfig.getInstanceCount(), INSTANCECOUNT_BINDING);
      protocolMarshaller.marshall(instanceGroupModifyConfig.getEC2InstanceIdsToTerminate(), EC2INSTANCEIDSTOTERMINATE_BINDING);
      protocolMarshaller.marshall(instanceGroupModifyConfig.getShrinkPolicy(), SHRINKPOLICY_BINDING);
      protocolMarshaller.marshall(instanceGroupModifyConfig.getConfigurations(), CONFIGURATIONS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupModifyConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */