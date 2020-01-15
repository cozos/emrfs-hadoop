package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

@SdkInternalApi
public class JsonContent
{
  private static final Log LOG = LogFactory.getLog(JsonContent.class);
  private final byte[] rawContent;
  private final JsonNode jsonNode;
  
  public static JsonContent createJsonContent(HttpResponse httpResponse, JsonFactory jsonFactory)
  {
    byte[] rawJsonContent = null;
    try
    {
      if (httpResponse.getContent() != null) {
        rawJsonContent = IOUtils.toByteArray(httpResponse.getContent());
      }
    }
    catch (Exception e)
    {
      LOG.debug("Unable to read HTTP response content", e);
    }
    return new JsonContent(rawJsonContent, new ObjectMapper(jsonFactory)
      .configure(JsonParser.Feature.ALLOW_COMMENTS, true));
  }
  
  public JsonContent(byte[] rawJsonContent, JsonNode jsonNode)
  {
    rawContent = rawJsonContent;
    this.jsonNode = jsonNode;
  }
  
  private JsonContent(byte[] rawJsonContent, ObjectMapper mapper)
  {
    rawContent = rawJsonContent;
    jsonNode = parseJsonContent(rawJsonContent, mapper);
  }
  
  private static JsonNode parseJsonContent(byte[] rawJsonContent, ObjectMapper mapper)
  {
    if (rawJsonContent == null) {
      return mapper.createObjectNode();
    }
    try
    {
      return mapper.readTree(rawJsonContent);
    }
    catch (Exception e)
    {
      LOG.debug("Unable to parse HTTP response content", e);
    }
    return mapper.createObjectNode();
  }
  
  public byte[] getRawContent()
  {
    return rawContent;
  }
  
  public JsonNode getJsonNode()
  {
    return jsonNode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */