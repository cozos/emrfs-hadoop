package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Partitions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MapperFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

@SdkInternalApi
public class PartitionsLoader
{
  public static final String PARTITIONS_RESOURCE_PATH = "com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/partitions/endpoints.json";
  public static final String PARTITIONS_OVERRIDE_RESOURCE_PATH = "com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/partitions/override/endpoints.json";
  private static final ObjectMapper mapper = new ObjectMapper()
    .disable(new MapperFeature[] { MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS })
    .disable(new MapperFeature[] { MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS })
    .enable(new JsonParser.Feature[] { JsonParser.Feature.ALLOW_COMMENTS })
    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  private final ClassLoader classLoader;
  
  public PartitionsLoader()
  {
    classLoader = PartitionsLoader.class.getClassLoader();
  }
  
  public PartitionMetadataProvider build()
  {
    InputStream stream = classLoader.getResourceAsStream("com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/partitions/override/endpoints.json");
    if (stream != null) {
      return new PartitionMetadataProvider(loadPartitionFromStream(stream, "com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/partitions/override/endpoints.json").getPartitions());
    }
    stream = classLoader.getResourceAsStream("com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/partitions/endpoints.json");
    if (stream == null) {
      throw new SdkClientException("Unable to load partition metadata from com/amazonaws/partitions/endpoints.json");
    }
    return new PartitionMetadataProvider(loadPartitionFromStream(stream, "com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/partitions/endpoints.json").getPartitions());
  }
  
  private Partitions loadPartitionFromStream(InputStream stream, String location)
  {
    try
    {
      return (Partitions)mapper.readValue(stream, Partitions.class);
    }
    catch (IOException e)
    {
      throw new SdkClientException("Error while loading partitions file from " + location, e);
    }
    finally
    {
      IOUtils.closeQuietly(stream, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.PartitionsLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */