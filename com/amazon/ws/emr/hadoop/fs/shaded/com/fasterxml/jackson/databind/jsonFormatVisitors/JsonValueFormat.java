package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors;

public enum JsonValueFormat
{
  DATE_TIME("date-time"),  DATE("date"),  TIME("time"),  UTC_MILLISEC("utc-millisec"),  REGEX("regex"),  COLOR("color"),  STYLE("style"),  PHONE("phone"),  URI("uri"),  EMAIL("email"),  IP_ADDRESS("ip-address"),  IPV6("ipv6"),  HOST_NAME("host-name");
  
  private final String _desc;
  
  private JsonValueFormat(String desc)
  {
    _desc = desc;
  }
  
  public String toString()
  {
    return _desc;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */