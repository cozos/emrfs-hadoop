package com.amazon.ws.emr.hadoop.fs.s3.select;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CSVInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CSVOutput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.FileHeaderInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InputSerialization;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputSerialization;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;
import java.util.Locale;
import org.apache.hadoop.conf.Configuration;

final class CSVRequestSerializationGenerator
  extends RequestSerializationGenerator
{
  CSVRequestSerializationGenerator(Configuration selectOptions)
  {
    super(selectOptions);
  }
  
  protected InputSerialization setInputFormat(InputSerialization inputSerialization)
  {
    CSVInput csvInput = new CSVInput();
    
    String header = selectOptions.get("fs.s3.select.csv.header");
    if (StringUtils.isNotEmpty(header))
    {
      FileHeaderInfo fileHeaderInfo = FileHeaderInfo.fromValue(header.toUpperCase(Locale.ENGLISH));
      csvInput.setFileHeaderInfo(fileHeaderInfo);
    }
    csvInput.setComments(
      RequestGenerateUtils.unescapeJava(selectOptions
      .get("fs.s3.select.csv.comment.marker", "#")));
    
    csvInput.setFieldDelimiter(
      RequestGenerateUtils.unescapeJava(selectOptions
      .get("fs.s3.select.csv.field.delimiter", ",")));
    
    csvInput.setRecordDelimiter(
      RequestGenerateUtils.unescapeJava(selectOptions
      .get("fs.s3.select.csv.record.delimiter", "\n")));
    
    csvInput.setQuoteCharacter(
      RequestGenerateUtils.unescapeJava(selectOptions
      .get("fs.s3.select.csv.quote.character", "\"")));
    
    csvInput.setQuoteEscapeCharacter(
      RequestGenerateUtils.unescapeJava(selectOptions
      .get("fs.s3.select.csv.quote.escape.character", "\"")));
    
    return inputSerialization.withCsv(csvInput);
  }
  
  protected OutputSerialization setOutputFormat(OutputSerialization outputSerialization)
  {
    CSVOutput csvOutput = new CSVOutput();
    
    String outputFieldDelimiter = selectOptions.get("fs.s3.select.csv.output.field.delimiter", selectOptions
    
      .get("fs.s3.select.csv.field.delimiter", ","));
    
    csvOutput.setFieldDelimiter(RequestGenerateUtils.unescapeJava(outputFieldDelimiter));
    
    String outputRecordDelimiter = selectOptions.get("fs.s3.select.csv.output.record.delimiter", selectOptions
    
      .get("fs.s3.select.csv.record.delimiter", "\n"));
    
    csvOutput.setRecordDelimiter(RequestGenerateUtils.unescapeJava(outputRecordDelimiter));
    
    String outputQuoteChar = selectOptions.get("fs.s3.select.csv.output.quote.character", selectOptions
    
      .get("fs.s3.select.csv.quote.character", "\""));
    
    csvOutput.setQuoteCharacter(RequestGenerateUtils.unescapeJava(outputQuoteChar));
    
    String outputQuoteEscapeChar = selectOptions.get("fs.s3.select.csv.output.quote.escape.character", selectOptions
    
      .get("fs.s3.select.csv.quote.escape.character", "\""));
    
    csvOutput.setQuoteEscapeCharacter(RequestGenerateUtils.unescapeJava(outputQuoteEscapeChar));
    
    String outputQuoteFields = selectOptions.get("fs.s3.select.csv.output.quote.fields", "ASNEEDED");
    
    csvOutput.setQuoteFields(outputQuoteFields);
    
    return outputSerialization.withCsv(csvOutput);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.select.CSVRequestSerializationGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */