package ma.enset.vehiculeinfraction.web.grpc.stubs;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import ma.enset.vehiculeinfraction.Repositories.OwnerRepository;
import ma.enset.vehiculeinfraction.Repositories.VehicleRepository;
import ma.enset.vehiculeinfraction.entities.Owner;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Collection;


@GrpcService
@AllArgsConstructor
public class RegistrationGrpcController extends RegistrationServiceGrpc.RegistrationServiceImplBase{


    private final OwnerRepository ownerRepository;
    private final VehicleRepository vehicleRepository;



    @Override
    public void getOwners(Vehicule.Empty request, StreamObserver<Vehicule.OwnerList> responseObserver) {
        Collection<Owner> owners = ownerRepository.findAll();
        Vehicule.OwnerList.Builder response = Vehicule.OwnerList.newBuilder();
        for (Owner owner : owners) {
            Vehicule.Owner ownerResponse = Vehicule.Owner.newBuilder()
                    .setId(owner.getId().intValue())
                    .setName(owner.getName())
                    .setEmail(owner.getEmail())
                    .build();
            response.addOwners(ownerResponse);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();


        super.getOwners(request, responseObserver);
    }

    @Override
    public void getOwner(Vehicule.OwnerId request, StreamObserver<Vehicule.Owner> responseObserver) {

        Long ownerId = (long)request.getId();
        Owner owner = ownerRepository.findById(String.valueOf(ownerId)).orElse(null);
        Vehicule.Owner ownerResponse = Vehicule.Owner.newBuilder()
                .setId(owner.getId().intValue())
                .setName(owner.getName())
                .setEmail(owner.getEmail())
                .build();
        responseObserver.onNext(ownerResponse);
        responseObserver.onCompleted();
    }


    @Override
    public void saveOwner(Vehicule.OwnerRequest request, StreamObserver<Vehicule.Owner> responseObserver) {
        super.saveOwner(request, responseObserver);
    }



    @Override
    public void updateOwner(Vehicule.OwnerUpdateRequest request, StreamObserver<Vehicule.Owner> responseObserver) {
        super.updateOwner(request, responseObserver);
    }


    @Override
    public void deleteOwner(Vehicule.OwnerId request, StreamObserver<Vehicule.Empty> responseObserver) {
        super.deleteOwner(request, responseObserver);
    }



    @Override
    public void getVehicles(Vehicule.Empty request, StreamObserver<Vehicule.VehicleList> responseObserver) {
        super.getVehicles(request, responseObserver);
    }


    @Override
    public void getVehicle(Vehicule.VehicleId request, StreamObserver<Vehicule.Vehicle> responseObserver) {
        super.getVehicle(request, responseObserver);
    }


    @Override
    public void saveVehicle(Vehicule.VehicleRequest request, StreamObserver<Vehicule.Vehicle> responseObserver) {
        super.saveVehicle(request, responseObserver);
    }


    @Override
    public void updateVehicle(Vehicule.VehicleUpdateRequest request, StreamObserver<Vehicule.Vehicle> responseObserver) {
        super.updateVehicle(request, responseObserver);
    }

    @Override
    public void deleteVehicle(Vehicule.VehicleId request, StreamObserver<Vehicule.Empty> responseObserver) {
        super.deleteVehicle(request, responseObserver);
    }


}
