package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl;

 enum DefaultHostnameVerifier$HostNameType
{
  IPv4(7),  IPv6(7),  DNS(2);
  
  final int subjectType;
  
  private DefaultHostnameVerifier$HostNameType(int subjectType)
  {
    this.subjectType = subjectType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ssl.DefaultHostnameVerifier.HostNameType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */