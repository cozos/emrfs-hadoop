package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsRequest;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class DescribeJobFlowsRequestMarshaller
{
  private static final MarshallingInfo<Date> CREATEDAFTER_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreatedAfter").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> CREATEDBEFORE_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreatedBefore").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<List> JOBFLOWIDS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("JobFlowIds").build();
  private static final MarshallingInfo<List> JOBFLOWSTATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("JobFlowStates").build();
  private static final DescribeJobFlowsRequestMarshaller instance = new DescribeJobFlowsRequestMarshaller();
  
  public static DescribeJobFlowsRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(DescribeJobFlowsRequest describeJobFlowsRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (describeJobFlowsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(describeJobFlowsRequest.getCreatedAfter(), CREATEDAFTER_BINDING);
      protocolMarshaller.marshall(describeJobFlowsRequest.getCreatedBefore(), CREATEDBEFORE_BINDING);
      protocolMarshaller.marshall(describeJobFlowsRequest.getJobFlowIds(), JOBFLOWIDS_BINDING);
      protocolMarshaller.marshall(describeJobFlowsRequest.getJobFlowStates(), JOBFLOWSTATES_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeJobFlowsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */