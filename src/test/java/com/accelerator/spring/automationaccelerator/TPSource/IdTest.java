package com.accelerator.spring.automationaccelerator.TPSource;

import com.accelerator.spring.automationaccelerator.flights.FlightTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties={"app.locale=id","browser=chrome"})
public class IdTest extends FlightTest {

}
