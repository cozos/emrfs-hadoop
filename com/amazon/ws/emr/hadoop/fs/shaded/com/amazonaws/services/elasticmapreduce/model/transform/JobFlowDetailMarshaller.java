package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowDetail;
import java.util.List;

@SdkInternalApi
public class JobFlowDetailMarshaller
{
  private static final MarshallingInfo<String> JOBFLOWID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("JobFlowId").build();
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<String> LOGURI_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("LogUri").build();
  private static final MarshallingInfo<String> AMIVERSION_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AmiVersion").build();
  private static final MarshallingInfo<StructuredPojo> EXECUTIONSTATUSDETAIL_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ExecutionStatusDetail").build();
  private static final MarshallingInfo<StructuredPojo> INSTANCES_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Instances").build();
  private static final MarshallingInfo<List> STEPS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Steps").build();
  private static final MarshallingInfo<List> BOOTSTRAPACTIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BootstrapActions").build();
  private static final MarshallingInfo<List> SUPPORTEDPRODUCTS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SupportedProducts").build();
  private static final MarshallingInfo<Boolean> VISIBLETOALLUSERS_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("VisibleToAllUsers").build();
  private static final MarshallingInfo<String> JOBFLOWROLE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("JobFlowRole").build();
  private static final MarshallingInfo<String> SERVICEROLE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ServiceRole").build();
  private static final MarshallingInfo<String> AUTOSCALINGROLE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AutoScalingRole").build();
  private static final MarshallingInfo<String> SCALEDOWNBEHAVIOR_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ScaleDownBehavior").build();
  private static final JobFlowDetailMarshaller instance = new JobFlowDetailMarshaller();
  
  public static JobFlowDetailMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(JobFlowDetail jobFlowDetail, ProtocolMarshaller protocolMarshaller)
  {
    if (jobFlowDetail == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(jobFlowDetail.getJobFlowId(), JOBFLOWID_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getName(), NAME_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getLogUri(), LOGURI_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getAmiVersion(), AMIVERSION_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getExecutionStatusDetail(), EXECUTIONSTATUSDETAIL_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getInstances(), INSTANCES_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getSteps(), STEPS_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getBootstrapActions(), BOOTSTRAPACTIONS_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getSupportedProducts(), SUPPORTEDPRODUCTS_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getVisibleToAllUsers(), VISIBLETOALLUSERS_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getJobFlowRole(), JOBFLOWROLE_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getServiceRole(), SERVICEROLE_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getAutoScalingRole(), AUTOSCALINGROLE_BINDING);
      protocolMarshaller.marshall(jobFlowDetail.getScaleDownBehavior(), SCALEDOWNBEHAVIOR_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowDetailMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */