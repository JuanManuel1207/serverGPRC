package com.uptc.servicioMilitar.grpcServiceImpl;


import com.cuerposervicegrpc.grpc.*;
import com.servicegrpc.grpc.*;
import com.uptc.servicioMilitar.entities.Servicio;
import com.uptc.servicioMilitar.services.ServicioService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@GrpcService
public class GrpcServicioServiceImpl extends serviceServiceGrpc.serviceServiceImplBase {
    @Autowired
    private ServicioService servicioService;

    @Override
    public void getOneByID(idServicio request, StreamObserver<ServicioObject> responseObserver) {
        CompletableFuture<Servicio> foundSchool = servicioService.getOneById(request.getId());
        foundSchool.join();
        ServicioObject objectSchoolToReturn = ServicioObject.newBuilder()
                .setId(foundSchool.join().getId())
                .setDescripcion(foundSchool.join().getDescripcion())
                .setStatus(foundSchool.join().getStatus())
                .build();
        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptyServicio request, StreamObserver<ServicioList> responseObserver) {
        CompletableFuture<List<Servicio>> completeList = servicioService.getAll();
        List<ServicioObject> schoolsGrpcList = new ArrayList<>();
        for(int i =0; i<completeList.join().size(); i++){
            ServicioObject schoolToadd = ServicioObject.newBuilder()
                    .setId(completeList.join().get(i).getId())
                    .setDescripcion(completeList.join().get(i).getDescripcion())
                    .setStatus(completeList.join().get(i).getStatus())
                    .build();

            schoolsGrpcList.add(schoolToadd);
        }
        ServicioList.Builder listToReturn = ServicioList.newBuilder();

        for(ServicioObject eachSchool: schoolsGrpcList){
            listToReturn.addServicio(eachSchool);
        }
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }



}
