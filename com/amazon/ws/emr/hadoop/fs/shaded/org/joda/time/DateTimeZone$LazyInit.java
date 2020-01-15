package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BaseChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class DateTimeZone$LazyInit
{
  static final Map<String, String> CONVERSION_MAP = ;
  static final DateTimeFormatter OFFSET_FORMATTER = buildFormatter();
  
  private static DateTimeFormatter buildFormatter()
  {
    BaseChronology local1 = new BaseChronology()
    {
      private static final long serialVersionUID = -3128740902654445468L;
      
      public DateTimeZone getZone()
      {
        return null;
      }
      
      public Chronology withUTC()
      {
        return this;
      }
      
      public Chronology withZone(DateTimeZone paramAnonymousDateTimeZone)
      {
        return this;
      }
      
      public String toString()
      {
        return getClass().getName();
      }
    };
    return new DateTimeFormatterBuilder().appendTimeZoneOffset(null, true, 2, 4).toFormatter().withChronology(local1);
  }
  
  private static Map<String, String> buildMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("GMT", "UTC");
    localHashMap.put("WET", "WET");
    localHashMap.put("CET", "CET");
    localHashMap.put("MET", "CET");
    localHashMap.put("ECT", "CET");
    localHashMap.put("EET", "EET");
    localHashMap.put("MIT", "Pacific/Apia");
    localHashMap.put("HST", "Pacific/Honolulu");
    localHashMap.put("AST", "America/Anchorage");
    localHashMap.put("PST", "America/Los_Angeles");
    localHashMap.put("MST", "America/Denver");
    localHashMap.put("PNT", "America/Phoenix");
    localHashMap.put("CST", "America/Chicago");
    localHashMap.put("EST", "America/New_York");
    localHashMap.put("IET", "America/Indiana/Indianapolis");
    localHashMap.put("PRT", "America/Puerto_Rico");
    localHashMap.put("CNT", "America/St_Johns");
    localHashMap.put("AGT", "America/Argentina/Buenos_Aires");
    localHashMap.put("BET", "America/Sao_Paulo");
    localHashMap.put("ART", "Africa/Cairo");
    localHashMap.put("CAT", "Africa/Harare");
    localHashMap.put("EAT", "Africa/Addis_Ababa");
    localHashMap.put("NET", "Asia/Yerevan");
    localHashMap.put("PLT", "Asia/Karachi");
    localHashMap.put("IST", "Asia/Kolkata");
    localHashMap.put("BST", "Asia/Dhaka");
    localHashMap.put("VST", "Asia/Ho_Chi_Minh");
    localHashMap.put("CTT", "Asia/Shanghai");
    localHashMap.put("JST", "Asia/Tokyo");
    localHashMap.put("ACT", "Australia/Darwin");
    localHashMap.put("AET", "Australia/Sydney");
    localHashMap.put("SST", "Pacific/Guadalcanal");
    localHashMap.put("NST", "Pacific/Auckland");
    return Collections.unmodifiableMap(localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone.LazyInit
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */