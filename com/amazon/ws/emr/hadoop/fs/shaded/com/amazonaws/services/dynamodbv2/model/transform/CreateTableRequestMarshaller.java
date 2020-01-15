package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import java.util.List;

@SdkInternalApi
public class CreateTableRequestMarshaller
{
  private static final MarshallingInfo<List> ATTRIBUTEDEFINITIONS_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("AttributeDefinitions").build();
  private static final MarshallingInfo<String> TABLENAME_BINDING = MarshallingInfo.builder(MarshallingType.STRING).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("TableName").build();
  private static final MarshallingInfo<List> KEYSCHEMA_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("KeySchema").build();
  private static final MarshallingInfo<List> LOCALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("LocalSecondaryIndexes").build();
  private static final MarshallingInfo<List> GLOBALSECONDARYINDEXES_BINDING = MarshallingInfo.builder(MarshallingType.LIST)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("GlobalSecondaryIndexes").build();
  private static final MarshallingInfo<String> BILLINGMODE_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("BillingMode").build();
  private static final MarshallingInfo<StructuredPojo> PROVISIONEDTHROUGHPUT_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("ProvisionedThroughput").build();
  private static final MarshallingInfo<StructuredPojo> STREAMSPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("StreamSpecification").build();
  private static final MarshallingInfo<StructuredPojo> SSESPECIFICATION_BINDING = MarshallingInfo.builder(MarshallingType.STRUCTURED)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("SSESpecification").build();
  private static final MarshallingInfo<List> TAGS_BINDING = MarshallingInfo.builder(MarshallingType.LIST).marshallLocation(MarshallLocation.PAYLOAD)
    .marshallLocationName("Tags").build();
  private static final CreateTableRequestMarshaller instance = new CreateTableRequestMarshaller();
  
  public static CreateTableRequestMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(CreateTableRequest createTableRequest, ProtocolMarshaller protocolMarshaller)
  {
    if (createTableRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(createTableRequest.getAttributeDefinitions(), ATTRIBUTEDEFINITIONS_BINDING);
      protocolMarshaller.marshall(createTableRequest.getTableName(), TABLENAME_BINDING);
      protocolMarshaller.marshall(createTableRequest.getKeySchema(), KEYSCHEMA_BINDING);
      protocolMarshaller.marshall(createTableRequest.getLocalSecondaryIndexes(), LOCALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(createTableRequest.getGlobalSecondaryIndexes(), GLOBALSECONDARYINDEXES_BINDING);
      protocolMarshaller.marshall(createTableRequest.getBillingMode(), BILLINGMODE_BINDING);
      protocolMarshaller.marshall(createTableRequest.getProvisionedThroughput(), PROVISIONEDTHROUGHPUT_BINDING);
      protocolMarshaller.marshall(createTableRequest.getStreamSpecification(), STREAMSPECIFICATION_BINDING);
      protocolMarshaller.marshall(createTableRequest.getSSESpecification(), SSESPECIFICATION_BINDING);
      protocolMarshaller.marshall(createTableRequest.getTags(), TAGS_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CreateTableRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */