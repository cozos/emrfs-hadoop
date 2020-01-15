package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Ec2InstanceAttributes;
import java.util.List;

@SdkInternalApi
public class Ec2InstanceAttributesMarshaller
{
  private static final MarshallingInfo<String> EC2KEYNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Ec2KeyName").build();
  private static final MarshallingInfo<String> EC2SUBNETID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Ec2SubnetId").build();
  private static final MarshallingInfo<List> REQUESTEDEC2SUBNETIDS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RequestedEc2SubnetIds").build();
  private static final MarshallingInfo<String> EC2AVAILABILITYZONE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Ec2AvailabilityZone").build();
  private static final MarshallingInfo<List> REQUESTEDEC2AVAILABILITYZONES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RequestedEc2AvailabilityZones").build();
  private static final MarshallingInfo<String> IAMINSTANCEPROFILE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("IamInstanceProfile").build();
  private static final MarshallingInfo<String> EMRMANAGEDMASTERSECURITYGROUP_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EmrManagedMasterSecurityGroup").build();
  private static final MarshallingInfo<String> EMRMANAGEDSLAVESECURITYGROUP_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EmrManagedSlaveSecurityGroup").build();
  private static final MarshallingInfo<String> SERVICEACCESSSECURITYGROUP_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ServiceAccessSecurityGroup").build();
  private static final MarshallingInfo<List> ADDITIONALMASTERSECURITYGROUPS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AdditionalMasterSecurityGroups").build();
  private static final MarshallingInfo<List> ADDITIONALSLAVESECURITYGROUPS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AdditionalSlaveSecurityGroups").build();
  private static final Ec2InstanceAttributesMarshaller instance = new Ec2InstanceAttributesMarshaller();
  
  public static Ec2InstanceAttributesMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(Ec2InstanceAttributes ec2InstanceAttributes, ProtocolMarshaller protocolMarshaller)
  {
    if (ec2InstanceAttributes == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(ec2InstanceAttributes.getEc2KeyName(), EC2KEYNAME_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getEc2SubnetId(), EC2SUBNETID_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getRequestedEc2SubnetIds(), REQUESTEDEC2SUBNETIDS_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getEc2AvailabilityZone(), EC2AVAILABILITYZONE_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getRequestedEc2AvailabilityZones(), REQUESTEDEC2AVAILABILITYZONES_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getIamInstanceProfile(), IAMINSTANCEPROFILE_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getEmrManagedMasterSecurityGroup(), EMRMANAGEDMASTERSECURITYGROUP_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getEmrManagedSlaveSecurityGroup(), EMRMANAGEDSLAVESECURITYGROUP_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getServiceAccessSecurityGroup(), SERVICEACCESSSECURITYGROUP_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getAdditionalMasterSecurityGroups(), ADDITIONALMASTERSECURITYGROUPS_BINDING);
      protocolMarshaller.marshall(ec2InstanceAttributes.getAdditionalSlaveSecurityGroups(), ADDITIONALSLAVESECURITYGROUPS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.Ec2InstanceAttributesMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */