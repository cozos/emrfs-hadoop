package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoverySpecification;

@SdkInternalApi
public class PointInTimeRecoverySpecificationMarshaller
{
  private static final MarshallingInfo<Boolean> POINTINTIMERECOVERYENABLED_BINDING = MarshallingInfo.builder(MarshallingType.BOOLEAN)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PointInTimeRecoveryEnabled").build();
  private static final PointInTimeRecoverySpecificationMarshaller instance = new PointInTimeRecoverySpecificationMarshaller();
  
  public static PointInTimeRecoverySpecificationMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(PointInTimeRecoverySpecification pointInTimeRecoverySpecification, ProtocolMarshaller protocolMarshaller)
  {
    if (pointInTimeRecoverySpecification == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(pointInTimeRecoverySpecification.getPointInTimeRecoveryEnabled(), POINTINTIMERECOVERYENABLED_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoverySpecificationMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */