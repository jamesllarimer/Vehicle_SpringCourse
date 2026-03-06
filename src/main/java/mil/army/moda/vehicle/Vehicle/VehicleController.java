package mil.army.moda.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }
}
