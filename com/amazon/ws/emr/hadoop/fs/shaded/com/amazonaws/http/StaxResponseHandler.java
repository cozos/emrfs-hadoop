package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.VoidStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.EmptyInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

public class StaxResponseHandler<T>
  implements HttpResponseHandler<AmazonWebServiceResponse<T>>
{
  private Unmarshaller<T, StaxUnmarshallerContext> responseUnmarshaller;
  private static final Log log = LogFactory.getLog("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.request");
  
  public StaxResponseHandler(Unmarshaller<T, StaxUnmarshallerContext> responseUnmarshaller)
  {
    this.responseUnmarshaller = responseUnmarshaller;
    if (this.responseUnmarshaller == null) {
      this.responseUnmarshaller = new VoidStaxUnmarshaller();
    }
  }
  
  public AmazonWebServiceResponse<T> handle(HttpResponse response)
    throws Exception
  {
    log.trace("Parsing service response XML");
    InputStream content = response.getContent();
    if (content == null) {
      content = new ByteArrayInputStream("<eof/>".getBytes(StringUtils.UTF8));
    } else if (((content instanceof SdkFilterInputStream)) && 
      ((((SdkFilterInputStream)content).getDelegateStream() instanceof EmptyInputStream))) {
      content = new ByteArrayInputStream("<eof/>".getBytes(StringUtils.UTF8));
    }
    try
    {
      eventReader = XmlUtils.getXmlInputFactory().createXMLEventReader(content);
    }
    catch (XMLStreamException e)
    {
      XMLEventReader eventReader;
      throw handleXmlStreamException(e);
    }
    try
    {
      AmazonWebServiceResponse<T> awsResponse = new AmazonWebServiceResponse();
      StaxUnmarshallerContext unmarshallerContext = new StaxUnmarshallerContext(eventReader, response.getHeaders());
      unmarshallerContext.registerMetadataExpression("ResponseMetadata/RequestId", 2, "AWS_REQUEST_ID");
      unmarshallerContext.registerMetadataExpression("requestId", 2, "AWS_REQUEST_ID");
      registerAdditionalMetadataExpressions(unmarshallerContext);
      
      T result = responseUnmarshaller.unmarshall(unmarshallerContext);
      awsResponse.setResult(result);
      
      Map<String, String> metadata = unmarshallerContext.getMetadata();
      Map<String, String> responseHeaders = response.getHeaders();
      if (responseHeaders != null)
      {
        if (responseHeaders.get("x-amzn-RequestId") != null) {
          metadata.put("AWS_REQUEST_ID", responseHeaders
            .get("x-amzn-RequestId"));
        }
        if (responseHeaders.get("x-amz-id-2") != null) {
          metadata.put("AWS_EXTENDED_REQUEST_ID", responseHeaders
            .get("x-amz-id-2"));
        }
      }
      awsResponse.setResponseMetadata(getResponseMetadata(metadata));
      
      log.trace("Done parsing service response");
      return awsResponse;
    }
    catch (XMLStreamException e)
    {
      throw handleXmlStreamException(e);
    }
    finally
    {
      try
      {
        XMLEventReader eventReader;
        eventReader.close();
      }
      catch (XMLStreamException e)
      {
        log.warn("Error closing xml parser", e);
      }
    }
  }
  
  private Exception handleXmlStreamException(XMLStreamException e)
    throws Exception
  {
    if ((e.getNestedException() instanceof IOException)) {
      return new IOException(e);
    }
    return e;
  }
  
  protected ResponseMetadata getResponseMetadata(Map<String, String> metadata)
  {
    return new ResponseMetadata(metadata);
  }
  
  protected void registerAdditionalMetadataExpressions(StaxUnmarshallerContext unmarshallerContext) {}
  
  public boolean needsConnectionLeftOpen()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.StaxResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */