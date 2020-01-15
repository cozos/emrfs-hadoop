package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class PersistableTransfer
{
  private static final ObjectMapper MAPPER = new ObjectMapper();
  
  public final String serialize()
  {
    return Jackson.toJsonString(this);
  }
  
  public final void serialize(OutputStream out)
    throws IOException
  {
    out.write(Jackson.toJsonString(this).getBytes(StringUtils.UTF8));
    out.flush();
  }
  
  public static <T extends PersistableTransfer> T deserializeFrom(InputStream in)
  {
    try
    {
      JsonNode tree = MAPPER.readTree(in);
      JsonNode pauseType = tree.get("pauseType");
      if (pauseType == null) {
        throw new IllegalArgumentException("Unrecognized serialized state");
      }
      type = pauseType.asText();
    }
    catch (Exception e)
    {
      String type;
      throw new IllegalArgumentException(e);
    }
    String type;
    JsonNode tree;
    Class<?> clazz;
    if ("download".equals(type))
    {
      clazz = PersistableDownload.class;
    }
    else
    {
      Class<?> clazz;
      if ("upload".equals(type)) {
        clazz = PersistableUpload.class;
      } else {
        throw new UnsupportedOperationException("Unsupported paused transfer type: " + type);
      }
    }
    try
    {
      Class<?> clazz;
      return (PersistableTransfer)MAPPER.treeToValue(tree, clazz);
    }
    catch (JsonProcessingException e)
    {
      throw new IllegalStateException(e);
    }
  }
  
  public static <T extends PersistableTransfer> T deserializeFrom(String serialized)
  {
    if (serialized == null) {
      return null;
    }
    ByteArrayInputStream byteStream = new ByteArrayInputStream(serialized.getBytes(StringUtils.UTF8));
    try
    {
      return deserializeFrom(byteStream);
    }
    finally
    {
      try
      {
        byteStream.close();
      }
      catch (IOException localIOException1) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableTransfer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */