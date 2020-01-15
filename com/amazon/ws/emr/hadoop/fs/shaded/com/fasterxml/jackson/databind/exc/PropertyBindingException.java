package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public abstract class PropertyBindingException
  extends JsonMappingException
{
  protected final Class<?> _referringClass;
  protected final String _propertyName;
  protected final Collection<Object> _propertyIds;
  protected transient String _propertiesAsString;
  private static final int MAX_DESC_LENGTH = 1000;
  
  protected PropertyBindingException(String msg, JsonLocation loc, Class<?> referringClass, String propName, Collection<Object> propertyIds)
  {
    super(msg, loc);
    _referringClass = referringClass;
    _propertyName = propName;
    _propertyIds = propertyIds;
  }
  
  public String getMessageSuffix()
  {
    String suffix = _propertiesAsString;
    if ((suffix == null) && (_propertyIds != null))
    {
      StringBuilder sb = new StringBuilder(100);
      int len = _propertyIds.size();
      if (len == 1)
      {
        sb.append(" (one known property: \"");
        sb.append(String.valueOf(_propertyIds.iterator().next()));
        sb.append('"');
      }
      else
      {
        sb.append(" (").append(len).append(" known properties: ");
        Iterator<Object> it = _propertyIds.iterator();
        while (it.hasNext())
        {
          sb.append('"');
          sb.append(String.valueOf(it.next()));
          sb.append('"');
          if (sb.length() > 1000)
          {
            sb.append(" [truncated]");
            break;
          }
          if (it.hasNext()) {
            sb.append(", ");
          }
        }
      }
      sb.append("])");
      _propertiesAsString = (suffix = sb.toString());
    }
    return suffix;
  }
  
  public Class<?> getReferringClass()
  {
    return _referringClass;
  }
  
  public String getPropertyName()
  {
    return _propertyName;
  }
  
  public Collection<Object> getKnownPropertyIds()
  {
    if (_propertyIds == null) {
      return null;
    }
    return Collections.unmodifiableCollection(_propertyIds);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.PropertyBindingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */