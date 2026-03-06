package mil.army.moda.vehicle.Operator;

import mil.army.moda.vehicle.Vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {
    private final OperatorService operatorService;
    @Autowired
    OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }
    @PostMapping("/saveOperator")
    @ResponseStatus(HttpStatus.CREATED)
    public Operator saveOperator(@RequestBody Operator operator) {
        return operatorService.saveOperator(operator);
    }
}
