package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IdempotentUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class PathMarshallers
{
  public static final PathMarshaller NON_GREEDY = new NonGreedyPathMarshaller(null);
  public static final PathMarshaller GREEDY = new GreedyPathMarshaller(null);
  public static final PathMarshaller IDEMPOTENCY = new IdempotencyPathMarshaller(null);
  
  public static abstract interface PathMarshaller
  {
    public abstract String marshall(String paramString1, String paramString2, String paramString3);
    
    public abstract String marshall(String paramString1, String paramString2, Integer paramInteger);
    
    public abstract String marshall(String paramString1, String paramString2, Long paramLong);
  }
  
  private static class NonGreedyPathMarshaller
    implements PathMarshallers.PathMarshaller
  {
    public String marshall(String resourcePath, String paramName, String pathValue)
    {
      ValidationUtils.assertStringNotEmpty(pathValue, paramName);
      return resourcePath.replace(String.format("{%s}", new Object[] { paramName }), SdkHttpUtils.urlEncode(pathValue, false));
    }
    
    public String marshall(String resourcePath, String paramName, Integer pathValue)
    {
      ValidationUtils.assertNotNull(pathValue, paramName);
      return marshall(resourcePath, paramName, StringUtils.fromInteger(pathValue));
    }
    
    public String marshall(String resourcePath, String paramName, Long pathValue)
    {
      ValidationUtils.assertNotNull(pathValue, paramName);
      return marshall(resourcePath, paramName, StringUtils.fromLong(pathValue));
    }
  }
  
  private static class GreedyPathMarshaller
    implements PathMarshallers.PathMarshaller
  {
    public String marshall(String resourcePath, String paramName, String pathValue)
    {
      ValidationUtils.assertStringNotEmpty(pathValue, paramName);
      return resourcePath.replace(String.format("{%s+}", new Object[] { paramName }), PathMarshallers.trimLeadingSlash(pathValue));
    }
    
    public String marshall(String resourcePath, String paramName, Integer pathValue)
    {
      ValidationUtils.assertNotNull(pathValue, paramName);
      return marshall(resourcePath, paramName, StringUtils.fromInteger(pathValue));
    }
    
    public String marshall(String resourcePath, String paramName, Long pathValue)
    {
      ValidationUtils.assertNotNull(pathValue, paramName);
      return marshall(resourcePath, paramName, StringUtils.fromLong(pathValue));
    }
  }
  
  private static class IdempotencyPathMarshaller
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
  
  private static String trimLeadingSlash(String value)
  {
    if (value.startsWith("/")) {
      return value.replaceFirst("/", "");
    }
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.PathMarshallers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */