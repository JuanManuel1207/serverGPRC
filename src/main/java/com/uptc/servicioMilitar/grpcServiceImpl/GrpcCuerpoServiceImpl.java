package com.uptc.servicioMilitar.grpcServiceImpl;


import com.cuerposervicegrpc.grpc.*;
import com.uptc.servicioMilitar.entities.Cuerpo;
import com.uptc.servicioMilitar.services.CuerpoService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@GrpcService
public class GrpcCuerpoServiceImpl extends cuerpoServiceGrpc.cuerpoServiceImplBase {
    @Autowired
    private CuerpoService schoolsService;

    @Override
    public void getOneByID(idCuerpo request, StreamObserver<CuerpoObject> responseObserver) {
        CompletableFuture<Cuerpo> foundSchool = schoolsService.getOneById(request.getId());
        foundSchool.join();
        CuerpoObject objectSchoolToReturn = CuerpoObject.newBuilder()
                .setId(foundSchool.join().getId())
                .setDenominacion(foundSchool.join().getDenominacion())
                .setStatus(foundSchool.join().getStatus())
                .build();
        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptyCuerpo request, StreamObserver<CuerpoList> responseObserver) {
        CompletableFuture<List<Cuerpo>> completeList = schoolsService.getAll();
        List<CuerpoObject> schoolsGrpcList = new ArrayList<>();
        for(int i =0; i<completeList.join().size(); i++){
            CuerpoObject schoolToadd = CuerpoObject.newBuilder()
                    .setId(completeList.join().get(i).getId())
                    .setDenominacion(completeList.join().get(i).getDenominacion())
                    .setStatus(completeList.join().get(i).getStatus())
                    .build();

            schoolsGrpcList.add(schoolToadd);
        }
        CuerpoList.Builder listToReturn = CuerpoList.newBuilder();

        for(CuerpoObject eachSchool: schoolsGrpcList){
            listToReturn.addCuerpo(eachSchool);
        }
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }


}
