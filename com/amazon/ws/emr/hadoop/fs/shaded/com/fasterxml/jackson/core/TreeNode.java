package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import java.util.Iterator;

public abstract interface TreeNode
{
  public abstract JsonToken asToken();
  
  public abstract JsonParser.NumberType numberType();
  
  public abstract int size();
  
  public abstract boolean isValueNode();
  
  public abstract boolean isContainerNode();
  
  public abstract boolean isMissingNode();
  
  public abstract boolean isArray();
  
  public abstract boolean isObject();
  
  public abstract TreeNode get(String paramString);
  
  public abstract TreeNode get(int paramInt);
  
  public abstract TreeNode path(String paramString);
  
  public abstract TreeNode path(int paramInt);
  
  public abstract Iterator<String> fieldNames();
  
  public abstract TreeNode at(JsonPointer paramJsonPointer);
  
  public abstract TreeNode at(String paramString)
    throws IllegalArgumentException;
  
  public abstract JsonParser traverse();
  
  public abstract JsonParser traverse(ObjectCodec paramObjectCodec);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.TreeNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */