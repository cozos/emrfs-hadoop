package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NotThreadSafe
@SdkProtectedApi
public class JsonClientMetadata
{
  private final List<JsonErrorShapeMetadata> errorsMetadata = new ArrayList();
  private String protocolVersion;
  private String contentTypeOverride;
  private boolean supportsCbor;
  private boolean supportsIon;
  private Class<? extends RuntimeException> baseServiceExceptionClass = AmazonServiceException.class;
  
  public JsonClientMetadata addErrorMetadata(JsonErrorShapeMetadata errorShapeMetadata)
  {
    errorsMetadata.add(errorShapeMetadata);
    return this;
  }
  
  public JsonClientMetadata addAllErrorMetadata(JsonErrorShapeMetadata... errorShapeMetadata)
  {
    Collections.addAll(errorsMetadata, errorShapeMetadata);
    return this;
  }
  
  public List<JsonErrorShapeMetadata> getErrorShapeMetadata()
  {
    return errorsMetadata;
  }
  
  public String getProtocolVersion()
  {
    return protocolVersion;
  }
  
  public JsonClientMetadata withProtocolVersion(String protocolVersion)
  {
    this.protocolVersion = protocolVersion;
    return this;
  }
  
  public String getContentTypeOverride()
  {
    return contentTypeOverride;
  }
  
  public JsonClientMetadata withContentTypeOverride(String contentType)
  {
    contentTypeOverride = contentType;
    return this;
  }
  
  public boolean isSupportsCbor()
  {
    return supportsCbor;
  }
  
  public JsonClientMetadata withSupportsCbor(boolean supportsCbor)
  {
    this.supportsCbor = supportsCbor;
    return this;
  }
  
  public Class<? extends RuntimeException> getBaseServiceExceptionClass()
  {
    return baseServiceExceptionClass;
  }
  
  public boolean isSupportsIon()
  {
    return supportsIon;
  }
  
  public JsonClientMetadata withSupportsIon(boolean supportsIon)
  {
    this.supportsIon = supportsIon;
    return this;
  }
  
  public JsonClientMetadata withBaseServiceExceptionClass(Class<? extends RuntimeException> baseServiceExceptionClass)
  {
    this.baseServiceExceptionClass = baseServiceExceptionClass;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonClientMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */