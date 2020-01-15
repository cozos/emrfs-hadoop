package com.amazon.ws.emr.hadoop.fs.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonObject;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.StatusLine;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.ResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpGet;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.CloseableHttpClient;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.HttpClients;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YarnClient
  implements Closeable
{
  private static final Logger LOG = LoggerFactory.getLogger(YarnClient.class);
  private final Configuration configuration;
  private final String resourceManagerEndpoint;
  private final CloseableHttpClient httpClient;
  
  public YarnClient(Configuration conf)
  {
    configuration = conf;
    resourceManagerEndpoint = ("http://" + configuration.get("yarn.resourcemanager.webapp.address"));
    httpClient = HttpClients.createDefault();
  }
  
  @VisibleForTesting
  public YarnClient(Configuration conf, CloseableHttpClient httpClient)
  {
    configuration = conf;
    resourceManagerEndpoint = ("http://" + configuration.get("yarn.resourcemanager.webapp.address"));
    this.httpClient = httpClient;
  }
  
  private String makeRestApiRequest(final String url)
  {
    try
    {
      HttpGet request = new HttpGet(url);
      ResponseHandler<String> responseHandler = new ResponseHandler()
      {
        public String handleResponse(HttpResponse response)
          throws IOException
        {
          int status = response.getStatusLine().getStatusCode();
          if (status != 200)
          {
            YarnClient.LOG.warn("Received failed response for {} (HTTP error code {})", url, Integer.valueOf(status));
            return "";
          }
          HttpEntity entity = response.getEntity();
          return entity != null ? EntityUtils.toString(entity) : "";
        }
      };
      return (String)httpClient.execute(request, responseHandler);
    }
    catch (IOException e)
    {
      LOG.warn("The GET request failed for the URL {} ", url, e);
    }
    return "";
  }
  
  private JsonObject parseJsonResponse(String response)
  {
    if (!StringUtils.isEmpty(response)) {
      try
      {
        JsonParser parser = new JsonParser();
        return parser.parse(response).getAsJsonObject();
      }
      catch (JsonParseException|IllegalStateException e)
      {
        LOG.warn("Unable to parse the response {} to JSON", response, e);
      }
    }
    return null;
  }
  
  public String getApplicationTypeById(String applicationId)
  {
    String applicationType = "OTHER";
    if (!Strings.isNullOrEmpty(applicationId))
    {
      String response = makeRestApiRequest(resourceManagerEndpoint + "/ws/v1/cluster/apps/" + applicationId);
      if (!response.isEmpty())
      {
        JsonObject jsonObject = parseJsonResponse(response);
        if ((jsonObject != null) && (jsonObject.has("app")))
        {
          JsonElement appElement = jsonObject.get("app");
          if (appElement.isJsonObject())
          {
            JsonObject app = appElement.getAsJsonObject();
            if (app.has("applicationType")) {
              applicationType = app.get("applicationType").getAsString();
            }
          }
        }
        if (applicationType.equals("OTHER"))
        {
          LOG.warn("The parsed JSON does not contain ApplicationType.");
          LOG.warn(response);
        }
      }
    }
    return applicationType;
  }
  
  public void close()
    throws IOException
  {
    httpClient.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.client.YarnClient
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */