package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

public enum StepFactory$HiveVersion
{
  Hive_0_5("0.5"),  Hive_0_7("0.7"),  Hive_0_7_1("0.7.1"),  Hive_0_8_1("0.8.1"),  Hive_0_8_1_1("0.8.1.1"),  Hive_0_8_1_2("0.8.1.2"),  Hive_0_8_1_3("0.8.1.3"),  Hive_0_8_1_4("0.8.1.4"),  Hive_0_8_1_5("0.8.1.5"),  Hive_0_8_1_6("0.8.1.6"),  Hive_0_8_1_7("0.8.1.7"),  Hive_0_8_1_8("0.8.1.8"),  Hive_0_11_0("0.11.0"),  Hive_Latest("latest");
  
  private String stringVal;
  
  private StepFactory$HiveVersion(String str)
  {
    stringVal = str;
  }
  
  public String toString()
  {
    return stringVal;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.StepFactory.HiveVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */