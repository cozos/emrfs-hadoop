package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.HeaderValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ContinuationEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.EndEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.RecordsEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEvent.StatsEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

@SdkInternalApi
public abstract class SelectObjectContentEventUnmarshaller
{
  public static SelectObjectContentEvent unmarshalMessage(Message message)
  {
    String messageType = getStringHeader(message, ":message-type");
    if ("error".equals(messageType)) {
      throw unmarshalErrorMessage(message);
    }
    if ("event".equals(messageType)) {
      return unmarshalEventMessage(message);
    }
    throw new SelectObjectContentEventException("Service returned unknown message type: " + messageType);
  }
  
  private static SelectObjectContentEventException unmarshalErrorMessage(Message message)
  {
    String errorCode = getStringHeader(message, ":error-code");
    String errorMessage = getStringHeader(message, ":error-message");
    SelectObjectContentEventException exception = new SelectObjectContentEventException("S3 returned an error: " + errorMessage + " (" + errorCode + ")");
    
    exception.setErrorCode(errorCode);
    exception.setErrorMessage(errorMessage);
    return exception;
  }
  
  private static SelectObjectContentEvent unmarshalEventMessage(Message message)
  {
    String eventType = getStringHeader(message, ":event-type");
    try
    {
      return forEventType(eventType).unmarshal(message);
    }
    catch (Exception e)
    {
      throw new SelectObjectContentEventException("Failed to read response event of type " + eventType, e);
    }
  }
  
  public static SelectObjectContentEventUnmarshaller forEventType(String eventType)
  {
    if ("Records".equals(eventType)) {
      return new RecordsEventUnmarshaller();
    }
    if ("Stats".equals(eventType)) {
      return new StatsEventUnmarshaller();
    }
    if ("Progress".equals(eventType)) {
      return new ProgressEventUnmarshaller();
    }
    if ("Cont".equals(eventType)) {
      return new ContinuationEventUnmarshaller();
    }
    if ("End".equals(eventType)) {
      return new EndEventUnmarshaller();
    }
    return new UnknownEventUnmarshaller();
  }
  
  private static String getStringHeader(Message message, String headerName)
  {
    HeaderValue header = (HeaderValue)message.getHeaders().get(headerName);
    if (header == null) {
      throw new SelectObjectContentEventException("Unexpected lack of '" + headerName + "' header from service.");
    }
    if (header.getType() != HeaderType.STRING) {
      throw new SelectObjectContentEventException("Unexpected non-string '" + headerName + "' header: " + header.getType());
    }
    return header.getString();
  }
  
  public abstract SelectObjectContentEvent unmarshal(Message paramMessage)
    throws Exception;
  
  public static class RecordsEventUnmarshaller
    extends SelectObjectContentEventUnmarshaller
  {
    public SelectObjectContentEvent.RecordsEvent unmarshal(Message message)
    {
      return new SelectObjectContentEvent.RecordsEvent().withPayload(ByteBuffer.wrap(message.getPayload()));
    }
  }
  
  public static class StatsEventUnmarshaller
    extends SelectObjectContentEventUnmarshaller
  {
    public SelectObjectContentEvent.StatsEvent unmarshal(Message message)
      throws Exception
    {
      StaxUnmarshallerContext context = SelectObjectContentEventUnmarshaller.payloadUnmarshaller(message);
      return new SelectObjectContentEvent.StatsEvent().withDetails(StatsStaxUnmarshaller.getInstance().unmarshall(context));
    }
  }
  
  public static class ProgressEventUnmarshaller
    extends SelectObjectContentEventUnmarshaller
  {
    public SelectObjectContentEvent.ProgressEvent unmarshal(Message message)
      throws Exception
    {
      StaxUnmarshallerContext context = SelectObjectContentEventUnmarshaller.payloadUnmarshaller(message);
      return new SelectObjectContentEvent.ProgressEvent().withDetails(ProgressStaxUnmarshaller.getInstance().unmarshall(context));
    }
  }
  
  public static class ContinuationEventUnmarshaller
    extends SelectObjectContentEventUnmarshaller
  {
    public SelectObjectContentEvent.ContinuationEvent unmarshal(Message message)
    {
      return new SelectObjectContentEvent.ContinuationEvent();
    }
  }
  
  public static class EndEventUnmarshaller
    extends SelectObjectContentEventUnmarshaller
  {
    public SelectObjectContentEvent.EndEvent unmarshal(Message message)
    {
      return new SelectObjectContentEvent.EndEvent();
    }
  }
  
  public static class UnknownEventUnmarshaller
    extends SelectObjectContentEventUnmarshaller
  {
    public SelectObjectContentEvent unmarshal(Message message)
    {
      return new SelectObjectContentEvent();
    }
  }
  
  private static StaxUnmarshallerContext payloadUnmarshaller(Message message)
    throws XMLStreamException
  {
    InputStream payloadStream = new ByteArrayInputStream(message.getPayload());
    XMLEventReader xmlEventReader = XmlUtils.getXmlInputFactory().createXMLEventReader(payloadStream);
    return new StaxUnmarshallerContext(xmlEventReader);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.SelectObjectContentEventUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */