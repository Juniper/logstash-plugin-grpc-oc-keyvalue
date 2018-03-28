package telemetry;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Interface exported by Agent
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: oc.proto")
public final class OpenConfigTelemetryGrpc {

  private OpenConfigTelemetryGrpc() {}

  public static final String SERVICE_NAME = "telemetry.OpenConfigTelemetry";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<telemetry.Oc.SubscriptionRequest,
      telemetry.Oc.OpenConfigData> METHOD_TELEMETRY_SUBSCRIBE =
      io.grpc.MethodDescriptor.<telemetry.Oc.SubscriptionRequest, telemetry.Oc.OpenConfigData>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "telemetry.OpenConfigTelemetry", "telemetrySubscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.SubscriptionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.OpenConfigData.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<telemetry.Oc.CancelSubscriptionRequest,
      telemetry.Oc.CancelSubscriptionReply> METHOD_CANCEL_TELEMETRY_SUBSCRIPTION =
      io.grpc.MethodDescriptor.<telemetry.Oc.CancelSubscriptionRequest, telemetry.Oc.CancelSubscriptionReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "telemetry.OpenConfigTelemetry", "cancelTelemetrySubscription"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.CancelSubscriptionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.CancelSubscriptionReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<telemetry.Oc.GetSubscriptionsRequest,
      telemetry.Oc.GetSubscriptionsReply> METHOD_GET_TELEMETRY_SUBSCRIPTIONS =
      io.grpc.MethodDescriptor.<telemetry.Oc.GetSubscriptionsRequest, telemetry.Oc.GetSubscriptionsReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "telemetry.OpenConfigTelemetry", "getTelemetrySubscriptions"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.GetSubscriptionsRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.GetSubscriptionsReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<telemetry.Oc.GetOperationalStateRequest,
      telemetry.Oc.GetOperationalStateReply> METHOD_GET_TELEMETRY_OPERATIONAL_STATE =
      io.grpc.MethodDescriptor.<telemetry.Oc.GetOperationalStateRequest, telemetry.Oc.GetOperationalStateReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "telemetry.OpenConfigTelemetry", "getTelemetryOperationalState"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.GetOperationalStateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.GetOperationalStateReply.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<telemetry.Oc.DataEncodingRequest,
      telemetry.Oc.DataEncodingReply> METHOD_GET_DATA_ENCODINGS =
      io.grpc.MethodDescriptor.<telemetry.Oc.DataEncodingRequest, telemetry.Oc.DataEncodingReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "telemetry.OpenConfigTelemetry", "getDataEncodings"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.DataEncodingRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              telemetry.Oc.DataEncodingReply.getDefaultInstance()))
          .build();

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
      asyncUnimplementedUnaryCall(METHOD_TELEMETRY_SUBSCRIBE, responseObserver);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public void cancelTelemetrySubscription(telemetry.Oc.CancelSubscriptionRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.CancelSubscriptionReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CANCEL_TELEMETRY_SUBSCRIPTION, responseObserver);
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
      asyncUnimplementedUnaryCall(METHOD_GET_TELEMETRY_SUBSCRIPTIONS, responseObserver);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public void getTelemetryOperationalState(telemetry.Oc.GetOperationalStateRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.GetOperationalStateReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TELEMETRY_OPERATIONAL_STATE, responseObserver);
    }

    /**
     * <pre>
     * Return the set of data encodings supported by the device for
     * telemetry data
     * </pre>
     */
    public void getDataEncodings(telemetry.Oc.DataEncodingRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.DataEncodingReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DATA_ENCODINGS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_TELEMETRY_SUBSCRIBE,
            asyncServerStreamingCall(
              new MethodHandlers<
                telemetry.Oc.SubscriptionRequest,
                telemetry.Oc.OpenConfigData>(
                  this, METHODID_TELEMETRY_SUBSCRIBE)))
          .addMethod(
            METHOD_CANCEL_TELEMETRY_SUBSCRIPTION,
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.CancelSubscriptionRequest,
                telemetry.Oc.CancelSubscriptionReply>(
                  this, METHODID_CANCEL_TELEMETRY_SUBSCRIPTION)))
          .addMethod(
            METHOD_GET_TELEMETRY_SUBSCRIPTIONS,
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.GetSubscriptionsRequest,
                telemetry.Oc.GetSubscriptionsReply>(
                  this, METHODID_GET_TELEMETRY_SUBSCRIPTIONS)))
          .addMethod(
            METHOD_GET_TELEMETRY_OPERATIONAL_STATE,
            asyncUnaryCall(
              new MethodHandlers<
                telemetry.Oc.GetOperationalStateRequest,
                telemetry.Oc.GetOperationalStateReply>(
                  this, METHODID_GET_TELEMETRY_OPERATIONAL_STATE)))
          .addMethod(
            METHOD_GET_DATA_ENCODINGS,
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
          getChannel().newCall(METHOD_TELEMETRY_SUBSCRIBE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public void cancelTelemetrySubscription(telemetry.Oc.CancelSubscriptionRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.CancelSubscriptionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CANCEL_TELEMETRY_SUBSCRIPTION, getCallOptions()), request, responseObserver);
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
          getChannel().newCall(METHOD_GET_TELEMETRY_SUBSCRIPTIONS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public void getTelemetryOperationalState(telemetry.Oc.GetOperationalStateRequest request,
        io.grpc.stub.StreamObserver<telemetry.Oc.GetOperationalStateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TELEMETRY_OPERATIONAL_STATE, getCallOptions()), request, responseObserver);
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
          getChannel().newCall(METHOD_GET_DATA_ENCODINGS, getCallOptions()), request, responseObserver);
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
          getChannel(), METHOD_TELEMETRY_SUBSCRIBE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Terminates and removes an exisiting telemetry subscription
     * </pre>
     */
    public telemetry.Oc.CancelSubscriptionReply cancelTelemetrySubscription(telemetry.Oc.CancelSubscriptionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CANCEL_TELEMETRY_SUBSCRIPTION, getCallOptions(), request);
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
          getChannel(), METHOD_GET_TELEMETRY_SUBSCRIPTIONS, getCallOptions(), request);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public telemetry.Oc.GetOperationalStateReply getTelemetryOperationalState(telemetry.Oc.GetOperationalStateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TELEMETRY_OPERATIONAL_STATE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the set of data encodings supported by the device for
     * telemetry data
     * </pre>
     */
    public telemetry.Oc.DataEncodingReply getDataEncodings(telemetry.Oc.DataEncodingRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DATA_ENCODINGS, getCallOptions(), request);
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
          getChannel().newCall(METHOD_CANCEL_TELEMETRY_SUBSCRIPTION, getCallOptions()), request);
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
          getChannel().newCall(METHOD_GET_TELEMETRY_SUBSCRIPTIONS, getCallOptions()), request);
    }

    /**
     * <pre>
     * Get Telemetry Agent Operational States
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<telemetry.Oc.GetOperationalStateReply> getTelemetryOperationalState(
        telemetry.Oc.GetOperationalStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TELEMETRY_OPERATIONAL_STATE, getCallOptions()), request);
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
          getChannel().newCall(METHOD_GET_DATA_ENCODINGS, getCallOptions()), request);
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

  private static final class OpenConfigTelemetryDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return telemetry.Oc.getDescriptor();
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
              .setSchemaDescriptor(new OpenConfigTelemetryDescriptorSupplier())
              .addMethod(METHOD_TELEMETRY_SUBSCRIBE)
              .addMethod(METHOD_CANCEL_TELEMETRY_SUBSCRIPTION)
              .addMethod(METHOD_GET_TELEMETRY_SUBSCRIPTIONS)
              .addMethod(METHOD_GET_TELEMETRY_OPERATIONAL_STATE)
              .addMethod(METHOD_GET_DATA_ENCODINGS)
              .build();
        }
      }
    }
    return result;
  }
}
