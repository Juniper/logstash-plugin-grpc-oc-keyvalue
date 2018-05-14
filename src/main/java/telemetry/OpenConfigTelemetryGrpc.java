package telemetry;

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
 * Interface exported by Agent
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: oc.proto")
public final class OpenConfigTelemetryGrpc {

  private OpenConfigTelemetryGrpc() {}

  public static final String SERVICE_NAME = "telemetry.OpenConfigTelemetry";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTelemetrySubscribeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<telemetry.Oc.SubscriptionRequest,
      telemetry.Oc.OpenConfigData> METHOD_TELEMETRY_SUBSCRIBE = getTelemetrySubscribeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<telemetry.Oc.SubscriptionRequest,
      telemetry.Oc.OpenConfigData> getTelemetrySubscribeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<telemetry.Oc.SubscriptionRequest,
      telemetry.Oc.OpenConfigData> getTelemetrySubscribeMethod() {
    return getTelemetrySubscribeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<telemetry.Oc.SubscriptionRequest,
      telemetry.Oc.OpenConfigData> getTelemetrySubscribeMethodHelper() {
    io.grpc.MethodDescriptor<telemetry.Oc.SubscriptionRequest, telemetry.Oc.OpenConfigData> getTelemetrySubscribeMethod;
    if ((getTelemetrySubscribeMethod = OpenConfigTelemetryGrpc.getTelemetrySubscribeMethod) == null) {
      synchronized (OpenConfigTelemetryGrpc.class) {
        if ((getTelemetrySubscribeMethod = OpenConfigTelemetryGrpc.getTelemetrySubscribeMethod) == null) {
          OpenConfigTelemetryGrpc.getTelemetrySubscribeMethod = getTelemetrySubscribeMethod = 
              io.grpc.MethodDescriptor.<telemetry.Oc.SubscriptionRequest, telemetry.Oc.OpenConfigData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "telemetry.OpenConfigTelemetry", "telemetrySubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.OpenConfigData.getDefaultInstance()))
                  .setSchemaDescriptor(new OpenConfigTelemetryMethodDescriptorSupplier("telemetrySubscribe"))
                  .build();
          }
        }
     }
     return getTelemetrySubscribeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCancelTelemetrySubscriptionMethod()} instead. 
  public static final io.grpc.MethodDescriptor<telemetry.Oc.CancelSubscriptionRequest,
      telemetry.Oc.CancelSubscriptionReply> METHOD_CANCEL_TELEMETRY_SUBSCRIPTION = getCancelTelemetrySubscriptionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<telemetry.Oc.CancelSubscriptionRequest,
      telemetry.Oc.CancelSubscriptionReply> getCancelTelemetrySubscriptionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<telemetry.Oc.CancelSubscriptionRequest,
      telemetry.Oc.CancelSubscriptionReply> getCancelTelemetrySubscriptionMethod() {
    return getCancelTelemetrySubscriptionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<telemetry.Oc.CancelSubscriptionRequest,
      telemetry.Oc.CancelSubscriptionReply> getCancelTelemetrySubscriptionMethodHelper() {
    io.grpc.MethodDescriptor<telemetry.Oc.CancelSubscriptionRequest, telemetry.Oc.CancelSubscriptionReply> getCancelTelemetrySubscriptionMethod;
    if ((getCancelTelemetrySubscriptionMethod = OpenConfigTelemetryGrpc.getCancelTelemetrySubscriptionMethod) == null) {
      synchronized (OpenConfigTelemetryGrpc.class) {
        if ((getCancelTelemetrySubscriptionMethod = OpenConfigTelemetryGrpc.getCancelTelemetrySubscriptionMethod) == null) {
          OpenConfigTelemetryGrpc.getCancelTelemetrySubscriptionMethod = getCancelTelemetrySubscriptionMethod = 
              io.grpc.MethodDescriptor.<telemetry.Oc.CancelSubscriptionRequest, telemetry.Oc.CancelSubscriptionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "telemetry.OpenConfigTelemetry", "cancelTelemetrySubscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.CancelSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.CancelSubscriptionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OpenConfigTelemetryMethodDescriptorSupplier("cancelTelemetrySubscription"))
                  .build();
          }
        }
     }
     return getCancelTelemetrySubscriptionMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTelemetrySubscriptionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<telemetry.Oc.GetSubscriptionsRequest,
      telemetry.Oc.GetSubscriptionsReply> METHOD_GET_TELEMETRY_SUBSCRIPTIONS = getGetTelemetrySubscriptionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<telemetry.Oc.GetSubscriptionsRequest,
      telemetry.Oc.GetSubscriptionsReply> getGetTelemetrySubscriptionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<telemetry.Oc.GetSubscriptionsRequest,
      telemetry.Oc.GetSubscriptionsReply> getGetTelemetrySubscriptionsMethod() {
    return getGetTelemetrySubscriptionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<telemetry.Oc.GetSubscriptionsRequest,
      telemetry.Oc.GetSubscriptionsReply> getGetTelemetrySubscriptionsMethodHelper() {
    io.grpc.MethodDescriptor<telemetry.Oc.GetSubscriptionsRequest, telemetry.Oc.GetSubscriptionsReply> getGetTelemetrySubscriptionsMethod;
    if ((getGetTelemetrySubscriptionsMethod = OpenConfigTelemetryGrpc.getGetTelemetrySubscriptionsMethod) == null) {
      synchronized (OpenConfigTelemetryGrpc.class) {
        if ((getGetTelemetrySubscriptionsMethod = OpenConfigTelemetryGrpc.getGetTelemetrySubscriptionsMethod) == null) {
          OpenConfigTelemetryGrpc.getGetTelemetrySubscriptionsMethod = getGetTelemetrySubscriptionsMethod = 
              io.grpc.MethodDescriptor.<telemetry.Oc.GetSubscriptionsRequest, telemetry.Oc.GetSubscriptionsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "telemetry.OpenConfigTelemetry", "getTelemetrySubscriptions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.GetSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.GetSubscriptionsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OpenConfigTelemetryMethodDescriptorSupplier("getTelemetrySubscriptions"))
                  .build();
          }
        }
     }
     return getGetTelemetrySubscriptionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTelemetryOperationalStateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<telemetry.Oc.GetOperationalStateRequest,
      telemetry.Oc.GetOperationalStateReply> METHOD_GET_TELEMETRY_OPERATIONAL_STATE = getGetTelemetryOperationalStateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<telemetry.Oc.GetOperationalStateRequest,
      telemetry.Oc.GetOperationalStateReply> getGetTelemetryOperationalStateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<telemetry.Oc.GetOperationalStateRequest,
      telemetry.Oc.GetOperationalStateReply> getGetTelemetryOperationalStateMethod() {
    return getGetTelemetryOperationalStateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<telemetry.Oc.GetOperationalStateRequest,
      telemetry.Oc.GetOperationalStateReply> getGetTelemetryOperationalStateMethodHelper() {
    io.grpc.MethodDescriptor<telemetry.Oc.GetOperationalStateRequest, telemetry.Oc.GetOperationalStateReply> getGetTelemetryOperationalStateMethod;
    if ((getGetTelemetryOperationalStateMethod = OpenConfigTelemetryGrpc.getGetTelemetryOperationalStateMethod) == null) {
      synchronized (OpenConfigTelemetryGrpc.class) {
        if ((getGetTelemetryOperationalStateMethod = OpenConfigTelemetryGrpc.getGetTelemetryOperationalStateMethod) == null) {
          OpenConfigTelemetryGrpc.getGetTelemetryOperationalStateMethod = getGetTelemetryOperationalStateMethod = 
              io.grpc.MethodDescriptor.<telemetry.Oc.GetOperationalStateRequest, telemetry.Oc.GetOperationalStateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "telemetry.OpenConfigTelemetry", "getTelemetryOperationalState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.GetOperationalStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.GetOperationalStateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OpenConfigTelemetryMethodDescriptorSupplier("getTelemetryOperationalState"))
                  .build();
          }
        }
     }
     return getGetTelemetryOperationalStateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDataEncodingsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<telemetry.Oc.DataEncodingRequest,
      telemetry.Oc.DataEncodingReply> METHOD_GET_DATA_ENCODINGS = getGetDataEncodingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<telemetry.Oc.DataEncodingRequest,
      telemetry.Oc.DataEncodingReply> getGetDataEncodingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<telemetry.Oc.DataEncodingRequest,
      telemetry.Oc.DataEncodingReply> getGetDataEncodingsMethod() {
    return getGetDataEncodingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<telemetry.Oc.DataEncodingRequest,
      telemetry.Oc.DataEncodingReply> getGetDataEncodingsMethodHelper() {
    io.grpc.MethodDescriptor<telemetry.Oc.DataEncodingRequest, telemetry.Oc.DataEncodingReply> getGetDataEncodingsMethod;
    if ((getGetDataEncodingsMethod = OpenConfigTelemetryGrpc.getGetDataEncodingsMethod) == null) {
      synchronized (OpenConfigTelemetryGrpc.class) {
        if ((getGetDataEncodingsMethod = OpenConfigTelemetryGrpc.getGetDataEncodingsMethod) == null) {
          OpenConfigTelemetryGrpc.getGetDataEncodingsMethod = getGetDataEncodingsMethod = 
              io.grpc.MethodDescriptor.<telemetry.Oc.DataEncodingRequest, telemetry.Oc.DataEncodingReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "telemetry.OpenConfigTelemetry", "getDataEncodings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.DataEncodingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  telemetry.Oc.DataEncodingReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OpenConfigTelemetryMethodDescriptorSupplier("getDataEncodings"))
                  .build();
          }
        }
     }
     return getGetDataEncodingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OpenConfigTelemetryStub newStub(io.grpc.Channel channel) {
    return new OpenConfigTelemetryStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OpenConfigTelemetryBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OpenConfigTelemetryBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OpenConfigTelemetryFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OpenConfigTelemetryFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by Agent
   * </pre>
   */
  public static abstract class OpenConfigTelemetryImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Request an inline subscription for data at the specified path.
     * The device should send telemetry data back on the same
     * connection as the subscription request.
     * </pre>
     */
    public void telemetrySubscribe(telemetry.Oc.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.OpenConfigData> responseObserver) {
      asyncUnimplementedUnaryCall(getTelemetrySubscribeMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public void cancelTelemetrySubscription(telemetry.Oc.CancelSubscriptionRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.CancelSubscriptionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelTelemetrySubscriptionMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Get the list of current telemetry subscriptions from the
     * target. This command returns a list of existing subscriptions
     * not including those that are established via configuration.
     * </pre>
     */
    public void getTelemetrySubscriptions(telemetry.Oc.GetSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.GetSubscriptionsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTelemetrySubscriptionsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public void getTelemetryOperationalState(telemetry.Oc.GetOperationalStateRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.GetOperationalStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTelemetryOperationalStateMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Return the set of data encodings supported by the device for
     * telemetry data
     * </pre>
     */
    public void getDataEncodings(telemetry.Oc.DataEncodingRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.DataEncodingReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataEncodingsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTelemetrySubscribeMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                telemetry.Oc.SubscriptionRequest,
                telemetry.Oc.OpenConfigData>(
                  this, METHODID_TELEMETRY_SUBSCRIBE)))
          .addMethod(
            getCancelTelemetrySubscriptionMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.CancelSubscriptionRequest,
                telemetry.Oc.CancelSubscriptionReply>(
                  this, METHODID_CANCEL_TELEMETRY_SUBSCRIPTION)))
          .addMethod(
            getGetTelemetrySubscriptionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.GetSubscriptionsRequest,
                telemetry.Oc.GetSubscriptionsReply>(
                  this, METHODID_GET_TELEMETRY_SUBSCRIPTIONS)))
          .addMethod(
            getGetTelemetryOperationalStateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.GetOperationalStateRequest,
                telemetry.Oc.GetOperationalStateReply>(
                  this, METHODID_GET_TELEMETRY_OPERATIONAL_STATE)))
          .addMethod(
            getGetDataEncodingsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.DataEncodingRequest,
                telemetry.Oc.DataEncodingReply>(
                  this, METHODID_GET_DATA_ENCODINGS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by Agent
   * </pre>
   */
  public static final class OpenConfigTelemetryStub extends io.grpc.stub.AbstractStub<OpenConfigTelemetryStub> {
    private OpenConfigTelemetryStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OpenConfigTelemetryStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OpenConfigTelemetryStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OpenConfigTelemetryStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request an inline subscription for data at the specified path.
     * The device should send telemetry data back on the same
     * connection as the subscription request.
     * </pre>
     */
    public void telemetrySubscribe(telemetry.Oc.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.OpenConfigData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTelemetrySubscribeMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public void cancelTelemetrySubscription(telemetry.Oc.CancelSubscriptionRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.CancelSubscriptionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelTelemetrySubscriptionMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the list of current telemetry subscriptions from the
     * target. This command returns a list of existing subscriptions
     * not including those that are established via configuration.
     * </pre>
     */
    public void getTelemetrySubscriptions(telemetry.Oc.GetSubscriptionsRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.GetSubscriptionsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTelemetrySubscriptionsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public void getTelemetryOperationalState(telemetry.Oc.GetOperationalStateRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.GetOperationalStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTelemetryOperationalStateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return the set of data encodings supported by the device for
     * telemetry data
     * </pre>
     */
    public void getDataEncodings(telemetry.Oc.DataEncodingRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.DataEncodingReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataEncodingsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by Agent
   * </pre>
   */
  public static final class OpenConfigTelemetryBlockingStub extends io.grpc.stub.AbstractStub<OpenConfigTelemetryBlockingStub> {
    private OpenConfigTelemetryBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OpenConfigTelemetryBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OpenConfigTelemetryBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OpenConfigTelemetryBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Request an inline subscription for data at the specified path.
     * The device should send telemetry data back on the same
     * connection as the subscription request.
     * </pre>
     */
    public java.util.Iterator<telemetry.Oc.OpenConfigData> telemetrySubscribe(
        telemetry.Oc.SubscriptionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getTelemetrySubscribeMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public telemetry.Oc.CancelSubscriptionReply cancelTelemetrySubscription(telemetry.Oc.CancelSubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelTelemetrySubscriptionMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the list of current telemetry subscriptions from the
     * target. This command returns a list of existing subscriptions
     * not including those that are established via configuration.
     * </pre>
     */
    public telemetry.Oc.GetSubscriptionsReply getTelemetrySubscriptions(telemetry.Oc.GetSubscriptionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTelemetrySubscriptionsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public telemetry.Oc.GetOperationalStateReply getTelemetryOperationalState(telemetry.Oc.GetOperationalStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTelemetryOperationalStateMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the set of data encodings supported by the device for
     * telemetry data
     * </pre>
     */
    public telemetry.Oc.DataEncodingReply getDataEncodings(telemetry.Oc.DataEncodingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataEncodingsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by Agent
   * </pre>
   */
  public static final class OpenConfigTelemetryFutureStub extends io.grpc.stub.AbstractStub<OpenConfigTelemetryFutureStub> {
    private OpenConfigTelemetryFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OpenConfigTelemetryFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OpenConfigTelemetryFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OpenConfigTelemetryFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<telemetry.Oc.CancelSubscriptionReply> cancelTelemetrySubscription(
        telemetry.Oc.CancelSubscriptionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelTelemetrySubscriptionMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the list of current telemetry subscriptions from the
     * target. This command returns a list of existing subscriptions
     * not including those that are established via configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<telemetry.Oc.GetSubscriptionsReply> getTelemetrySubscriptions(
        telemetry.Oc.GetSubscriptionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTelemetrySubscriptionsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<telemetry.Oc.GetOperationalStateReply> getTelemetryOperationalState(
        telemetry.Oc.GetOperationalStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTelemetryOperationalStateMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return the set of data encodings supported by the device for
     * telemetry data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<telemetry.Oc.DataEncodingReply> getDataEncodings(
        telemetry.Oc.DataEncodingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataEncodingsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TELEMETRY_SUBSCRIBE = 0;
  private static final int METHODID_CANCEL_TELEMETRY_SUBSCRIPTION = 1;
  private static final int METHODID_GET_TELEMETRY_SUBSCRIPTIONS = 2;
  private static final int METHODID_GET_TELEMETRY_OPERATIONAL_STATE = 3;
  private static final int METHODID_GET_DATA_ENCODINGS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OpenConfigTelemetryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OpenConfigTelemetryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TELEMETRY_SUBSCRIBE:
          serviceImpl.telemetrySubscribe((telemetry.Oc.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<telemetry.Oc.OpenConfigData>) responseObserver);
          break;
        case METHODID_CANCEL_TELEMETRY_SUBSCRIPTION:
          serviceImpl.cancelTelemetrySubscription((telemetry.Oc.CancelSubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<telemetry.Oc.CancelSubscriptionReply>) responseObserver);
          break;
        case METHODID_GET_TELEMETRY_SUBSCRIPTIONS:
          serviceImpl.getTelemetrySubscriptions((telemetry.Oc.GetSubscriptionsRequest) request,
              (io.grpc.stub.StreamObserver<telemetry.Oc.GetSubscriptionsReply>) responseObserver);
          break;
        case METHODID_GET_TELEMETRY_OPERATIONAL_STATE:
          serviceImpl.getTelemetryOperationalState((telemetry.Oc.GetOperationalStateRequest) request,
              (io.grpc.stub.StreamObserver<telemetry.Oc.GetOperationalStateReply>) responseObserver);
          break;
        case METHODID_GET_DATA_ENCODINGS:
          serviceImpl.getDataEncodings((telemetry.Oc.DataEncodingRequest) request,
              (io.grpc.stub.StreamObserver<telemetry.Oc.DataEncodingReply>) responseObserver);
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

  private static abstract class OpenConfigTelemetryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OpenConfigTelemetryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return telemetry.Oc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OpenConfigTelemetry");
    }
  }

  private static final class OpenConfigTelemetryFileDescriptorSupplier
      extends OpenConfigTelemetryBaseDescriptorSupplier {
    OpenConfigTelemetryFileDescriptorSupplier() {}
  }

  private static final class OpenConfigTelemetryMethodDescriptorSupplier
      extends OpenConfigTelemetryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OpenConfigTelemetryMethodDescriptorSupplier(String methodName) {
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
      synchronized (OpenConfigTelemetryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OpenConfigTelemetryFileDescriptorSupplier())
              .addMethod(getTelemetrySubscribeMethodHelper())
              .addMethod(getCancelTelemetrySubscriptionMethodHelper())
              .addMethod(getGetTelemetrySubscriptionsMethodHelper())
              .addMethod(getGetTelemetryOperationalStateMethodHelper())
              .addMethod(getGetDataEncodingsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
