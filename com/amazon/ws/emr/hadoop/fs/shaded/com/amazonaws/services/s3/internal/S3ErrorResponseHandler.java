package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponseHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class S3ErrorResponseHandler
  implements HttpResponseHandler<AmazonServiceException>
{
  private static final Log log = LogFactory.getLog(S3ErrorResponseHandler.class);
  
  private static enum S3ErrorTags
  {
    Error,  Message,  Code,  RequestId,  HostId;
    
    private S3ErrorTags() {}
  }
  
  public AmazonServiceException handle(HttpResponse httpResponse)
    throws XMLStreamException
  {
    AmazonServiceException exception = createException(httpResponse);
    exception.setHttpHeaders(httpResponse.getHeaders());
    return exception;
  }
  
  private AmazonServiceException createException(HttpResponse httpResponse)
    throws XMLStreamException
  {
    InputStream is = httpResponse.getContent();
    String xmlContent = null;
    if ((is == null) || 
      (httpResponse.getRequest().getHttpMethod() == HttpMethodName.HEAD)) {
      return createExceptionFromHeaders(httpResponse, null);
    }
    String content = null;
    try
    {
      content = IOUtils.toString(is);
    }
    catch (IOException ioe)
    {
      if (log.isDebugEnabled()) {
        log.debug("Failed in parsing the error response : ", ioe);
      }
      return createExceptionFromHeaders(httpResponse, null);
    }
    XMLStreamReader reader = XmlUtils.getXmlInputFactory().createXMLStreamReader(new ByteArrayInputStream(content.getBytes(StringUtils.UTF8)));
    try
    {
      int targetDepth = 0;
      AmazonS3ExceptionBuilder exceptionBuilder = new AmazonS3ExceptionBuilder();
      exceptionBuilder.setErrorResponseXml(content);
      exceptionBuilder.setStatusCode(httpResponse.getStatusCode());
      exceptionBuilder.setCloudFrontId((String)httpResponse.getHeaders().get("X-Amz-Cf-Id"));
      String bucketRegion = httpResponse.getHeader("x-amz-bucket-region");
      if (bucketRegion != null) {
        exceptionBuilder.addAdditionalDetail("x-amz-bucket-region", bucketRegion);
      }
      boolean hasErrorTagVisited = false;
      while (reader.hasNext())
      {
        int event = reader.next();
        switch (event)
        {
        case 1: 
          targetDepth++;
          String tagName = reader.getLocalName();
          if ((targetDepth == 1) && 
            (!S3ErrorTags.Error.toString().equals(tagName))) {
            return createExceptionFromHeaders(httpResponse, "Unable to parse error response. Error XML Not in proper format." + content);
          }
          if (S3ErrorTags.Error.toString().equals(tagName)) {
            hasErrorTagVisited = true;
          }
          break;
        case 4: 
          xmlContent = reader.getText();
          if (xmlContent != null) {
            xmlContent = xmlContent.trim();
          }
          break;
        case 2: 
          String tagName = reader.getLocalName();
          targetDepth--;
          if ((!hasErrorTagVisited) || (targetDepth > 1)) {
            return createExceptionFromHeaders(httpResponse, "Unable to parse error response. Error XML Not in proper format." + content);
          }
          if (S3ErrorTags.Message.toString().equals(tagName)) {
            exceptionBuilder.setErrorMessage(xmlContent);
          } else if (S3ErrorTags.Code.toString().equals(tagName)) {
            exceptionBuilder.setErrorCode(xmlContent);
          } else if (S3ErrorTags.RequestId.toString().equals(tagName)) {
            exceptionBuilder.setRequestId(xmlContent);
          } else if (S3ErrorTags.HostId.toString().equals(tagName)) {
            exceptionBuilder.setExtendedRequestId(xmlContent);
          } else {
            exceptionBuilder.addAdditionalDetail(tagName, xmlContent);
          }
          break;
        case 8: 
          return exceptionBuilder.build();
        }
      }
    }
    catch (Exception e)
    {
      if (log.isDebugEnabled()) {
        log.debug("Failed in parsing the error response : " + content, e);
      }
    }
    return createExceptionFromHeaders(httpResponse, content);
  }
  
  private AmazonS3Exception createExceptionFromHeaders(HttpResponse errorResponse, String errorResponseXml)
  {
    Map<String, String> headers = errorResponse.getHeaders();
    int statusCode = errorResponse.getStatusCode();
    AmazonS3ExceptionBuilder exceptionBuilder = new AmazonS3ExceptionBuilder();
    exceptionBuilder.setErrorMessage(errorResponse.getStatusText());
    exceptionBuilder.setErrorResponseXml(errorResponseXml);
    exceptionBuilder.setStatusCode(statusCode);
    exceptionBuilder
      .setExtendedRequestId((String)headers.get("x-amz-id-2"));
    exceptionBuilder.setRequestId((String)headers.get("x-amz-request-id"));
    exceptionBuilder.setCloudFrontId((String)headers.get("X-Amz-Cf-Id"));
    exceptionBuilder
      .setErrorCode(statusCode + " " + errorResponse.getStatusText());
    exceptionBuilder.addAdditionalDetail("x-amz-bucket-region", 
      (String)errorResponse.getHeaders().get("x-amz-bucket-region"));
    return exceptionBuilder.build();
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3ErrorResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */