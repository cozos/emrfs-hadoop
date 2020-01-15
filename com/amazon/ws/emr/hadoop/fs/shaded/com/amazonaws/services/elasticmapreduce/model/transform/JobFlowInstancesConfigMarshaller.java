package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig;
import java.util.List;

@SdkInternalApi
public class JobFlowInstancesConfigMarshaller
{
  private static final MarshallingInfo<String> MASTERINSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("MasterInstanceType").build();
  private static final MarshallingInfo<String> SLAVEINSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SlaveInstanceType").build();
  private static final MarshallingInfo<Integer> INSTANCECOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceCount").build();
  private static final MarshallingInfo<List> INSTANCEGROUPS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroups").build();
  private static final MarshallingInfo<List> INSTANCEFLEETS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceFleets").build();
  private static final MarshallingInfo<String> EC2KEYNAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Ec2KeyName").build();
  private static final MarshallingInfo<StructuredPojo> PLACEMENT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Placement").build();
  private static final MarshallingInfo<Boolean> KEEPJOBFLOWALIVEWHENNOSTEPS_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("KeepJobFlowAliveWhenNoSteps").build();
  private static final MarshallingInfo<Boolean> TERMINATIONPROTECTED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TerminationProtected").build();
  private static final MarshallingInfo<String> HADOOPVERSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("HadoopVersion").build();
  private static final MarshallingInfo<String> EC2SUBNETID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Ec2SubnetId").build();
  private static final MarshallingInfo<List> EC2SUBNETIDS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Ec2SubnetIds").build();
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
  private static final JobFlowInstancesConfigMarshaller instance = new JobFlowInstancesConfigMarshaller();
  
  public static JobFlowInstancesConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(JobFlowInstancesConfig jobFlowInstancesConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (jobFlowInstancesConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(jobFlowInstancesConfig.getMasterInstanceType(), MASTERINSTANCETYPE_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getSlaveInstanceType(), SLAVEINSTANCETYPE_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getInstanceCount(), INSTANCECOUNT_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getInstanceGroups(), INSTANCEGROUPS_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getInstanceFleets(), INSTANCEFLEETS_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getEc2KeyName(), EC2KEYNAME_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getPlacement(), PLACEMENT_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getKeepJobFlowAliveWhenNoSteps(), KEEPJOBFLOWALIVEWHENNOSTEPS_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getTerminationProtected(), TERMINATIONPROTECTED_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getHadoopVersion(), HADOOPVERSION_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getEc2SubnetId(), EC2SUBNETID_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getEc2SubnetIds(), EC2SUBNETIDS_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getEmrManagedMasterSecurityGroup(), EMRMANAGEDMASTERSECURITYGROUP_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getEmrManagedSlaveSecurityGroup(), EMRMANAGEDSLAVESECURITYGROUP_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getServiceAccessSecurityGroup(), SERVICEACCESSSECURITYGROUP_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getAdditionalMasterSecurityGroups(), ADDITIONALMASTERSECURITYGROUPS_BINDING);
      protocolMarshaller.marshall(jobFlowInstancesConfig.getAdditionalSlaveSecurityGroups(), ADDITIONALSLAVESECURITYGROUPS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowInstancesConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */