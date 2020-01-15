package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.ClientConnectionOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.OperatedClientConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.conn.routing.HttpRoute;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.pool.ConnFactory;
import java.io.IOException;

class HttpConnPool$InternalConnFactory
  implements ConnFactory<HttpRoute, OperatedClientConnection>
{
  private final ClientConnectionOperator connOperator;
  
  HttpConnPool$InternalConnFactory(ClientConnectionOperator connOperator)
  {
    this.connOperator = connOperator;
  }
  
  public OperatedClientConnection create(HttpRoute route)
    throws IOException
  {
    return connOperator.createConnection();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.conn.HttpConnPool.InternalConnFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */