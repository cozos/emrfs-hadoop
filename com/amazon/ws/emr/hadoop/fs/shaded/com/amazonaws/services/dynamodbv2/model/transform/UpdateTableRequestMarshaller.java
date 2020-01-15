package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import java.util.List;

@SdkInternalApi
public class UpdateTableRequestMarshaller
{
  private static final MarshallingInfo<List> ATTRIBUTEDEFINITIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributeDefinitions").build();
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<String> BILLINGMODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BillingMode").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDTHROUGHPUT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedThroughput").build();
  private static final MarshallingInfo<List> GLOBALSECONDARYINDEXUPDATES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalSecondaryIndexUpdates").build();
  private static final MarshallingInfo<StructuredPojo> STREAMSPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamSpecification").build();
  private static final MarshallingInfo<StructuredPojo> SSESPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SSESpecification").build();
  private static final UpdateTableRequestMarshaller instance = new UpdateTableRequestMarshaller();
  
  public static UpdateTableRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(UpdateTableRequest updateTableRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (updateTableRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(updateTableRequest.getAttributeDefinitions(), ATTRIBUTEDEFINITIONS_BINDING);
      protocolMarshaller.marshall(updateTableRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(updateTableRequest.getBillingMode(), BILLINGMODE_BINDING);
      protocolMarshaller.marshall(updateTableRequest.getProvisionedThroughput(), PROVISIONEDTHROUGHPUT_BINDING);
      protocolMarshaller.marshall(updateTableRequest.getGlobalSecondaryIndexUpdates(), GLOBALSECONDARYINDEXUPDATES_BINDING);
      protocolMarshaller.marshall(updateTableRequest.getStreamSpecification(), STREAMSPECIFICATION_BINDING);
      protocolMarshaller.marshall(updateTableRequest.getSSESpecification(), SSESPECIFICATION_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateTableRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */