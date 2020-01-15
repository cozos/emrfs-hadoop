package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.params;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.params.AuthPNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnConnectionPNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnManagerPNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.params.ConnRoutePNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.cookie.params.CookieSpecPNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.CoreConnectionPNames;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.params.CoreProtocolPNames;

@Deprecated
public abstract interface AllClientPNames
  extends CoreConnectionPNames, CoreProtocolPNames, ClientPNames, AuthPNames, CookieSpecPNames, ConnConnectionPNames, ConnManagerPNames, ConnRoutePNames
{}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.params.AllClientPNames
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */