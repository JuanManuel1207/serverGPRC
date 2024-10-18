package com.uptc.servicioMilitar.grpcServiceImpl;

import com.cuartelservicegrpc.grpc.*;
import com.uptc.servicioMilitar.entities.Cuartel;
import com.uptc.servicioMilitar.services.CuartelService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@GrpcService
public class GrpcCuartelServiceImpl extends cuartelServiceGrpc.cuartelServiceImplBase {
    @Autowired
    private CuartelService cuartelService;


/*
    @Override
    public void getOneByID(id request, StreamObserver<CuartelWithCompaniasResponse> responseObserver) {
        CompletableFuture<Cuartel> foundCuartelFuture = schoolsService.getOneById(request.getId());
        foundCuartelFuture.thenAccept(foundCuartel -> {
            // Obtener las compañías asociadas al cuartel

            List<com.schools.api.entities.Compania> companias = foundCuartel.getCompanias();
            System.out.println("ENTRA: "+companias.size());
            // Construir la respuesta
            CuartelWithCompaniasResponse response = CuartelWithCompaniasResponse.newBuilder()
                    .setId(foundCuartel.getId())
                    .setUbicacion(foundCuartel.getUbicacion())
                    .setNombre(foundCuartel.getNombre())
                    .setStatus(foundCuartel.getStatus())
                    .addAllCompanias(companias.stream()
                            .map(compania -> Compania.newBuilder()
                                    .setId(compania.getId())
                                    .setNumeroCompania(compania.getNumeroCompania())
                                    .setActividad(compania.getActividad())
                                    .build())
                            .collect(Collectors.toList()))
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }).exceptionally(ex -> {
            responseObserver.onError(ex);
            return null;
        });
    }

*/

 @Override
    public void getOneByID(com.cuartelservicegrpc.grpc.id request, StreamObserver<CuartelObject> responseObserver) {
        CompletableFuture<Cuartel> foundSchool = cuartelService.getOneById(request.getId());
        foundSchool.join();
        CuartelObject objectSchoolToReturn = CuartelObject.newBuilder()
                .setId(foundSchool.join().getId())
                .setUbicacion(foundSchool.join().getUbicacion())
                .setNombre(foundSchool.join().getNombre())
                .setStatus(foundSchool.join().getStatus())
                .build();
        responseObserver.onNext(objectSchoolToReturn);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(com.cuartelservicegrpc.grpc.Empty request, StreamObserver<CuartelList> responseObserver) {
        CompletableFuture<List<Cuartel>> completeList = cuartelService.getAll();
        List<CuartelObject> schoolsGrpcList = new ArrayList<>();
        for(int i =0; i<completeList.join().size(); i++){
            CuartelObject schoolToadd = CuartelObject.newBuilder()
                    .setId(completeList.join().get(i).getId())
                    .setUbicacion(completeList.join().get(i).getUbicacion())
                    .setNombre(completeList.join().get(i).getNombre())
                    .setStatus(completeList.join().get(i).getStatus())
                    .build();

            schoolsGrpcList.add(schoolToadd);
        }
        CuartelList.Builder listToReturn = CuartelList.newBuilder();

        for(CuartelObject eachSchool: schoolsGrpcList){
            listToReturn.addCuartel(eachSchool);
        }
        responseObserver.onNext(listToReturn.build());
        responseObserver.onCompleted();
    }

}
