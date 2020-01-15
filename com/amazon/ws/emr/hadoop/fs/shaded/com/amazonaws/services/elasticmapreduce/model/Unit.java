package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum Unit
{
  NONE("NONE"),  SECONDS("SECONDS"),  MICRO_SECONDS("MICRO_SECONDS"),  MILLI_SECONDS("MILLI_SECONDS"),  BYTES("BYTES"),  KILO_BYTES("KILO_BYTES"),  MEGA_BYTES("MEGA_BYTES"),  GIGA_BYTES("GIGA_BYTES"),  TERA_BYTES("TERA_BYTES"),  BITS("BITS"),  KILO_BITS("KILO_BITS"),  MEGA_BITS("MEGA_BITS"),  GIGA_BITS("GIGA_BITS"),  TERA_BITS("TERA_BITS"),  PERCENT("PERCENT"),  COUNT("COUNT"),  BYTES_PER_SECOND("BYTES_PER_SECOND"),  KILO_BYTES_PER_SECOND("KILO_BYTES_PER_SECOND"),  MEGA_BYTES_PER_SECOND("MEGA_BYTES_PER_SECOND"),  GIGA_BYTES_PER_SECOND("GIGA_BYTES_PER_SECOND"),  TERA_BYTES_PER_SECOND("TERA_BYTES_PER_SECOND"),  BITS_PER_SECOND("BITS_PER_SECOND"),  KILO_BITS_PER_SECOND("KILO_BITS_PER_SECOND"),  MEGA_BITS_PER_SECOND("MEGA_BITS_PER_SECOND"),  GIGA_BITS_PER_SECOND("GIGA_BITS_PER_SECOND"),  TERA_BITS_PER_SECOND("TERA_BITS_PER_SECOND"),  COUNT_PER_SECOND("COUNT_PER_SECOND");
  
  private String value;
  
  private Unit(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static Unit fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (Unit enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Unit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */