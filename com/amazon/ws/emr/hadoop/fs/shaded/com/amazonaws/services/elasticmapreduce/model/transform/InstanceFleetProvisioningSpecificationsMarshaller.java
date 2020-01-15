package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetProvisioningSpecifications;

@SdkInternalApi
public class InstanceFleetProvisioningSpecificationsMarshaller
{
  private static final MarshallingInfo<StructuredPojo> SPOTSPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SpotSpecification").build();
  private static final InstanceFleetProvisioningSpecificationsMarshaller instance = new InstanceFleetProvisioningSpecificationsMarshaller();
  
  public static InstanceFleetProvisioningSpecificationsMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(InstanceFleetProvisioningSpecifications instanceFleetProvisioningSpecifications, ProtocolMarshaller protocolMarshaller)
  {
    if (instanceFleetProvisioningSpecifications == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(instanceFleetProvisioningSpecifications.getSpotSpecification(), SPOTSPECIFICATION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetProvisioningSpecificationsMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */