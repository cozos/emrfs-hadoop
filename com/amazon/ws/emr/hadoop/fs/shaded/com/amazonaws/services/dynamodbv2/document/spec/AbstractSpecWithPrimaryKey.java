package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import java.util.Arrays;
import java.util.Collection;

public class AbstractSpecWithPrimaryKey<T extends AmazonWebServiceRequest>
  extends AbstractSpec<T>
{
  private Collection<KeyAttribute> keyComponents;
  
  protected AbstractSpecWithPrimaryKey(T request)
  {
    super(request);
  }
  
  public final Collection<KeyAttribute> getKeyComponents()
  {
    return keyComponents;
  }
  
  public AbstractSpecWithPrimaryKey<T> withPrimaryKey(KeyAttribute... components)
  {
    if (components == null) {
      keyComponents = null;
    } else {
      keyComponents = Arrays.asList(components);
    }
    return this;
  }
  
  public AbstractSpecWithPrimaryKey<T> withPrimaryKey(PrimaryKey primaryKey)
  {
    if (primaryKey == null) {
      keyComponents = null;
    } else {
      keyComponents = primaryKey.getComponents();
    }
    return this;
  }
  
  public AbstractSpecWithPrimaryKey<T> withPrimaryKey(String hashKeyName, Object hashKeyValue)
  {
    if (hashKeyName == null) {
      throw new IllegalArgumentException();
    }
    withPrimaryKey(new PrimaryKey(hashKeyName, hashKeyValue));
    return this;
  }
  
  public AbstractSpecWithPrimaryKey<T> withPrimaryKey(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    if (hashKeyName == null) {
      throw new IllegalArgumentException("Invalid hash key name");
    }
    if (rangeKeyName == null) {
      throw new IllegalArgumentException("Invalid range key name");
    }
    if (hashKeyName.equals(rangeKeyName)) {
      throw new IllegalArgumentException("Names of hash and range keys must not be the same");
    }
    withPrimaryKey(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue));
    
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.AbstractSpecWithPrimaryKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */