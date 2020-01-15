package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingInfo.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.MarshallingType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BlockPublicAccessConfigurationMetadata;
import java.util.Date;

@SdkInternalApi
public class BlockPublicAccessConfigurationMetadataMarshaller
{
  private static final MarshallingInfo<Date> CREATIONDATETIME_BINDING = MarshallingInfo.builder(MarshallingType.DATE)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreationDateTime").timestampFormat("unixTimestamp").build();
  private static final MarshallingInfo<String> CREATEDBYARN_BINDING = MarshallingInfo.builder(MarshallingType.STRING)
    .marshallLocation(MarshallLocation.PAYLOAD).marshallLocationName("CreatedByArn").build();
  private static final BlockPublicAccessConfigurationMetadataMarshaller instance = new BlockPublicAccessConfigurationMetadataMarshaller();
  
  public static BlockPublicAccessConfigurationMetadataMarshaller getInstance()
  {
    return instance;
  }
  
  public void marshall(BlockPublicAccessConfigurationMetadata blockPublicAccessConfigurationMetadata, ProtocolMarshaller protocolMarshaller)
  {
    if (blockPublicAccessConfigurationMetadata == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    try
    {
      protocolMarshaller.marshall(blockPublicAccessConfigurationMetadata.getCreationDateTime(), CREATIONDATETIME_BINDING);
      protocolMarshaller.marshall(blockPublicAccessConfigurationMetadata.getCreatedByArn(), CREATEDBYARN_BINDING);
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to marshall request to JSON: " + e.getMessage(), e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BlockPublicAccessConfigurationMetadataMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */