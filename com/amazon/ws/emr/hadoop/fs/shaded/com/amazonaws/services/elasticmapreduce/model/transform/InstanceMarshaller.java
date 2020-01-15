package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Instance;
import java.util.List;

@SdkInternalApi
public class InstanceMarshaller
{
  private static final MarshallingInfo<String> ID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Id").build();
  private static final MarshallingInfo<String> EC2INSTANCEID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Ec2InstanceId").build();
  private static final MarshallingInfo<String> PUBLICDNSNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PublicDnsName").build();
  private static final MarshallingInfo<String> PUBLICIPADDRESS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PublicIpAddress").build();
  private static final MarshallingInfo<String> PRIVATEDNSNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PrivateDnsName").build();
  private static final MarshallingInfo<String> PRIVATEIPADDRESS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PrivateIpAddress").build();
  private static final MarshallingInfo<StructuredPojo> STATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Status").build();
  private static final MarshallingInfo<String> INSTANCEGROUPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupId").build();
  private static final MarshallingInfo<String> INSTANCEFLEETID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleetId").build();
  private static final MarshallingInfo<String> MARKET_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Market").build();
  private static final MarshallingInfo<String> INSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceType").build();
  private static final MarshallingInfo<List> EBSVOLUMES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("EbsVolumes").build();
  private static final InstanceMarshaller instance = new InstanceMarshaller();
  
  public static InstanceMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Instance instance, ProtocolMarshaller protocolMarshaller)
  {
    if (instance == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instance.getId(), ID_BINDING);
      protocolMarshaller.marshall(instance.getEc2InstanceId(), EC2INSTANCEID_BINDING);
      protocolMarshaller.marshall(instance.getPublicDnsName(), PUBLICDNSNAME_BINDING);
      protocolMarshaller.marshall(instance.getPublicIpAddress(), PUBLICIPADDRESS_BINDING);
      protocolMarshaller.marshall(instance.getPrivateDnsName(), PRIVATEDNSNAME_BINDING);
      protocolMarshaller.marshall(instance.getPrivateIpAddress(), PRIVATEIPADDRESS_BINDING);
      protocolMarshaller.marshall(instance.getStatus(), STATUS_BINDING);
      protocolMarshaller.marshall(instance.getInstanceGroupId(), INSTANCEGROUPID_BINDING);
      protocolMarshaller.marshall(instance.getInstanceFleetId(), INSTANCEFLEETID_BINDING);
      protocolMarshaller.marshall(instance.getMarket(), MARKET_BINDING);
      protocolMarshaller.marshall(instance.getInstanceType(), INSTANCETYPE_BINDING);
      protocolMarshaller.marshall(instance.getEbsVolumes(), EBSVOLUMES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */