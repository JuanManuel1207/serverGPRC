package com.uptc.servicioMilitar.grpcServiceImpl;


import com.google.protobuf.Timestamp;
import com.uptc.servicioMilitar.entities.SoldadoServicio;
import com.uptc.servicioMilitar.services.SoldadoServicioService;
import com.soldadoservicegrpc.grpc.*;
import com.soldadoservicioservicegrpc.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@GrpcService
public class GrpcSoldadoServicioServiceImpl extends soldadoServServiceGrpc.soldadoServServiceImplBase {
    @Autowired
    private SoldadoServicioService soldadoServicioService;

    @Override
    public void getOneByID(idSoldadoServ request, StreamObserver<SoldadoServObject> responseObserver) {
        CompletableFuture<SoldadoServicio> foundSchool = soldadoServicioService.getOneById(request.getId());
        foundSchool.join();

        // Convertir java.util.Date a Instant y luego a Timestamp
        Instant fechaInstant = foundSchool.join().getFecha().toInstant();  // Asume que devuelve un Date
        Timestamp fechaTimestamp = Timestamp.newBuilder()
                .setSeconds(fechaInstant.getEpochSecond())
                .setNanos(fechaInstant.getNano())
                .build();

        SoldadoServObject objectSchoolToReturn = SoldadoServObject.newBuilder()
                .setId(foundSchool.join().getId())
                .setSoldado(foundSchool.join().getSoldado())
                .setServicio(foundSchool.join().getServicio())
                .setFecha(fechaTimestamp)  // Aquí pones el Timestamp convertido
                .setStatus(foundSchool.join().getStatus())
                .build();

        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptySoldadoServ request, StreamObserver<SoldadoServList> responseObserver) {
        CompletableFuture<List<SoldadoServicio>> completeList = soldadoServicioService.getAll();
        List<SoldadoServObject> schoolsGrpcList = new ArrayList<>();

        // Iterar sobre la lista de SoldadoServicio
        for (SoldadoServicio soldado : completeList.join()) {
            // Convertir la fecha a Timestamp (si `getFecha()` devuelve un Instant)
            Instant fechaInstant = soldado.getFecha().toInstant();  // Asume que devuelve un Instant
            Timestamp fechaTimestamp = Timestamp.newBuilder()
                    .setSeconds(fechaInstant.getEpochSecond())
                    .setNanos(fechaInstant.getNano())
                    .build();

            // Crear SoldadoServObject con todos los campos, incluyendo la fecha
            SoldadoServObject schoolToAdd = SoldadoServObject.newBuilder()
                    .setId(soldado.getId())
                    .setSoldado(soldado.getSoldado())
                    .setServicio(soldado.getServicio())
                    .setFecha(fechaTimestamp)  // Establecer la fecha convertida
                    .setStatus(soldado.getStatus())
                    .build();

            schoolsGrpcList.add(schoolToAdd);
        }

        // Construir la lista para retornar
        SoldadoServList.Builder listToReturn = SoldadoServList.newBuilder();
        for (SoldadoServObject eachSchool : schoolsGrpcList) {
            listToReturn.addSoldadoserv(eachSchool);
        }

        // Enviar la respuesta
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }

}
