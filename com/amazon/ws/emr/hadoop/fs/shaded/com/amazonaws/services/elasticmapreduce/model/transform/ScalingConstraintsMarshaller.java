package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingConstraints;

@SdkInternalApi
public class ScalingConstraintsMarshaller
{
  private static final MarshallingInfo<Integer> MINCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("MinCapacity").build();
  private static final MarshallingInfo<Integer> MAXCAPACITY_BINDING = MarshallingInfo.builder(MarshallingType.INTEGER)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("MaxCapacity").build();
  private static final ScalingConstraintsMarshaller instance = new ScalingConstraintsMarshaller();
  
  public static ScalingConstraintsMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ScalingConstraints scalingConstraints, ProtocolMarshaller protocolMarshaller)
  {
    if (scalingConstraints == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(scalingConstraints.getMinCapacity(), MINCAPACITY_BINDING);
      protocolMarshaller.marshall(scalingConstraints.getMaxCapacity(), MAXCAPACITY_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingConstraintsMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */