package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SourceTableDetails;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class SourceTableDetailsMarshaller
{
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<String> TABLEID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableId").build();
  private static final MarshallingInfo<String> TABLEARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableArn").build();
  private static final MarshallingInfo<Long> TABLESIZEBYTES_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TableSizeBytes").build();
  private static final MarshallingInfo<List> KEYSCHEMA_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySchema").build();
  private static final MarshallingInfo<Date> TABLECREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TableCreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDTHROUGHPUT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedThroughput").build();
  private static final MarshallingInfo<Long> ITEMCOUNT_BINDING = MarshallingInfo.builder(MarshallingType.LONG).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ItemCount").build();
  private static final MarshallingInfo<String> BILLINGMODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BillingMode").build();
  private static final SourceTableDetailsMarshaller instance = new SourceTableDetailsMarshaller();
  
  public static SourceTableDetailsMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(SourceTableDetails sourceTableDetails, ProtocolMarshaller protocolMarshaller)
  {
    if (sourceTableDetails == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(sourceTableDetails.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getTableId(), TABLEID_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getTableArn(), TABLEARN_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getTableSizeBytes(), TABLESIZEBYTES_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getKeySchema(), KEYSCHEMA_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getTableCreationDateTime(), TABLECREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getProvisionedThroughput(), PROVISIONEDTHROUGHPUT_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getItemCount(), ITEMCOUNT_BINDING);
      protocolMarshaller.marshall(sourceTableDetails.getBillingMode(), BILLINGMODE_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SourceTableDetailsMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */