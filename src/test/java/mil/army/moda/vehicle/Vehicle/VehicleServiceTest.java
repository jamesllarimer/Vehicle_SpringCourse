package mil.army.moda.vehicle.Vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {
    @Mock
    private VehicleRepository vehicleRepository;
    @InjectMocks
    VehicleService vehicleService;

    @Test
    void shouldSaveVehicle() {
        //arrange
        Vehicle vehicle = new Vehicle("Triplane", "DR-1", 1916, 5000);
        vehicle.setId(1L);
        //act
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
        Vehicle savedVehicle = vehicleService.save(vehicle);

        //assert
        assertThat(savedVehicle.getId()).isEqualTo(1L);
        verify(vehicleRepository).save(vehicle);
    }
}