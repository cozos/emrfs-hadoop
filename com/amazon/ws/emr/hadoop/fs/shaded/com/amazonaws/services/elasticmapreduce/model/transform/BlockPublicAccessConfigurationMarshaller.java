package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BlockPublicAccessConfiguration;
import java.util.List;

@SdkInternalApi
public class BlockPublicAccessConfigurationMarshaller
{
  private static final MarshallingInfo<Boolean> BLOCKPUBLICSECURITYGROUPRULES_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BlockPublicSecurityGroupRules").build();
  private static final MarshallingInfo<List> PERMITTEDPUBLICSECURITYGROUPRULERANGES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PermittedPublicSecurityGroupRuleRanges").build();
  private static final BlockPublicAccessConfigurationMarshaller instance = new BlockPublicAccessConfigurationMarshaller();
  
  public static BlockPublicAccessConfigurationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(BlockPublicAccessConfiguration blockPublicAccessConfiguration, ProtocolMarshaller protocolMarshaller)
  {
    if (blockPublicAccessConfiguration == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(blockPublicAccessConfiguration.getBlockPublicSecurityGroupRules(), BLOCKPUBLICSECURITYGROUPRULES_BINDING);
      protocolMarshaller.marshall(blockPublicAccessConfiguration.getPermittedPublicSecurityGroupRuleRanges(), PERMITTEDPUBLICSECURITYGROUPRULERANGES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BlockPublicAccessConfigurationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */