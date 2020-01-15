package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonGeneratorDelegate
  extends JsonGenerator
{
  protected JsonGenerator delegate;
  protected boolean delegateCopyMethods;
  
  public JsonGeneratorDelegate(JsonGenerator d)
  {
    this(d, true);
  }
  
  public JsonGeneratorDelegate(JsonGenerator d, boolean delegateCopyMethods)
  {
    delegate = d;
    this.delegateCopyMethods = delegateCopyMethods;
  }
  
  public Object getCurrentValue()
  {
    return delegate.getCurrentValue();
  }
  
  public void setCurrentValue(Object v)
  {
    delegate.setCurrentValue(v);
  }
  
  public JsonGenerator getDelegate()
  {
    return delegate;
  }
  
  public ObjectCodec getCodec()
  {
    return delegate.getCodec();
  }
  
  public JsonGenerator setCodec(ObjectCodec oc)
  {
    delegate.setCodec(oc);
    return this;
  }
  
  public void setSchema(FormatSchema schema)
  {
    delegate.setSchema(schema);
  }
  
  public FormatSchema getSchema()
  {
    return delegate.getSchema();
  }
  
  public Version version()
  {
    return delegate.version();
  }
  
  public Object getOutputTarget()
  {
    return delegate.getOutputTarget();
  }
  
  public int getOutputBuffered()
  {
    return delegate.getOutputBuffered();
  }
  
  public boolean canUseSchema(FormatSchema schema)
  {
    return delegate.canUseSchema(schema);
  }
  
  public boolean canWriteTypeId()
  {
    return delegate.canWriteTypeId();
  }
  
  public boolean canWriteObjectId()
  {
    return delegate.canWriteObjectId();
  }
  
  public boolean canWriteBinaryNatively()
  {
    return delegate.canWriteBinaryNatively();
  }
  
  public boolean canOmitFields()
  {
    return delegate.canOmitFields();
  }
  
  public JsonGenerator enable(JsonGenerator.Feature f)
  {
    delegate.enable(f);
    return this;
  }
  
  public JsonGenerator disable(JsonGenerator.Feature f)
  {
    delegate.disable(f);
    return this;
  }
  
  public boolean isEnabled(JsonGenerator.Feature f)
  {
    return delegate.isEnabled(f);
  }
  
  public int getFeatureMask()
  {
    return delegate.getFeatureMask();
  }
  
  public JsonGenerator setFeatureMask(int mask)
  {
    delegate.setFeatureMask(mask);
    return this;
  }
  
  public JsonGenerator setPrettyPrinter(PrettyPrinter pp)
  {
    delegate.setPrettyPrinter(pp);
    return this;
  }
  
  public PrettyPrinter getPrettyPrinter()
  {
    return delegate.getPrettyPrinter();
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    delegate.useDefaultPrettyPrinter();
    return this;
  }
  
  public JsonGenerator setHighestNonEscapedChar(int charCode)
  {
    delegate.setHighestNonEscapedChar(charCode);
    return this;
  }
  
  public int getHighestEscapedChar()
  {
    return delegate.getHighestEscapedChar();
  }
  
  public CharacterEscapes getCharacterEscapes()
  {
    return delegate.getCharacterEscapes();
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes esc)
  {
    delegate.setCharacterEscapes(esc);
    return this;
  }
  
  public JsonGenerator setRootValueSeparator(SerializableString sep)
  {
    delegate.setRootValueSeparator(sep);
    return this;
  }
  
  public void writeStartArray()
    throws IOException
  {
    delegate.writeStartArray();
  }
  
  public void writeStartArray(int size)
    throws IOException
  {
    delegate.writeStartArray(size);
  }
  
  public void writeEndArray()
    throws IOException
  {
    delegate.writeEndArray();
  }
  
  public void writeStartObject()
    throws IOException
  {
    delegate.writeStartObject();
  }
  
  public void writeEndObject()
    throws IOException
  {
    delegate.writeEndObject();
  }
  
  public void writeFieldName(String name)
    throws IOException
  {
    delegate.writeFieldName(name);
  }
  
  public void writeFieldName(SerializableString name)
    throws IOException
  {
    delegate.writeFieldName(name);
  }
  
  public void writeString(String text)
    throws IOException
  {
    delegate.writeString(text);
  }
  
  public void writeString(char[] text, int offset, int len)
    throws IOException
  {
    delegate.writeString(text, offset, len);
  }
  
  public void writeString(SerializableString text)
    throws IOException
  {
    delegate.writeString(text);
  }
  
  public void writeRawUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    delegate.writeRawUTF8String(text, offset, length);
  }
  
  public void writeUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    delegate.writeUTF8String(text, offset, length);
  }
  
  public void writeRaw(String text)
    throws IOException
  {
    delegate.writeRaw(text);
  }
  
  public void writeRaw(String text, int offset, int len)
    throws IOException
  {
    delegate.writeRaw(text, offset, len);
  }
  
  public void writeRaw(SerializableString raw)
    throws IOException
  {
    delegate.writeRaw(raw);
  }
  
  public void writeRaw(char[] text, int offset, int len)
    throws IOException
  {
    delegate.writeRaw(text, offset, len);
  }
  
  public void writeRaw(char c)
    throws IOException
  {
    delegate.writeRaw(c);
  }
  
  public void writeRawValue(String text)
    throws IOException
  {
    delegate.writeRawValue(text);
  }
  
  public void writeRawValue(String text, int offset, int len)
    throws IOException
  {
    delegate.writeRawValue(text, offset, len);
  }
  
  public void writeRawValue(char[] text, int offset, int len)
    throws IOException
  {
    delegate.writeRawValue(text, offset, len);
  }
  
  public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len)
    throws IOException
  {
    delegate.writeBinary(b64variant, data, offset, len);
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
    throws IOException
  {
    return delegate.writeBinary(b64variant, data, dataLength);
  }
  
  public void writeNumber(short v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(int v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(long v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(BigInteger v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(double v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(float v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(BigDecimal v)
    throws IOException
  {
    delegate.writeNumber(v);
  }
  
  public void writeNumber(String encodedValue)
    throws IOException, UnsupportedOperationException
  {
    delegate.writeNumber(encodedValue);
  }
  
  public void writeBoolean(boolean state)
    throws IOException
  {
    delegate.writeBoolean(state);
  }
  
  public void writeNull()
    throws IOException
  {
    delegate.writeNull();
  }
  
  public void writeOmittedField(String fieldName)
    throws IOException
  {
    delegate.writeOmittedField(fieldName);
  }
  
  public void writeObjectId(Object id)
    throws IOException
  {
    delegate.writeObjectId(id);
  }
  
  public void writeObjectRef(Object id)
    throws IOException
  {
    delegate.writeObjectRef(id);
  }
  
  public void writeTypeId(Object id)
    throws IOException
  {
    delegate.writeTypeId(id);
  }
  
  public void writeObject(Object pojo)
    throws IOException, JsonProcessingException
  {
    if (delegateCopyMethods)
    {
      delegate.writeObject(pojo);
      return;
    }
    if (pojo == null)
    {
      writeNull();
    }
    else
    {
      if (getCodec() != null)
      {
        getCodec().writeValue(this, pojo);
        return;
      }
      _writeSimpleObject(pojo);
    }
  }
  
  public void writeTree(TreeNode rootNode)
    throws IOException
  {
    if (delegateCopyMethods)
    {
      delegate.writeTree(rootNode);
      return;
    }
    if (rootNode == null)
    {
      writeNull();
    }
    else
    {
      if (getCodec() == null) {
        throw new IllegalStateException("No ObjectCodec defined");
      }
      getCodec().writeValue(this, rootNode);
    }
  }
  
  public void copyCurrentEvent(JsonParser jp)
    throws IOException
  {
    if (delegateCopyMethods) {
      delegate.copyCurrentEvent(jp);
    } else {
      super.copyCurrentEvent(jp);
    }
  }
  
  public void copyCurrentStructure(JsonParser jp)
    throws IOException
  {
    if (delegateCopyMethods) {
      delegate.copyCurrentStructure(jp);
    } else {
      super.copyCurrentStructure(jp);
    }
  }
  
  public JsonStreamContext getOutputContext()
  {
    return delegate.getOutputContext();
  }
  
  public void flush()
    throws IOException
  {
    delegate.flush();
  }
  
  public void close()
    throws IOException
  {
    delegate.close();
  }
  
  public boolean isClosed()
  {
    return delegate.isClosed();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.JsonGeneratorDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */