package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SecurityConfigurationSummary;
import java.util.Date;

@SdkInternalApi
public class SecurityConfigurationSummaryMarshaller
{
  private static final MarshallingInfo<String> NAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Name").build();
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final SecurityConfigurationSummaryMarshaller instance = new SecurityConfigurationSummaryMarshaller();
  
  public static SecurityConfigurationSummaryMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SecurityConfigurationSummary securityConfigurationSummary, ProtocolMarshaller protocolMarshaller)
  {
    if (securityConfigurationSummary == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(securityConfigurationSummary.getName(), NAME_BINDING);
      protocolMarshaller.marshall(securityConfigurationSummary.getCreationDateTime(), CREATIONDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SecurityConfigurationSummaryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */