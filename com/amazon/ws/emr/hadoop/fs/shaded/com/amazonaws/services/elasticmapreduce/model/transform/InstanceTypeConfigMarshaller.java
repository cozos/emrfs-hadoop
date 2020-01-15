package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceTypeConfig;
import java.util.List;

@SdkInternalApi
public class InstanceTypeConfigMarshaller
{
  private static final MarshallingInfo<String> INSTANCETYPE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("InstanceType").build();
  private static final MarshallingInfo<Integer> WEIGHTEDCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("WeightedCapacity").build();
  private static final MarshallingInfo<String> BIDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("BidPrice").build();
  private static final MarshallingInfo<Double> BIDPRICEASPERCENTAGEOFONDEMANDPRICE_BINDING = MarshallingInfo.builder(MarshallingType.DOUBLE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BidPriceAsPercentageOfOnDemandPrice").build();
  private static final MarshallingInfo<StructuredPojo> EBSCONFIGURATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("EbsConfiguration").build();
  private static final MarshallingInfo<List> CONFIGURATIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("Configurations").build();
  private static final InstanceTypeConfigMarshaller instance = new InstanceTypeConfigMarshaller();
  
  public static InstanceTypeConfigMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceTypeConfig instanceTypeConfig, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceTypeConfig == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceTypeConfig.getInstanceType(), INSTANCETYPE_BINDING);
      protocolMarshaller.marshall(instanceTypeConfig.getWeightedCapacity(), WEIGHTEDCAPACITY_BINDING);
      protocolMarshaller.marshall(instanceTypeConfig.getBidPrice(), BIDPRICE_BINDING);
      protocolMarshaller.marshall(instanceTypeConfig.getBidPriceAsPercentageOfOnDemandPrice(), BIDPRICEASPERCENTAGEOFONDEMANDPRICE_BINDING);
      protocolMarshaller.marshall(instanceTypeConfig.getEbsConfiguration(), EBSCONFIGURATION_BINDING);
      protocolMarshaller.marshall(instanceTypeConfig.getConfigurations(), CONFIGURATIONS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceTypeConfigMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */