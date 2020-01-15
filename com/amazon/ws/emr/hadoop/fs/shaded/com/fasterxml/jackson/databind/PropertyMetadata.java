package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import java.io.Serializable;

public class PropertyMetadata
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  public static final PropertyMetadata STD_REQUIRED = new PropertyMetadata(Boolean.TRUE, null, null, null);
  public static final PropertyMetadata STD_OPTIONAL = new PropertyMetadata(Boolean.FALSE, null, null, null);
  public static final PropertyMetadata STD_REQUIRED_OR_OPTIONAL = new PropertyMetadata(null, null, null, null);
  protected final Boolean _required;
  protected final String _description;
  protected final Integer _index;
  protected final String _defaultValue;
  
  @Deprecated
  protected PropertyMetadata(Boolean req, String desc)
  {
    this(req, desc, null, null);
  }
  
  protected PropertyMetadata(Boolean req, String desc, Integer index, String def)
  {
    _required = req;
    _description = desc;
    _index = index;
    _defaultValue = ((def == null) || (def.isEmpty()) ? null : def);
  }
  
  @Deprecated
  public static PropertyMetadata construct(boolean req, String desc)
  {
    return construct(req, desc, null, null);
  }
  
  public static PropertyMetadata construct(boolean req, String desc, Integer index, String defaultValue)
  {
    if ((desc != null) || (index != null) || (defaultValue != null)) {
      return new PropertyMetadata(Boolean.valueOf(req), desc, index, defaultValue);
    }
    return req ? STD_REQUIRED : STD_OPTIONAL;
  }
  
  protected Object readResolve()
  {
    if ((_description == null) && (_index == null) && (_defaultValue == null))
    {
      if (_required == null) {
        return STD_REQUIRED_OR_OPTIONAL;
      }
      return _required.booleanValue() ? STD_REQUIRED : STD_OPTIONAL;
    }
    return this;
  }
  
  public PropertyMetadata withDescription(String desc)
  {
    return new PropertyMetadata(_required, desc, _index, _defaultValue);
  }
  
  public PropertyMetadata withDefaultValue(String def)
  {
    if ((def == null) || (def.isEmpty()))
    {
      if (_defaultValue == null) {
        return this;
      }
      def = null;
    }
    else if (_defaultValue.equals(def))
    {
      return this;
    }
    return new PropertyMetadata(_required, _description, _index, def);
  }
  
  public PropertyMetadata withIndex(Integer index)
  {
    return new PropertyMetadata(_required, _description, index, _defaultValue);
  }
  
  public PropertyMetadata withRequired(Boolean b)
  {
    if (b == null)
    {
      if (_required == null) {
        return this;
      }
    }
    else if ((_required != null) && (_required.booleanValue() == b.booleanValue())) {
      return this;
    }
    return new PropertyMetadata(b, _description, _index, _defaultValue);
  }
  
  public String getDescription()
  {
    return _description;
  }
  
  public String getDefaultValue()
  {
    return _defaultValue;
  }
  
  @Deprecated
  public boolean hasDefuaultValue()
  {
    return hasDefaultValue();
  }
  
  public boolean hasDefaultValue()
  {
    return _defaultValue != null;
  }
  
  public boolean isRequired()
  {
    return (_required != null) && (_required.booleanValue());
  }
  
  public Boolean getRequired()
  {
    return _required;
  }
  
  public Integer getIndex()
  {
    return _index;
  }
  
  public boolean hasIndex()
  {
    return _index != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */