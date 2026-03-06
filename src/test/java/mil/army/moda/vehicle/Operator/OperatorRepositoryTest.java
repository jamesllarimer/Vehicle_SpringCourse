package mil.army.moda.vehicle.Operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class OperatorRepositoryTest {
    @Autowired
    private OperatorRepository operatorRepository;
}