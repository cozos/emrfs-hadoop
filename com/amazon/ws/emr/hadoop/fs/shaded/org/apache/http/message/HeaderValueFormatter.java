package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HeaderElement;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.NameValuePair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.CharArrayBuffer;

public abstract interface HeaderValueFormatter
{
  public abstract CharArrayBuffer formatElements(CharArrayBuffer paramCharArrayBuffer, HeaderElement[] paramArrayOfHeaderElement, boolean paramBoolean);
  
  public abstract CharArrayBuffer formatHeaderElement(CharArrayBuffer paramCharArrayBuffer, HeaderElement paramHeaderElement, boolean paramBoolean);
  
  public abstract CharArrayBuffer formatParameters(CharArrayBuffer paramCharArrayBuffer, NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean);
  
  public abstract CharArrayBuffer formatNameValuePair(CharArrayBuffer paramCharArrayBuffer, NameValuePair paramNameValuePair, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.HeaderValueFormatter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */