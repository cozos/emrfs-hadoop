package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class AttributeUpdate
{
  private final String attributeName;
  private AttributeAction action;
  private Set<Object> attributeValues;
  private Object value;
  
  public AttributeUpdate(String attributeName)
  {
    this.attributeName = attributeName;
  }
  
  public AttributeUpdate put(Object attributeValue)
  {
    action = AttributeAction.PUT;
    value = attributeValue;
    return this;
  }
  
  public AttributeUpdate delete()
  {
    action = AttributeAction.DELETE;
    return this;
  }
  
  public AttributeUpdate removeElements(Object... elementsToBeRemoved)
  {
    action = AttributeAction.DELETE;
    attributeValues = Collections.unmodifiableSet(new LinkedHashSet(
      Arrays.asList(elementsToBeRemoved)));
    return this;
  }
  
  public AttributeUpdate addNumeric(Number value)
  {
    action = AttributeAction.ADD;
    this.value = value;
    return this;
  }
  
  public AttributeUpdate addElements(Object... newElements)
  {
    action = AttributeAction.ADD;
    attributeValues = Collections.unmodifiableSet(new LinkedHashSet(
      Arrays.asList(newElements)));
    return this;
  }
  
  public String getAttributeName()
  {
    return attributeName;
  }
  
  public AttributeAction getAction()
  {
    return action;
  }
  
  public Set<Object> getAttributeValues()
  {
    return attributeValues;
  }
  
  public Object getValue()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.AttributeUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */