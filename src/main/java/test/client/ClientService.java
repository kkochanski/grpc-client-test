package test.client;

import com.google.protobuf.ByteString;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import test.grpc.greet.GreetGrpc;

import java.util.stream.Stream;


@Service
public class ClientService {

    @GrpcClient("greet-server")
    private GreetGrpc.GreetBlockingStub simpleBlockingStub;

    public String greet() {
        try {
            final test.grpc.greet.HelloReply response = simpleBlockingStub.sayHello(test.grpc.greet.HelloRequest.newBuilder().setName("Kris").build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name() + " " + e.getStatus().getDescription();
        }
    }

    public String greetAgain() {
        try {
            final test.grpc.greet.HelloReply response = simpleBlockingStub.sayHelloAgain(test.grpc.greet.HelloRequest.newBuilder().setName("Kris").build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name() + " " + e.getStatus().getDescription();
        }
    }

}
