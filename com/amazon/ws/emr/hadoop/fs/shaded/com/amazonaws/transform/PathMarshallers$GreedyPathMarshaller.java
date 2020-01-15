package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

class PathMarshallers$GreedyPathMarshaller
  implements PathMarshallers.PathMarshaller
{
  public String marshall(String resourcePath, String paramName, String pathValue)
  {
    ValidationUtils.assertStringNotEmpty(pathValue, paramName);
    return resourcePath.replace(String.format("{%s+}", new Object[] { paramName }), PathMarshallers.access$300(pathValue));
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.PathMarshallers.GreedyPathMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */