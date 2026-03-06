package mil.army.moda.vehicle.Vehicle;

import mil.army.moda.vehicle.Operator.Operator;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockitoBean
    VehicleService vehicleService;
    @Captor
    ArgumentCaptor<Vehicle> captor = ArgumentCaptor.forClass(Vehicle.class);
    @Test
    void shouldSaveVehicle() throws Exception {
        //arrange
        Operator operator = new Operator("James");
        operator.setId(1L);
        Vehicle stang = new Vehicle("Ford", "Mustang", 2020, 40000, operator);
        stang.setId(1L);
        when(vehicleService.save(any(Vehicle.class))).thenReturn(stang);
        //act
        mockMvc.perform(post("/api/vehicle/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(stang)))
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.make").value("Ford"))
                        .andExpect(jsonPath("$.operator.name").value("James"))
                        .andDo(print());
        Mockito.verify(vehicleService, only()).save(captor.capture());
        assertThat(captor.getValue()).usingRecursiveComparison().isEqualTo(stang);
        //verify(vehicleService, times(1)).save(any(Vehicle.class));
    }

}