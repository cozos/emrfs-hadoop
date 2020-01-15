package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
class JsonContentTypeResolverImpl
  implements JsonContentTypeResolver
{
  private final String prefix;
  
  JsonContentTypeResolverImpl(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String resolveContentType(JsonClientMetadata metadata)
  {
    return 
      prefix + metadata.getProtocolVersion();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContentTypeResolverImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */