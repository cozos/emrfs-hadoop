package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ContinuousBackupsDescription;

@SdkInternalApi
public class ContinuousBackupsDescriptionMarshaller
{
  private static final MarshallingInfo<String> CONTINUOUSBACKUPSSTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ContinuousBackupsStatus").build();
  private static final MarshallingInfo<StructuredPojo> POINTINTIMERECOVERYDESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("PointInTimeRecoveryDescription").build();
  private static final ContinuousBackupsDescriptionMarshaller instance = new ContinuousBackupsDescriptionMarshaller();
  
  public static ContinuousBackupsDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(ContinuousBackupsDescription continuousBackupsDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (continuousBackupsDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(continuousBackupsDescription.getContinuousBackupsStatus(), CONTINUOUSBACKUPSSTATUS_BINDING);
      protocolMarshaller.marshall(continuousBackupsDescription.getPointInTimeRecoveryDescription(), POINTINTIMERECOVERYDESCRIPTION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ContinuousBackupsDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */