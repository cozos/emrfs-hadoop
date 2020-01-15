package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringGeneratorDelegate
  extends JsonGeneratorDelegate
{
  protected TokenFilter rootFilter;
  protected boolean _allowMultipleMatches;
  protected boolean _includePath;
  @Deprecated
  protected boolean _includeImmediateParent = false;
  protected TokenFilterContext _filterContext;
  protected TokenFilter _itemFilter;
  protected int _matchCount;
  
  public FilteringGeneratorDelegate(JsonGenerator d, TokenFilter f, boolean includePath, boolean allowMultipleMatches)
  {
    super(d, false);
    rootFilter = f;
    
    _itemFilter = f;
    _filterContext = TokenFilterContext.createRootContext(f);
    _includePath = includePath;
    _allowMultipleMatches = allowMultipleMatches;
  }
  
  public TokenFilter getFilter()
  {
    return rootFilter;
  }
  
  public JsonStreamContext getFilterContext()
  {
    return _filterContext;
  }
  
  public int getMatchCount()
  {
    return _matchCount;
  }
  
  public JsonStreamContext getOutputContext()
  {
    return _filterContext;
  }
  
  public void writeStartArray()
    throws IOException
  {
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray();
      return;
    }
    _itemFilter = _filterContext.checkValue(_itemFilter);
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL) {
      _itemFilter = _itemFilter.filterStartArray();
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _checkParentPath();
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray();
    }
    else
    {
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, false);
    }
  }
  
  public void writeStartArray(int size)
    throws IOException
  {
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray(size);
      return;
    }
    _itemFilter = _filterContext.checkValue(_itemFilter);
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL) {
      _itemFilter = _itemFilter.filterStartArray();
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _checkParentPath();
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray(size);
    }
    else
    {
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, false);
    }
  }
  
  public void writeEndArray()
    throws IOException
  {
    _filterContext = _filterContext.closeArray(delegate);
    if (_filterContext != null) {
      _itemFilter = _filterContext.getFilter();
    }
  }
  
  public void writeStartObject()
    throws IOException
  {
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildObjectContext(_itemFilter, false);
      return;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _filterContext = _filterContext.createChildObjectContext(_itemFilter, true);
      delegate.writeStartObject();
      return;
    }
    TokenFilter f = _filterContext.checkValue(_itemFilter);
    if (f == null) {
      return;
    }
    if (f != TokenFilter.INCLUDE_ALL) {
      f = f.filterStartObject();
    }
    if (f == TokenFilter.INCLUDE_ALL)
    {
      _checkParentPath();
      _filterContext = _filterContext.createChildObjectContext(f, true);
      delegate.writeStartObject();
    }
    else
    {
      _filterContext = _filterContext.createChildObjectContext(f, false);
    }
  }
  
  public void writeEndObject()
    throws IOException
  {
    _filterContext = _filterContext.closeObject(delegate);
    if (_filterContext != null) {
      _itemFilter = _filterContext.getFilter();
    }
  }
  
  public void writeFieldName(String name)
    throws IOException
  {
    TokenFilter state = _filterContext.setFieldName(name);
    if (state == null)
    {
      _itemFilter = null;
      return;
    }
    if (state == TokenFilter.INCLUDE_ALL)
    {
      _itemFilter = state;
      delegate.writeFieldName(name);
      return;
    }
    state = state.includeProperty(name);
    _itemFilter = state;
    if (state == TokenFilter.INCLUDE_ALL) {
      _checkPropertyParentPath();
    }
  }
  
  public void writeFieldName(SerializableString name)
    throws IOException
  {
    TokenFilter state = _filterContext.setFieldName(name.getValue());
    if (state == null)
    {
      _itemFilter = null;
      return;
    }
    if (state == TokenFilter.INCLUDE_ALL)
    {
      _itemFilter = state;
      delegate.writeFieldName(name);
      return;
    }
    state = state.includeProperty(name.getValue());
    _itemFilter = state;
    if (state == TokenFilter.INCLUDE_ALL) {
      _checkPropertyParentPath();
    }
  }
  
  public void writeString(String value)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeString(value))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeString(value);
  }
  
  public void writeString(char[] text, int offset, int len)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      String value = new String(text, offset, len);
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeString(value))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeString(text, offset, len);
  }
  
  public void writeString(SerializableString value)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeString(value.getValue()))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeString(value);
  }
  
  public void writeRawUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRawUTF8String(text, offset, length);
    }
  }
  
  public void writeUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeUTF8String(text, offset, length);
    }
  }
  
  public void writeRaw(String text)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text);
    }
  }
  
  public void writeRaw(String text, int offset, int len)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text);
    }
  }
  
  public void writeRaw(SerializableString text)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text);
    }
  }
  
  public void writeRaw(char[] text, int offset, int len)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text, offset, len);
    }
  }
  
  public void writeRaw(char c)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(c);
    }
  }
  
  public void writeRawValue(String text)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text);
    }
  }
  
  public void writeRawValue(String text, int offset, int len)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text, offset, len);
    }
  }
  
  public void writeRawValue(char[] text, int offset, int len)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(text, offset, len);
    }
  }
  
  public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len)
    throws IOException
  {
    if (_checkBinaryWrite()) {
      delegate.writeBinary(b64variant, data, offset, len);
    }
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
    throws IOException
  {
    if (_checkBinaryWrite()) {
      return delegate.writeBinary(b64variant, data, dataLength);
    }
    return -1;
  }
  
  public void writeNumber(short v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(int v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(long v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(BigInteger v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(double v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(float v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(BigDecimal v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNumber(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(v);
  }
  
  public void writeNumber(String encodedValue)
    throws IOException, UnsupportedOperationException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeRawValue())) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNumber(encodedValue);
  }
  
  public void writeBoolean(boolean v)
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeBoolean(v))) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeBoolean(v);
  }
  
  public void writeNull()
    throws IOException
  {
    if (_itemFilter == null) {
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL)
    {
      TokenFilter state = _filterContext.checkValue(_itemFilter);
      if (state == null) {
        return;
      }
      if ((state != TokenFilter.INCLUDE_ALL) && 
        (!state.includeNull())) {
        return;
      }
      _checkParentPath();
    }
    delegate.writeNull();
  }
  
  public void writeOmittedField(String fieldName)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeOmittedField(fieldName);
    }
  }
  
  public void writeObjectId(Object id)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeObjectId(id);
    }
  }
  
  public void writeObjectRef(Object id)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeObjectRef(id);
    }
  }
  
  public void writeTypeId(Object id)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeTypeId(id);
    }
  }
  
  protected void _checkParentPath()
    throws IOException
  {
    _matchCount += 1;
    if (_includePath) {
      _filterContext.writePath(delegate);
    }
    if (!_allowMultipleMatches) {
      _filterContext.skipParentChecks();
    }
  }
  
  protected void _checkPropertyParentPath()
    throws IOException
  {
    _matchCount += 1;
    if (_includePath) {
      _filterContext.writePath(delegate);
    } else if (_includeImmediateParent) {
      _filterContext.writeImmediatePath(delegate);
    }
    if (!_allowMultipleMatches) {
      _filterContext.skipParentChecks();
    }
  }
  
  protected boolean _checkBinaryWrite()
    throws IOException
  {
    if (_itemFilter == null) {
      return false;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL) {
      return true;
    }
    if (_itemFilter.includeBinary())
    {
      _checkParentPath();
      return true;
    }
    return false;
  }
  
  protected boolean _checkRawValueWrite()
    throws IOException
  {
    if (_itemFilter == null) {
      return false;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL) {
      return true;
    }
    if (_itemFilter.includeRawValue())
    {
      _checkParentPath();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */