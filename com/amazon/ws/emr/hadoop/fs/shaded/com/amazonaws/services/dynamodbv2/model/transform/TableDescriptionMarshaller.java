package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import java.util.Date;
import java.util.List;

@SdkInternalApi
public class TableDescriptionMarshaller
{
  private static final MarshallingInfo<List> ATTRIBUTEDEFINITIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributeDefinitions").build();
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<List> KEYSCHEMA_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySchema").build();
  private static final MarshallingInfo<String> TABLESTATUS_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TableStatus").build();
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDTHROUGHPUT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedThroughput").build();
  private static final MarshallingInfo<Long> TABLESIZEBYTES_BINDING = MarshallingInfo.builder(MarshallingType.LONG)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("TableSizeBytes").build();
  private static final MarshallingInfo<Long> ITEMCOUNT_BINDING = MarshallingInfo.builder(MarshallingType.LONG).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("ItemCount").build();
  private static final MarshallingInfo<String> TABLEARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableArn").build();
  private static final MarshallingInfo<String> TABLEID_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableId").build();
  private static final MarshallingInfo<StructuredPojo> BILLINGMODESUMMARY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BillingModeSummary").build();
  private static final MarshallingInfo<List> LOCALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LocalSecondaryIndexes").build();
  private static final MarshallingInfo<List> GLOBALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalSecondaryIndexes").build();
  private static final MarshallingInfo<StructuredPojo> STREAMSPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamSpecification").build();
  private static final MarshallingInfo<String> LATESTSTREAMLABEL_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LatestStreamLabel").build();
  private static final MarshallingInfo<String> LATESTSTREAMARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LatestStreamArn").build();
  private static final MarshallingInfo<StructuredPojo> RESTORESUMMARY_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("RestoreSummary").build();
  private static final MarshallingInfo<StructuredPojo> SSEDESCRIPTION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SSEDescription").build();
  private static final TableDescriptionMarshaller instance = new TableDescriptionMarshaller();
  
  public static TableDescriptionMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(TableDescription tableDescription, ProtocolMarshaller protocolMarshaller)
  {
    if (tableDescription == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(tableDescription.getAttributeDefinitions(), ATTRIBUTEDEFINITIONS_BINDING);
      protocolMarshaller.marshall(tableDescription.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(tableDescription.getKeySchema(), KEYSCHEMA_BINDING);
      protocolMarshaller.marshall(tableDescription.getTableStatus(), TABLESTATUS_BINDING);
      protocolMarshaller.marshall(tableDescription.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(tableDescription.getProvisionedThroughput(), PROVISIONEDTHROUGHPUT_BINDING);
      protocolMarshaller.marshall(tableDescription.getTableSizeBytes(), TABLESIZEBYTES_BINDING);
      protocolMarshaller.marshall(tableDescription.getItemCount(), ITEMCOUNT_BINDING);
      protocolMarshaller.marshall(tableDescription.getTableArn(), TABLEARN_BINDING);
      protocolMarshaller.marshall(tableDescription.getTableId(), TABLEID_BINDING);
      protocolMarshaller.marshall(tableDescription.getBillingModeSummary(), BILLINGMODESUMMARY_BINDING);
      protocolMarshaller.marshall(tableDescription.getLocalSecondaryIndexes(), LOCALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(tableDescription.getGlobalSecondaryIndexes(), GLOBALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(tableDescription.getStreamSpecification(), STREAMSPECIFICATION_BINDING);
      protocolMarshaller.marshall(tableDescription.getLatestStreamLabel(), LATESTSTREAMLABEL_BINDING);
      protocolMarshaller.marshall(tableDescription.getLatestStreamArn(), LATESTSTREAMARN_BINDING);
      protocolMarshaller.marshall(tableDescription.getRestoreSummary(), RESTORESUMMARY_BINDING);
      protocolMarshaller.marshall(tableDescription.getSSEDescription(), SSEDESCRIPTION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TableDescriptionMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */