package com.uptc.servicioMilitar.grpcServiceImpl;

import com.companiaservicegrpc.grpc.*;
import com.cuartelservicegrpc.grpc.*;
import com.uptc.servicioMilitar.entities.Compania;
import com.uptc.servicioMilitar.services.CompaniaService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@GrpcService
public class GrpcCompaniaServiceImpl extends companiaServiceGrpc.companiaServiceImplBase {
    @Autowired
    private CompaniaService companiaService;

    @Override
    public void getOneByID(idCompania request, StreamObserver<CompaniaObject> responseObserver) {
        CompletableFuture<Compania> foundSchool = companiaService.getOneById(request.getId());
        foundSchool.join();
        CompaniaObject objectSchoolToReturn = CompaniaObject.newBuilder()
                .setId(foundSchool.join().getId())
                .setNumeroCompania(foundSchool.join().getNumeroCompania())
                .setActividad(foundSchool.join().getActividad())
                .setStatus(foundSchool.join().getStatus())
                .build();
        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptyCompania request, StreamObserver<CompaniaList> responseObserver) {
        CompletableFuture<List<Compania>> completeList = companiaService.getAll();
        List<CompaniaObject> schoolsGrpcList = new ArrayList<>();
        for(int i =0; i<completeList.join().size(); i++){
            CompaniaObject schoolToadd = CompaniaObject.newBuilder()
                    .setId(completeList.join().get(i).getId())
                    .setNumeroCompania(completeList.join().get(i).getNumeroCompania())
                    .setActividad(completeList.join().get(i).getActividad())
                    .setStatus(completeList.join().get(i).getStatus())
                    .build();

            schoolsGrpcList.add(schoolToadd);
        }
        CompaniaList.Builder listToReturn = CompaniaList.newBuilder();

        for(CompaniaObject eachSchool: schoolsGrpcList){
            listToReturn.addCompania(eachSchool);
        }
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }

}
