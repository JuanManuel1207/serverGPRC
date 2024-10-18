package com.uptc.servicioMilitar.grpcServiceImpl;


import com.uptc.servicioMilitar.entities.Soldado;
import com.uptc.servicioMilitar.services.SoldadoService;
import com.soldadoservicegrpc.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@GrpcService
public class GrpcSoldadoServiceImpl extends soldadoServiceGrpc.soldadoServiceImplBase {
    @Autowired
    private SoldadoService soldadoService;

    @Override
    public void getOneByID(idSoldado request, StreamObserver<SoldadoObject> responseObserver) {
        CompletableFuture<Soldado> foundSchool = soldadoService.getOneById(request.getId());
        foundSchool.join();
        SoldadoObject objectSchoolToReturn = SoldadoObject.newBuilder()
                .setId(foundSchool.join().getId())
                .setNombre(foundSchool.join().getNombre())
                .setApellido(foundSchool.join().getApellido())
                .setGrado(foundSchool.join().getGrado())
                .setStatus(foundSchool.join().getStatus())
                .build();
        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptySoldado request, StreamObserver<SoldadoList> responseObserver) {
       CompletableFuture<List<Soldado>> completeList = soldadoService.getAll();
        List<SoldadoObject> schoolsGrpcList = new ArrayList<>();
        for(int i =0; i<completeList.join().size(); i++){
            SoldadoObject schoolToadd = SoldadoObject.newBuilder()
                    .setId(completeList.join().get(i).getId())
                    .setNombre(completeList.join().get(i).getNombre())
                    .setApellido(completeList.join().get(i).getApellido())
                    .setGrado(completeList.join().get(i).getGrado())
                    .setStatus(completeList.join().get(i).getStatus())
                    .build();

            schoolsGrpcList.add(schoolToadd);
        }
        SoldadoList.Builder listToReturn = SoldadoList.newBuilder();

        for(SoldadoObject eachSchool: schoolsGrpcList){
            listToReturn.addSoldado(eachSchool);
        }
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }

}
