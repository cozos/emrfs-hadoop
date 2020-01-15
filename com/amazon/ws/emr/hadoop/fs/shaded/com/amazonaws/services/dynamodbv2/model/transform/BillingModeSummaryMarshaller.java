package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BillingModeSummary;
import java.util.Date;

@SdkInternalApi
public class BillingModeSummaryMarshaller
{
  private static final MarshallingInfo<String> BILLINGMODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BillingMode").build();
  private static final MarshallingInfo<Date> LASTUPDATETOPAYPERREQUESTDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LastUpdateToPayPerRequestDateTime").timestampFormat("unixTimestamp").build();
  private static final BillingModeSummaryMarshaller instance = new BillingModeSummaryMarshaller();
  
  public static BillingModeSummaryMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(BillingModeSummary billingModeSummary, ProtocolMarshaller protocolMarshaller)
  {
    if (billingModeSummary == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(billingModeSummary.getBillingMode(), BILLINGMODE_BINDING);
      protocolMarshaller.marshall(billingModeSummary.getLastUpdateToPayPerRequestDateTime(), LASTUPDATETOPAYPERREQUESTDATETIME_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BillingModeSummaryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */