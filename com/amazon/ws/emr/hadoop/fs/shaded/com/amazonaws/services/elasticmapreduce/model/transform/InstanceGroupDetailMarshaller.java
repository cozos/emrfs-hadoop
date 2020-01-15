package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupDetail;
import java.util.Date;

@SdkInternalApi
public class InstanceGroupDetailMarshaller
{
  private static final MarshallingInfo<String> INSTANCEGROUPID_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceGroupId").build();
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<String> MARKET_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Market").build();
  private static final MarshallingInfo<String> INSTANCEROLE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceRole").build();
  private static final MarshallingInfo<String> BIDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("BidPrice").build();
  private static final MarshallingInfo<String> INSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceType").build();
  private static final MarshallingInfo<Integer> INSTANCEREQUESTCOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceRequestCount").build();
  private static final MarshallingInfo<Integer> INSTANCERUNNINGCOUNT_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceRunningCount").build();
  private static final MarshallingInfo<String> STATE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("State").build();
  private static final MarshallingInfo<String> LASTSTATECHANGEREASON_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastStateChangeReason").build();
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> STARTDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StartDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> READYDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ReadyDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<Date> ENDDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EndDateTime").timestampFormat("unixTimestamp").build();
  private static final InstanceGroupDetailMarshaller instance = new InstanceGroupDetailMarshaller();
  
  public static InstanceGroupDetailMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceGroupDetail instanceGroupDetail, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceGroupDetail == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceGroupDetail.getInstanceGroupId(), INSTANCEGROUPID_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getName(), NAME_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getMarket(), MARKET_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getInstanceRole(), INSTANCEROLE_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getBidPrice(), BIDPRICE_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getInstanceType(), INSTANCETYPE_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getInstanceRequestCount(), INSTANCEREQUESTCOUNT_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getInstanceRunningCount(), INSTANCERUNNINGCOUNT_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getState(), STATE_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getLastStateChangeReason(), LASTSTATECHANGEREASON_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getStartDateTime(), STARTDATETIME_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getReadyDateTime(), READYDATETIME_BINDING);
      protocolMarshaller.marshall(instanceGroupDetail.getEndDateTime(), ENDDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupDetailMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */