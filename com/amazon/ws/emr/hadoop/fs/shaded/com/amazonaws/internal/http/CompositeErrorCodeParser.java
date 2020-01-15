package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContent;
import java.util.Arrays;

@SdkInternalApi
public class CompositeErrorCodeParser
  implements ErrorCodeParser
{
  private final Iterable<ErrorCodeParser> parsers;
  
  public CompositeErrorCodeParser(Iterable<ErrorCodeParser> parsers)
  {
    this.parsers = parsers;
  }
  
  public CompositeErrorCodeParser(ErrorCodeParser... parsers)
  {
    this.parsers = Arrays.asList(parsers);
  }
  
  public String parseErrorCode(HttpResponse response, JsonContent jsonContent)
  {
    for (ErrorCodeParser parser : parsers)
    {
      String errorCode = parser.parseErrorCode(response, jsonContent);
      if (errorCode != null) {
        return errorCode;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.http.CompositeErrorCodeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */