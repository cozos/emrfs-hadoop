package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.Map;
import software.amazon.ion.IonReader;
import software.amazon.ion.IonSystem;
import software.amazon.ion.IonType;

@SdkInternalApi
public class IonErrorCodeParser
  implements ErrorCodeParser
{
  private static final Log log = LogFactory.getLog(IonErrorCodeParser.class);
  private static final String TYPE_PREFIX = "aws-type:";
  private static final String X_AMZN_REQUEST_ID_HEADER = "x-amzn-RequestId";
  private final IonSystem ionSystem;
  
  public IonErrorCodeParser(IonSystem ionSystem)
  {
    this.ionSystem = ionSystem;
  }
  
  public String parseErrorCode(HttpResponse response, JsonContent jsonContents)
  {
    IonReader reader = ionSystem.newReader(jsonContents.getRawContent());
    try
    {
      IonType type = reader.next();
      if (type != IonType.STRUCT) {
        throw new SdkClientException(String.format("Can only get error codes from structs (saw %s), request id %s", new Object[] { type, getRequestId(response) }));
      }
      boolean errorCodeSeen = false;
      String errorCode = null;
      String[] annotations = reader.getTypeAnnotations();
      for (String annotation : annotations) {
        if (annotation.startsWith("aws-type:"))
        {
          if (errorCodeSeen) {
            throw new SdkClientException(String.format("Multiple error code annotations found for request id %s", new Object[] { getRequestId(response) }));
          }
          errorCodeSeen = true;
          errorCode = annotation.substring("aws-type:".length());
        }
      }
      return errorCode;
    }
    finally
    {
      IOUtils.closeQuietly(reader, log);
    }
  }
  
  private static String getRequestId(HttpResponse response)
  {
    return (String)response.getHeaders().get("x-amzn-RequestId");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.IonErrorCodeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */