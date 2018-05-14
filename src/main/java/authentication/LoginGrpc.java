package authentication;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The Login service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: authentication_service.proto")
public final class LoginGrpc {

  private LoginGrpc() {}

  public static final String SERVICE_NAME = "authentication.Login";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginCheckMethod()} instead. 
  public static final io.grpc.MethodDescriptor<authentication.AuthenticationService.LoginRequest,
      authentication.AuthenticationService.LoginReply> METHOD_LOGIN_CHECK = getLoginCheckMethodHelper();

  private static volatile io.grpc.MethodDescriptor<authentication.AuthenticationService.LoginRequest,
      authentication.AuthenticationService.LoginReply> getLoginCheckMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<authentication.AuthenticationService.LoginRequest,
      authentication.AuthenticationService.LoginReply> getLoginCheckMethod() {
    return getLoginCheckMethodHelper();
  }

  private static io.grpc.MethodDescriptor<authentication.AuthenticationService.LoginRequest,
      authentication.AuthenticationService.LoginReply> getLoginCheckMethodHelper() {
    io.grpc.MethodDescriptor<authentication.AuthenticationService.LoginRequest, authentication.AuthenticationService.LoginReply> getLoginCheckMethod;
    if ((getLoginCheckMethod = LoginGrpc.getLoginCheckMethod) == null) {
      synchronized (LoginGrpc.class) {
        if ((getLoginCheckMethod = LoginGrpc.getLoginCheckMethod) == null) {
          LoginGrpc.getLoginCheckMethod = getLoginCheckMethod = 
              io.grpc.MethodDescriptor.<authentication.AuthenticationService.LoginRequest, authentication.AuthenticationService.LoginReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authentication.Login", "LoginCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  authentication.AuthenticationService.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  authentication.AuthenticationService.LoginReply.getDefaultInstance()))
                  .setSchemaDescriptor(new LoginMethodDescriptorSupplier("LoginCheck"))
                  .build();
          }
        }
     }
     return getLoginCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginStub newStub(io.grpc.Channel channel) {
    return new LoginStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginFutureStub(channel);
  }

  /**
   * <pre>
   * The Login service definition.
   * </pre>
   */
  public static abstract class LoginImplBase implements io.grpc.BindableService {

    /**
     */
    public void loginCheck(authentication.AuthenticationService.LoginRequest request,
        io.grpc.stub.StreamObserver<authentication.AuthenticationService.LoginReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginCheckMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginCheckMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                authentication.AuthenticationService.LoginRequest,
                authentication.AuthenticationService.LoginReply>(
                  this, METHODID_LOGIN_CHECK)))
          .build();
    }
  }

  /**
   * <pre>
   * The Login service definition.
   * </pre>
   */
  public static final class LoginStub extends io.grpc.stub.AbstractStub<LoginStub> {
    private LoginStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginStub(channel, callOptions);
    }

    /**
     */
    public void loginCheck(authentication.AuthenticationService.LoginRequest request,
        io.grpc.stub.StreamObserver<authentication.AuthenticationService.LoginReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginCheckMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Login service definition.
   * </pre>
   */
  public static final class LoginBlockingStub extends io.grpc.stub.AbstractStub<LoginBlockingStub> {
    private LoginBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginBlockingStub(channel, callOptions);
    }

    /**
     */
    public authentication.AuthenticationService.LoginReply loginCheck(authentication.AuthenticationService.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginCheckMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Login service definition.
   * </pre>
   */
  public static final class LoginFutureStub extends io.grpc.stub.AbstractStub<LoginFutureStub> {
    private LoginFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<authentication.AuthenticationService.LoginReply> loginCheck(
        authentication.AuthenticationService.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginCheckMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_CHECK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_CHECK:
          serviceImpl.loginCheck((authentication.AuthenticationService.LoginRequest) request,
              (io.grpc.stub.StreamObserver<authentication.AuthenticationService.LoginReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return authentication.AuthenticationService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Login");
    }
  }

  private static final class LoginFileDescriptorSupplier
      extends LoginBaseDescriptorSupplier {
    LoginFileDescriptorSupplier() {}
  }

  private static final class LoginMethodDescriptorSupplier
      extends LoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LoginMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LoginFileDescriptorSupplier())
              .addMethod(getLoginCheckMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
