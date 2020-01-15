package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceTypeSpecification;
import java.util.List;

@SdkInternalApi
public class InstanceTypeSpecificationMarshaller
{
  private static final MarshallingInfo<String> INSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceType").build();
  private static final MarshallingInfo<Integer> WEIGHTEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("WeightedCapacity").build();
  private static final MarshallingInfo<String> BIDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("BidPrice").build();
  private static final MarshallingInfo<Double> BIDPRICEASPERCENTAGEOFONDEMANDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BidPriceAsPercentageOfOnDemandPrice").build();
  private static final MarshallingInfo<List> CONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Configurations").build();
  private static final MarshallingInfo<List> EBSBLOCKDEVICES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsBlockDevices").build();
  private static final MarshallingInfo<Boolean> EBSOPTIMIZED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsOptimized").build();
  private static final InstanceTypeSpecificationMarshaller instance = new InstanceTypeSpecificationMarshaller();
  
  public static InstanceTypeSpecificationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceTypeSpecification instanceTypeSpecification, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceTypeSpecification == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceTypeSpecification.getInstanceType(), INSTANCETYPE_BINDING);
      protocolMarshaller.marshall(instanceTypeSpecification.getWeightedCapacity(), WEIGHTEDCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceTypeSpecification.getBidPrice(), BIDPRICE_BINDING);
      protocolMarshaller.marshall(instanceTypeSpecification.getBidPriceAsPercentageOfOnDemandPrice(), BIDPRICEASPERCENTAGEOFONDEMANDPRICE_BINDING);
      protocolMarshaller.marshall(instanceTypeSpecification.getConfigurations(), CONFIGURATIONS_BINDING);
      protocolMarshaller.marshall(instanceTypeSpecification.getEbsBlockDevices(), EBSBLOCKDEVICES_BINDING);
      protocolMarshaller.marshall(instanceTypeSpecification.getEbsOptimized(), EBSOPTIMIZED_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceTypeSpecificationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */