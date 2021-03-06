package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ExceptionLogger;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpConnectionFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpServerConnection;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.config.SocketConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpService;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

class RequestListener
  implements Runnable
{
  private final SocketConfig socketConfig;
  private final ServerSocket serversocket;
  private final HttpService httpService;
  private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
  private final ExceptionLogger exceptionLogger;
  private final ExecutorService executorService;
  private final AtomicBoolean terminated;
  
  public RequestListener(SocketConfig socketConfig, ServerSocket serversocket, HttpService httpService, HttpConnectionFactory<? extends HttpServerConnection> connectionFactory, ExceptionLogger exceptionLogger, ExecutorService executorService)
  {
    this.socketConfig = socketConfig;
    this.serversocket = serversocket;
    this.connectionFactory = connectionFactory;
    this.httpService = httpService;
    this.exceptionLogger = exceptionLogger;
    this.executorService = executorService;
    terminated = new AtomicBoolean(false);
  }
  
  public void run()
  {
    try
    {
      while ((!isTerminated()) && (!Thread.interrupted()))
      {
        Socket socket = serversocket.accept();
        socket.setSoTimeout(socketConfig.getSoTimeout());
        socket.setKeepAlive(socketConfig.isSoKeepAlive());
        socket.setTcpNoDelay(socketConfig.isTcpNoDelay());
        if (socketConfig.getRcvBufSize() > 0) {
          socket.setReceiveBufferSize(socketConfig.getRcvBufSize());
        }
        if (socketConfig.getSndBufSize() > 0) {
          socket.setSendBufferSize(socketConfig.getSndBufSize());
        }
        if (socketConfig.getSoLinger() >= 0) {
          socket.setSoLinger(true, socketConfig.getSoLinger());
        }
        HttpServerConnection conn = (HttpServerConnection)connectionFactory.createConnection(socket);
        Worker worker = new Worker(httpService, conn, exceptionLogger);
        executorService.execute(worker);
      }
    }
    catch (Exception ex)
    {
      exceptionLogger.log(ex);
    }
  }
  
  public boolean isTerminated()
  {
    return terminated.get();
  }
  
  public void terminate()
    throws IOException
  {
    if (terminated.compareAndSet(false, true)) {
      serversocket.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.bootstrap.RequestListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */