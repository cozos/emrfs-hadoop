package com.amazon.ws.emr.hadoop.fs.s3.select;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;
import java.util.Set;

public final class SelectConstants
{
  public static final String FS_S3_SELECT_PREFIX = "fs.s3.select.";
  public static final String FORMAT = "fs.s3.select.format";
  public static final String OUTPUT_FORMAT = "fs.s3.select.output.format";
  public static final String DEFAULT_FORMAT = Format.CSV.name();
  public static final Set<String> SUPPORTED_FORMAT = ImmutableSet.of(Format.CSV.name(), Format.JSON
    .name());
  public static final String SELECT_EXPRESSION = "fs.s3.select.expression";
  private static final String FIELD_DELIMITER_SUB = "field.delimiter";
  private static final String RECORD_DELIMITER_SUB = "record.delimiter";
  private static final String QUOTE_CHARACTER_SUB = "quote.character";
  private static final String QUOTE_ESCAPE_CHARACTER_SUB = "quote.escape.character";
  public static final String DEFAULT_FIELD_DELIMITER = ",";
  public static final String DEFAULT_RECORD_DELIMITER = "\n";
  public static final String DEFAULT_QUOTE_CHARACTER = "\"";
  public static final String DEFAULT_QUOTE_ESCAPE_CHARACTER = "\"";
  public static final String COMPRESSION = "fs.s3.select.compression";
  public static final String DEFAULT_COMPRESSION = "NONE";
  private static final String FS_S3_SELECT_CSV_PREFIX = "fs.s3.select.csv.";
  public static final String CSV_HEADER = "fs.s3.select.csv.header";
  public static final String CSV_COMMENT_MARKER = "fs.s3.select.csv.comment.marker";
  public static final String DEFAULT_COMMENT_MARKER = "#";
  public static final String CSV_FIELD_DELIMITER = "fs.s3.select.csv.field.delimiter";
  public static final String CSV_RECORD_DELIMITER = "fs.s3.select.csv.record.delimiter";
  public static final String CSV_QUOTE_CHARACTER = "fs.s3.select.csv.quote.character";
  public static final String CSV_QUOTE_ESCAPE_CHARACTER = "fs.s3.select.csv.quote.escape.character";
  private static final String CSV_FS_S3_SELECT_OUTPUT_PREFIX = "fs.s3.select.csv.output.";
  public static final String CSV_OUTPUT_FIELD_DELIMITER = "fs.s3.select.csv.output.field.delimiter";
  public static final String CSV_OUTPUT_RECORD_DELIMITER = "fs.s3.select.csv.output.record.delimiter";
  public static final String CSV_OUTPUT_QUOTE_CHARACTER = "fs.s3.select.csv.output.quote.character";
  public static final String CSV_OUTPUT_QUOTE_ESCAPE_CHARACTER = "fs.s3.select.csv.output.quote.escape.character";
  public static final String CSV_OUTPUT_QUOTE_FIELDS = "fs.s3.select.csv.output.quote.fields";
  public static final String DEFAULT_OUTPUT_QUOTE_FIELDS = "ASNEEDED";
  private static final String FS_S3_SELECT_JSON_PREFIX = "fs.s3.select.json.";
  public static final String JSON_INPUT_JSON_TYPE = "fs.s3.select.json.input.jsontype";
  public static final String DEFAULT_INPUT_JSON_TYPE = JSONType.DOCUMENT.toString();
  public static final String JSON_OUTPUT_RECORD_DELIMITER = "fs.s3.select.json.output.record.delimiter";
  public static final Set<String> s3selectKeys = ImmutableSet.of("fs.s3.select.expression", "fs.s3.select.format", "fs.s3.select.output.format", "fs.s3.select.compression", "fs.s3.select.csv.header", "fs.s3.select.csv.comment.marker", new String[] { "fs.s3.select.csv.field.delimiter", "fs.s3.select.csv.record.delimiter", "fs.s3.select.csv.quote.character", "fs.s3.select.csv.quote.escape.character", "fs.s3.select.csv.output.field.delimiter", "fs.s3.select.csv.output.record.delimiter", "fs.s3.select.csv.output.quote.character", "fs.s3.select.csv.output.quote.escape.character", "fs.s3.select.json.input.jsontype", "fs.s3.select.json.output.record.delimiter" });
  
  public static enum Format
  {
    CSV,  JSON;
    
    private Format() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.select.SelectConstants
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */