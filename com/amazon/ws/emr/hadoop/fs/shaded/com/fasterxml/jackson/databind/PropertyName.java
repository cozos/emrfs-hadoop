package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SerializedString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.InternCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;

public class PropertyName
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static final String _USE_DEFAULT = "";
  private static final String _NO_NAME = "";
  public static final PropertyName USE_DEFAULT = new PropertyName("", null);
  public static final PropertyName NO_NAME = new PropertyName(new String(""), null);
  protected final String _simpleName;
  protected final String _namespace;
  protected SerializableString _encodedSimple;
  
  public PropertyName(String simpleName)
  {
    this(simpleName, null);
  }
  
  public PropertyName(String simpleName, String namespace)
  {
    _simpleName = (simpleName == null ? "" : simpleName);
    _namespace = namespace;
  }
  
  protected Object readResolve()
  {
    if ((_simpleName == null) || ("".equals(_simpleName))) {
      return USE_DEFAULT;
    }
    if ((_simpleName.equals("")) && (_namespace == null)) {
      return NO_NAME;
    }
    return this;
  }
  
  public static PropertyName construct(String simpleName)
  {
    if ((simpleName == null) || (simpleName.length() == 0)) {
      return USE_DEFAULT;
    }
    return new PropertyName(InternCache.instance.intern(simpleName), null);
  }
  
  public static PropertyName construct(String simpleName, String ns)
  {
    if (simpleName == null) {
      simpleName = "";
    }
    if ((ns == null) && (simpleName.length() == 0)) {
      return USE_DEFAULT;
    }
    return new PropertyName(InternCache.instance.intern(simpleName), ns);
  }
  
  public PropertyName internSimpleName()
  {
    if (_simpleName.length() == 0) {
      return this;
    }
    String interned = InternCache.instance.intern(_simpleName);
    if (interned == _simpleName) {
      return this;
    }
    return new PropertyName(interned, _namespace);
  }
  
  public PropertyName withSimpleName(String simpleName)
  {
    if (simpleName == null) {
      simpleName = "";
    }
    if (simpleName.equals(_simpleName)) {
      return this;
    }
    return new PropertyName(simpleName, _namespace);
  }
  
  public PropertyName withNamespace(String ns)
  {
    if (ns == null)
    {
      if (_namespace == null) {
        return this;
      }
    }
    else if (ns.equals(_namespace)) {
      return this;
    }
    return new PropertyName(_simpleName, ns);
  }
  
  public String getSimpleName()
  {
    return _simpleName;
  }
  
  public SerializableString simpleAsEncoded(MapperConfig<?> config)
  {
    SerializableString sstr = _encodedSimple;
    if (sstr == null)
    {
      if (config == null) {
        sstr = new SerializedString(_simpleName);
      } else {
        sstr = config.compileString(_simpleName);
      }
      _encodedSimple = sstr;
    }
    return sstr;
  }
  
  public String getNamespace()
  {
    return _namespace;
  }
  
  public boolean hasSimpleName()
  {
    return _simpleName.length() > 0;
  }
  
  public boolean hasSimpleName(String str)
  {
    if (str == null) {
      return _simpleName == null;
    }
    return str.equals(_simpleName);
  }
  
  public boolean hasNamespace()
  {
    return _namespace != null;
  }
  
  public boolean isEmpty()
  {
    return (_namespace == null) && (_simpleName.isEmpty());
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o.getClass() != getClass()) {
      return false;
    }
    PropertyName other = (PropertyName)o;
    if (_simpleName == null)
    {
      if (_simpleName != null) {
        return false;
      }
    }
    else if (!_simpleName.equals(_simpleName)) {
      return false;
    }
    if (_namespace == null) {
      return null == _namespace;
    }
    return _namespace.equals(_namespace);
  }
  
  public int hashCode()
  {
    if (_namespace == null) {
      return _simpleName.hashCode();
    }
    return _namespace.hashCode() ^ _simpleName.hashCode();
  }
  
  public String toString()
  {
    if (_namespace == null) {
      return _simpleName;
    }
    return "{" + _namespace + "}" + _simpleName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */