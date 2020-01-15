package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

class $ClassEmitter$FieldInfo
{
  int access;
  String name;
  .Type type;
  Object value;
  
  public $ClassEmitter$FieldInfo(int access, String name, .Type type, Object value)
  {
    this.access = access;
    this.name = name;
    this.type = type;
    this.value = value;
  }
  
  public boolean equals(Object o)
  {
    if (o == null) {
      return false;
    }
    if (!(o instanceof FieldInfo)) {
      return false;
    }
    FieldInfo other = (FieldInfo)o;
    if ((access != access) || (!name.equals(name)) || (!type.equals(type))) {
      return false;
    }
    if (((value == null ? 1 : 0) ^ (value == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((value != null) && (!value.equals(value))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return access ^ name.hashCode() ^ type.hashCode() ^ (value == null ? 0 : value.hashCode());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter.FieldInfo
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */