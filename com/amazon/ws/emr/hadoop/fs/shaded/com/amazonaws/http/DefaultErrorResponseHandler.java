package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

@SdkProtectedApi
public class DefaultErrorResponseHandler
  implements HttpResponseHandler<AmazonServiceException>
{
  private static final Log log = LogFactory.getLog(DefaultErrorResponseHandler.class);
  private List<Unmarshaller<AmazonServiceException, Node>> unmarshallerList;
  
  public DefaultErrorResponseHandler(List<Unmarshaller<AmazonServiceException, Node>> unmarshallerList)
  {
    this.unmarshallerList = unmarshallerList;
  }
  
  public AmazonServiceException handle(HttpResponse errorResponse)
    throws Exception
  {
    AmazonServiceException ase = createAse(errorResponse);
    if (ase == null) {
      throw new SdkClientException("Unable to unmarshall error response from service");
    }
    ase.setHttpHeaders(errorResponse.getHeaders());
    if (StringUtils.isNullOrEmpty(ase.getErrorCode())) {
      ase.setErrorCode(errorResponse.getStatusCode() + " " + errorResponse.getStatusText());
    }
    return ase;
  }
  
  private AmazonServiceException createAse(HttpResponse errorResponse)
    throws Exception
  {
    Document document = documentFromContent(errorResponse.getContent(), idString(errorResponse));
    for (Unmarshaller<AmazonServiceException, Node> unmarshaller : unmarshallerList)
    {
      AmazonServiceException ase = (AmazonServiceException)unmarshaller.unmarshall(document);
      if (ase != null)
      {
        ase.setStatusCode(errorResponse.getStatusCode());
        return ase;
      }
    }
    return null;
  }
  
  private Document documentFromContent(InputStream content, String idString)
    throws ParserConfigurationException, SAXException, IOException
  {
    try
    {
      return parseXml(contentToString(content, idString), idString);
    }
    catch (Exception e) {}
    return XpathUtils.documentFrom("<empty/>");
  }
  
  private String contentToString(InputStream content, String idString)
    throws Exception
  {
    try
    {
      return IOUtils.toString(content);
    }
    catch (Exception e)
    {
      log.debug(String.format("Unable to read input stream to string (%s)", new Object[] { idString }), e);
      throw e;
    }
  }
  
  private Document parseXml(String xml, String idString)
    throws Exception
  {
    try
    {
      return XpathUtils.documentFrom(xml);
    }
    catch (Exception e)
    {
      log.debug(String.format("Unable to parse HTTP response (%s) content to XML document '%s' ", new Object[] { idString, xml }), e);
      throw e;
    }
  }
  
  private String idString(HttpResponse errorResponse)
  {
    StringBuilder idString = new StringBuilder();
    try
    {
      if (errorResponse.getRequest().getHeaders().containsKey("amz-sdk-invocation-id")) {
        idString.append("Invocation Id:").append((String)errorResponse.getRequest().getHeaders().get("amz-sdk-invocation-id"));
      }
      if (errorResponse.getHeaders().containsKey("x-amzn-RequestId"))
      {
        if (idString.length() > 0) {
          idString.append(", ");
        }
        idString.append("Request Id:").append((String)errorResponse.getHeaders().get("x-amzn-RequestId"));
      }
    }
    catch (NullPointerException npe)
    {
      log.debug("Error getting Request or Invocation ID from response", npe);
    }
    return idString.length() > 0 ? idString.toString() : "Unknown";
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.DefaultErrorResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */