package com.amazon.ws.emr.hadoop.fs.s3.select;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InputSerialization;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONOutput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputSerialization;
import java.util.Locale;
import org.apache.hadoop.conf.Configuration;

final class JSONRequestSerializationGenerator
  extends RequestSerializationGenerator
{
  JSONRequestSerializationGenerator(Configuration selectOptions)
  {
    super(selectOptions);
  }
  
  protected InputSerialization setInputFormat(InputSerialization inputSerialization)
  {
    JSONInput jsonInput = new JSONInput();
    
    jsonInput.setType(selectOptions.get("fs.s3.select.json.input.jsontype", SelectConstants.DEFAULT_INPUT_JSON_TYPE)
      .toUpperCase(Locale.ENGLISH));
    
    return inputSerialization.withJson(jsonInput);
  }
  
  protected OutputSerialization setOutputFormat(OutputSerialization outputSerialization)
  {
    JSONOutput jsonOutput = new JSONOutput();
    
    String outputRecordDelimiter = selectOptions.get("fs.s3.select.json.output.record.delimiter", "\n");
    
    jsonOutput.setRecordDelimiter(RequestGenerateUtils.unescapeJava(outputRecordDelimiter));
    
    return outputSerialization.withJson(jsonOutput);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.select.JSONRequestSerializationGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */