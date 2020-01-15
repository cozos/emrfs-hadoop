package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import software.amazon.ion.IonSystem;

class IonFactory
  extends JsonFactory
{
  private static final long serialVersionUID = 1L;
  private static final boolean SHOULD_CLOSE_READER_YES = true;
  private static final boolean SHOULD_CLOSE_READER_NO = false;
  private final transient IonSystem ionSystem;
  
  public IonFactory(IonSystem ionSystem)
  {
    this.ionSystem = ionSystem;
  }
  
  public JsonParser createParser(InputStream in)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(in), false);
  }
  
  public JsonParser createParser(byte[] data)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(data), false);
  }
  
  public JsonParser createParser(byte[] data, int offset, int length)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(data, offset, length), false);
  }
  
  public JsonParser createParser(char[] data)
    throws IOException, JsonParseException
  {
    throw new UnsupportedOperationException();
  }
  
  public JsonParser createParser(char[] data, int offset, int length)
    throws IOException, JsonParseException
  {
    throw new UnsupportedOperationException();
  }
  
  public JsonParser createParser(String data)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(data), false);
  }
  
  public JsonParser createParser(Reader data)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(data), false);
  }
  
  public JsonParser createParser(File data)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(new FileInputStream(data)), true);
  }
  
  public JsonParser createParser(URL data)
    throws IOException, JsonParseException
  {
    return new IonParser(ionSystem.newReader(data.openStream()), true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.json.IonFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */