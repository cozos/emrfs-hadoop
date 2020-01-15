package com.amazon.ws.emr.hadoop.fs.s3.select;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ExpressionType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import java.util.Locale;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;

public class SelectObjectRequestGenerator
{
  public static SelectObjectContentRequest generateRequestFromConfiguration(String bucket, String key, Configuration selectOptions)
    throws IllegalArgumentException
  {
    Preconditions.checkArgument(StringUtils.isNotEmpty(bucket), "Bucket should not be empty");
    Preconditions.checkArgument(StringUtils.isNotEmpty(key), "Key should not be empty");
    Preconditions.checkNotNull(selectOptions, "SelectOptions should not be null");
    Preconditions.checkArgument(StringUtils.isNotEmpty(selectOptions.get("fs.s3.select.expression")), "Expression should not be empty");
    
    SelectObjectContentRequest request = new SelectObjectContentRequest();
    
    request.setBucketName(bucket);
    request.setKey(key);
    
    request.setExpressionType(ExpressionType.SQL);
    request.setExpression(selectOptions.get("fs.s3.select.expression"));
    
    String inputFormat = selectOptions.get("fs.s3.select.format", SelectConstants.DEFAULT_FORMAT);
    String outputFormat = selectOptions.get("fs.s3.select.output.format", inputFormat);
    
    request.setInputSerialization(
      getSerializationGenerator(inputFormat, selectOptions).inputSerialization());
    
    request.setOutputSerialization(
      getSerializationGenerator(outputFormat, selectOptions).outputSerialization());
    
    return request;
  }
  
  private static RequestSerializationGenerator getSerializationGenerator(String format, Configuration selectOptions)
  {
    RequestSerializationGenerator serializationGenerator;
    RequestSerializationGenerator serializationGenerator;
    switch (format.toUpperCase(Locale.ENGLISH))
    {
    case "CSV": 
      serializationGenerator = new CSVRequestSerializationGenerator(selectOptions);
      break;
    case "JSON": 
      serializationGenerator = new JSONRequestSerializationGenerator(selectOptions);
      break;
    default: 
      throw new UnsupportedOperationException("Select for format " + format + " is not supported. Currently only support " + StringUtils.join(SelectConstants.SUPPORTED_FORMAT.toArray(), ","));
    }
    RequestSerializationGenerator serializationGenerator;
    return serializationGenerator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.select.SelectObjectRequestGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */