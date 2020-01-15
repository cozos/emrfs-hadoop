package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
abstract interface JsonContentTypeResolver
{
  public static final JsonContentTypeResolver ION_BINARY = new JsonContentTypeResolverImpl("application/x-amz-ion-");
  public static final JsonContentTypeResolver ION_TEXT = new JsonContentTypeResolverImpl("text/x-amz-ion-");
  public static final JsonContentTypeResolver CBOR = new JsonContentTypeResolverImpl("application/x-amz-cbor-");
  public static final JsonContentTypeResolver JSON = new JsonContentTypeResolverImpl("application/x-amz-json-");
  
  public abstract String resolveContentType(JsonClientMetadata paramJsonClientMetadata);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.JsonContentTypeResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */