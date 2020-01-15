package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString;
import java.io.IOException;
import java.io.Serializable;

public class DefaultPrettyPrinter
  implements PrettyPrinter, Instantiatable<DefaultPrettyPrinter>, Serializable
{
  private static final long serialVersionUID = 1L;
  public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
  protected Indenter _arrayIndenter = FixedSpaceIndenter.instance;
  protected Indenter _objectIndenter = DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
  protected final SerializableString _rootSeparator;
  protected boolean _spacesInObjectEntries = true;
  protected transient int _nesting = 0;
  
  public DefaultPrettyPrinter()
  {
    this(DEFAULT_ROOT_VALUE_SEPARATOR);
  }
  
  public DefaultPrettyPrinter(String rootSeparator)
  {
    this(rootSeparator == null ? null : new SerializedString(rootSeparator));
  }
  
  public DefaultPrettyPrinter(SerializableString rootSeparator)
  {
    _rootSeparator = rootSeparator;
  }
  
  public DefaultPrettyPrinter(DefaultPrettyPrinter base)
  {
    this(base, _rootSeparator);
  }
  
  public DefaultPrettyPrinter(DefaultPrettyPrinter base, SerializableString rootSeparator)
  {
    _arrayIndenter = _arrayIndenter;
    _objectIndenter = _objectIndenter;
    _spacesInObjectEntries = _spacesInObjectEntries;
    _nesting = _nesting;
    
    _rootSeparator = rootSeparator;
  }
  
  public DefaultPrettyPrinter withRootSeparator(SerializableString rootSeparator)
  {
    if ((_rootSeparator == rootSeparator) || ((rootSeparator != null) && (rootSeparator.equals(_rootSeparator)))) {
      return this;
    }
    return new DefaultPrettyPrinter(this, rootSeparator);
  }
  
  public DefaultPrettyPrinter withRootSeparator(String rootSeparator)
  {
    return withRootSeparator(rootSeparator == null ? null : new SerializedString(rootSeparator));
  }
  
  public void indentArraysWith(Indenter i)
  {
    _arrayIndenter = (i == null ? NopIndenter.instance : i);
  }
  
  public void indentObjectsWith(Indenter i)
  {
    _objectIndenter = (i == null ? NopIndenter.instance : i);
  }
  
  @Deprecated
  public void spacesInObjectEntries(boolean b)
  {
    _spacesInObjectEntries = b;
  }
  
  public DefaultPrettyPrinter withArrayIndenter(Indenter i)
  {
    if (i == null) {
      i = NopIndenter.instance;
    }
    if (_arrayIndenter == i) {
      return this;
    }
    DefaultPrettyPrinter pp = new DefaultPrettyPrinter(this);
    _arrayIndenter = i;
    return pp;
  }
  
  public DefaultPrettyPrinter withObjectIndenter(Indenter i)
  {
    if (i == null) {
      i = NopIndenter.instance;
    }
    if (_objectIndenter == i) {
      return this;
    }
    DefaultPrettyPrinter pp = new DefaultPrettyPrinter(this);
    _objectIndenter = i;
    return pp;
  }
  
  public DefaultPrettyPrinter withSpacesInObjectEntries()
  {
    return _withSpaces(true);
  }
  
  public DefaultPrettyPrinter withoutSpacesInObjectEntries()
  {
    return _withSpaces(false);
  }
  
  protected DefaultPrettyPrinter _withSpaces(boolean state)
  {
    if (_spacesInObjectEntries == state) {
      return this;
    }
    DefaultPrettyPrinter pp = new DefaultPrettyPrinter(this);
    _spacesInObjectEntries = state;
    return pp;
  }
  
  public DefaultPrettyPrinter createInstance()
  {
    return new DefaultPrettyPrinter(this);
  }
  
  public void writeRootValueSeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    if (_rootSeparator != null) {
      jg.writeRaw(_rootSeparator);
    }
  }
  
  public void writeStartObject(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw('{');
    if (!_objectIndenter.isInline()) {
      _nesting += 1;
    }
  }
  
  public void beforeObjectEntries(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    _objectIndenter.writeIndentation(jg, _nesting);
  }
  
  public void writeObjectFieldValueSeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    if (_spacesInObjectEntries) {
      jg.writeRaw(" : ");
    } else {
      jg.writeRaw(':');
    }
  }
  
  public void writeObjectEntrySeparator(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    jg.writeRaw(',');
    _objectIndenter.writeIndentation(jg, _nesting);
  }
  
  public void writeEndObject(JsonGenerator jg, int nrOfEntries)
    throws IOException, JsonGenerationException
  {
    if (!_objectIndenter.isInline()) {
      _nesting -= 1;
    }
    if (nrOfEntries > 0) {
      _objectIndenter.writeIndentation(jg, _nesting);
    } else {
      jg.writeRaw(' ');
    }
    jg.writeRaw('}');
  }
  
  public void writeStartArray(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting += 1;
    }
    jg.writeRaw('[');
  }
  
  public void beforeArrayValues(JsonGenerator jg)
    throws IOException, JsonGenerationException
  {
    _arrayIndenter.writeIndentation(jg, _nesting);
  }
  
  public void writeArrayValueSeparator(JsonGenerator gen)
    throws IOException
  {
    gen.writeRaw(',');
    _arrayIndenter.writeIndentation(gen, _nesting);
  }
  
  public void writeEndArray(JsonGenerator gen, int nrOfValues)
    throws IOException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting -= 1;
    }
    if (nrOfValues > 0) {
      _arrayIndenter.writeIndentation(gen, _nesting);
    } else {
      gen.writeRaw(' ');
    }
    gen.writeRaw(']');
  }
  
  public static abstract interface Indenter
  {
    public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException;
    
    public abstract boolean isInline();
  }
  
  public static class NopIndenter
    implements DefaultPrettyPrinter.Indenter, Serializable
  {
    public static final NopIndenter instance = new NopIndenter();
    
    public void writeIndentation(JsonGenerator jg, int level)
      throws IOException
    {}
    
    public boolean isInline()
    {
      return true;
    }
  }
  
  public static class FixedSpaceIndenter
    extends DefaultPrettyPrinter.NopIndenter
  {
    public static final FixedSpaceIndenter instance = new FixedSpaceIndenter();
    
    public void writeIndentation(JsonGenerator jg, int level)
      throws IOException
    {
      jg.writeRaw(' ');
    }
    
    public boolean isInline()
    {
      return true;
    }
  }
  
  @Deprecated
  public static class Lf2SpacesIndenter
    extends DefaultIndenter
  {
    @Deprecated
    public static final Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
    
    @Deprecated
    public Lf2SpacesIndenter()
    {
      super(DefaultIndenter.SYS_LF);
    }
    
    @Deprecated
    public Lf2SpacesIndenter(String lf)
    {
      super(lf);
    }
    
    public Lf2SpacesIndenter withLinefeed(String lf)
    {
      if (lf.equals(getEol())) {
        return this;
      }
      return new Lf2SpacesIndenter(lf);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.DefaultPrettyPrinter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */