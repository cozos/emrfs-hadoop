package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.FixedDelayStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.HttpFailureStatusAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.HttpSuccessStatusAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.MaxAttemptsRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.PollingStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.Waiter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterAcceptor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterExecutorServiceFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.WaiterState;
import java.util.concurrent.ExecutorService;

public class AmazonIdentityManagementWaiters
{
  private final AmazonIdentityManagement client;
  private final ExecutorService executorService = WaiterExecutorServiceFactory.buildExecutorServiceForWaiter("AmazonIdentityManagementWaiters");
  
  @SdkInternalApi
  public AmazonIdentityManagementWaiters(AmazonIdentityManagement client)
  {
    this.client = client;
  }
  
  public Waiter<GetRoleRequest> roleExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new GetRoleFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpSuccessStatusAcceptor(WaiterState.SUCCESS), new RoleExists.IsNoSuchEntityMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(1))).withExecutorService(executorService).build();
  }
  
  public Waiter<GetInstanceProfileRequest> instanceProfileExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new GetInstanceProfileFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpSuccessStatusAcceptor(WaiterState.SUCCESS), new HttpFailureStatusAcceptor(404, WaiterState.RETRY) }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(40), new FixedDelayStrategy(1))).withExecutorService(executorService).build();
  }
  
  public Waiter<GetPolicyRequest> policyExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new GetPolicyFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpSuccessStatusAcceptor(WaiterState.SUCCESS), new PolicyExists.IsNoSuchEntityMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(1))).withExecutorService(executorService).build();
  }
  
  public Waiter<GetUserRequest> userExists()
  {
    return 
    
      new WaiterBuilder().withSdkFunction(new GetUserFunction(client)).withAcceptors(new WaiterAcceptor[] { new HttpSuccessStatusAcceptor(WaiterState.SUCCESS), new UserExists.IsNoSuchEntityMatcher() }).withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(20), new FixedDelayStrategy(1))).withExecutorService(executorService).build();
  }
  
  public void shutdown()
  {
    executorService.shutdown();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.waiters.AmazonIdentityManagementWaiters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */