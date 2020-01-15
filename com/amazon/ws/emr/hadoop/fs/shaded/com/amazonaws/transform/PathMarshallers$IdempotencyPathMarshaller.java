package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IdempotentUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;

class PathMarshallers$IdempotencyPathMarshaller
  implements PathMarshallers.PathMarshaller
{
  public String marshall(String resourcePath, String paramName, String pathValue)
  {
    if ((pathValue != null) && (pathValue.isEmpty())) {
      throw new IllegalArgumentException(paramName + " must not be empty. If not set a value will be auto generated");
    }
    return resourcePath.replace(String.format("{%s}", new Object[] { paramName }), 
      SdkHttpUtils.urlEncode(IdempotentUtils.resolveString(pathValue), false));
  }
  
  public String marshall(String resourcePath, String paramName, Integer pathValue)
  {
    throw new UnsupportedOperationException("Integer idempotency tokens not yet supported");
  }
  
  public String marshall(String resourcePath, String paramName, Long pathValue)
  {
    throw new UnsupportedOperationException("Long idempotency tokens not yet supported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.PathMarshallers.IdempotencyPathMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */