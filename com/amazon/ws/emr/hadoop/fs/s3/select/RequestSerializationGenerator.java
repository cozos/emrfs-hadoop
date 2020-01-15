package com.amazon.ws.emr.hadoop.fs.s3.select;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InputSerialization;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputSerialization;
import java.util.Locale;
import org.apache.hadoop.conf.Configuration;

abstract class RequestSerializationGenerator
{
  protected final Configuration selectOptions;
  
  RequestSerializationGenerator(Configuration selectOptions)
  {
    this.selectOptions = selectOptions;
  }
  
  InputSerialization inputSerialization()
  {
    InputSerialization inputSerialization = new InputSerialization();
    
    inputSerialization.setCompressionType(selectOptions
      .get("fs.s3.select.compression", "NONE")
      
      .toUpperCase(Locale.ENGLISH));
    return setInputFormat(inputSerialization);
  }
  
  OutputSerialization outputSerialization()
  {
    return setOutputFormat(new OutputSerialization());
  }
  
  protected abstract InputSerialization setInputFormat(InputSerialization paramInputSerialization);
  
  protected abstract OutputSerialization setOutputFormat(OutputSerialization paramOutputSerialization);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.select.RequestSerializationGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */