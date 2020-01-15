package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public abstract class TypeBase
  extends JavaType
  implements JsonSerializable
{
  private static final long serialVersionUID = -3581199092426900829L;
  volatile transient String _canonicalName;
  
  @Deprecated
  protected TypeBase(Class<?> raw, int hash, Object valueHandler, Object typeHandler)
  {
    this(raw, hash, valueHandler, typeHandler, false);
  }
  
  protected TypeBase(Class<?> raw, int hash, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(raw, hash, valueHandler, typeHandler, asStatic);
  }
  
  public String toCanonical()
  {
    String str = _canonicalName;
    if (str == null) {
      str = buildCanonicalName();
    }
    return str;
  }
  
  protected abstract String buildCanonicalName();
  
  public abstract StringBuilder getGenericSignature(StringBuilder paramStringBuilder);
  
  public abstract StringBuilder getErasedSignature(StringBuilder paramStringBuilder);
  
  public <T> T getValueHandler()
  {
    return (T)_valueHandler;
  }
  
  public <T> T getTypeHandler()
  {
    return (T)_typeHandler;
  }
  
  public void serializeWithType(JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonProcessingException
  {
    typeSer.writeTypePrefixForScalar(this, jgen);
    serialize(jgen, provider);
    typeSer.writeTypeSuffixForScalar(this, jgen);
  }
  
  public void serialize(JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    jgen.writeString(toCanonical());
  }
  
  protected static StringBuilder _classSignature(Class<?> cls, StringBuilder sb, boolean trailingSemicolon)
  {
    if (cls.isPrimitive())
    {
      if (cls == Boolean.TYPE) {
        sb.append('Z');
      } else if (cls == Byte.TYPE) {
        sb.append('B');
      } else if (cls == Short.TYPE) {
        sb.append('S');
      } else if (cls == Character.TYPE) {
        sb.append('C');
      } else if (cls == Integer.TYPE) {
        sb.append('I');
      } else if (cls == Long.TYPE) {
        sb.append('J');
      } else if (cls == Float.TYPE) {
        sb.append('F');
      } else if (cls == Double.TYPE) {
        sb.append('D');
      } else if (cls == Void.TYPE) {
        sb.append('V');
      } else {
        throw new IllegalStateException("Unrecognized primitive type: " + cls.getName());
      }
    }
    else
    {
      sb.append('L');
      String name = cls.getName();
      int i = 0;
      for (int len = name.length(); i < len; i++)
      {
        char c = name.charAt(i);
        if (c == '.') {
          c = '/';
        }
        sb.append(c);
      }
      if (trailingSemicolon) {
        sb.append(';');
      }
    }
    return sb;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */