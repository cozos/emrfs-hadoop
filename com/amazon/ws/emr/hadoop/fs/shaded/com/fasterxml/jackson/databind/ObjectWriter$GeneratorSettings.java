package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.Instantiatable;
import java.io.Serializable;

public final class ObjectWriter$GeneratorSettings
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final GeneratorSettings empty = new GeneratorSettings(null, null, null, null);
  public final PrettyPrinter prettyPrinter;
  public final FormatSchema schema;
  public final CharacterEscapes characterEscapes;
  public final SerializableString rootValueSeparator;
  
  public ObjectWriter$GeneratorSettings(PrettyPrinter pp, FormatSchema sch, CharacterEscapes esc, SerializableString rootSep)
  {
    prettyPrinter = pp;
    schema = sch;
    characterEscapes = esc;
    rootValueSeparator = rootSep;
  }
  
  public GeneratorSettings with(PrettyPrinter pp)
  {
    if (pp == null) {
      pp = ObjectWriter.NULL_PRETTY_PRINTER;
    }
    return pp == prettyPrinter ? this : new GeneratorSettings(pp, schema, characterEscapes, rootValueSeparator);
  }
  
  public GeneratorSettings with(FormatSchema sch)
  {
    return schema == sch ? this : new GeneratorSettings(prettyPrinter, sch, characterEscapes, rootValueSeparator);
  }
  
  public GeneratorSettings with(CharacterEscapes esc)
  {
    return characterEscapes == esc ? this : new GeneratorSettings(prettyPrinter, schema, esc, rootValueSeparator);
  }
  
  public GeneratorSettings withRootValueSeparator(String sep)
  {
    if (sep == null)
    {
      if (rootValueSeparator == null) {
        return this;
      }
    }
    else if (sep.equals(rootValueSeparator)) {
      return this;
    }
    return new GeneratorSettings(prettyPrinter, schema, characterEscapes, sep == null ? null : new SerializedString(sep));
  }
  
  public GeneratorSettings withRootValueSeparator(SerializableString sep)
  {
    if (sep == null)
    {
      if (rootValueSeparator == null) {
        return this;
      }
    }
    else if ((rootValueSeparator != null) && (sep.getValue().equals(rootValueSeparator.getValue()))) {
      return this;
    }
    return new GeneratorSettings(prettyPrinter, schema, characterEscapes, sep);
  }
  
  public void initialize(JsonGenerator gen)
  {
    PrettyPrinter pp = prettyPrinter;
    if (prettyPrinter != null) {
      if (pp == ObjectWriter.NULL_PRETTY_PRINTER)
      {
        gen.setPrettyPrinter(null);
      }
      else
      {
        if ((pp instanceof Instantiatable)) {
          pp = (PrettyPrinter)((Instantiatable)pp).createInstance();
        }
        gen.setPrettyPrinter(pp);
      }
    }
    if (characterEscapes != null) {
      gen.setCharacterEscapes(characterEscapes);
    }
    if (schema != null) {
      gen.setSchema(schema);
    }
    if (rootValueSeparator != null) {
      gen.setRootValueSeparator(rootValueSeparator);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ObjectWriter.GeneratorSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */