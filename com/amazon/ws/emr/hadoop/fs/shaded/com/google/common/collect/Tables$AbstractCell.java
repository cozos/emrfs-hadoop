package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;

abstract class Tables$AbstractCell<R, C, V>
  implements Table.Cell<R, C, V>
{
  public boolean equals(Object obj)
  {
    if (obj == this) {
      return true;
    }
    if ((obj instanceof Table.Cell))
    {
      Table.Cell<?, ?, ?> other = (Table.Cell)obj;
      return (Objects.equal(getRowKey(), other.getRowKey())) && (Objects.equal(getColumnKey(), other.getColumnKey())) && (Objects.equal(getValue(), other.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { getRowKey(), getColumnKey(), getValue() });
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(getRowKey()));String str2 = String.valueOf(String.valueOf(getColumnKey()));String str3 = String.valueOf(String.valueOf(getValue()));return 4 + str1.length() + str2.length() + str3.length() + "(" + str1 + "," + str2 + ")=" + str3;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.AbstractCell
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */