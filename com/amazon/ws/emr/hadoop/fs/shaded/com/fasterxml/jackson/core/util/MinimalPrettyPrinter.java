package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import java.io.IOException;
import java.io.Serializable;

public class MinimalPrettyPrinter
  implements PrettyPrinter, Serializable
{
  private static final long serialVersionUID = 1L;
  public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
  protected String _rootValueSeparator = " ";
  
  public MinimalPrettyPrinter()
  {
    this(" ");
  }
  
  public MinimalPrettyPrinter(String rootValueSeparator)
  {
    _rootValueSeparator = rootValueSeparator;
  }
  
  public void setRootValueSeparator(String sep)
  {
    _rootValueSeparator = sep;
  }
  
  public void writeRootValueSeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    if (_rootValueSeparator != null) {
      jg.writeRaw(_rootValueSeparator);
    }
  }
  
  public void writeStartObject(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw('{');
  }
  
  public void beforeObjectEntries(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {}
  
  public void writeObjectFieldValueSeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw(':');
  }
  
  public void writeObjectEntrySeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw(',');
  }
  
  public void writeEndObject(JsonGenerator jg, int nrOfEntries)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw('}');
  }
  
  public void writeStartArray(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw('[');
  }
  
  public void beforeArrayValues(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {}
  
  public void writeArrayValueSeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw(',');
  }
  
  public void writeEndArray(JsonGenerator jg, int nrOfValues)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw(']');
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.MinimalPrettyPrinter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */