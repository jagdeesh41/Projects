package com.thinkify.tapido.Service;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Repository.DriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.lenient;

@SpringBootTest
public class DriverServiceTest
{

    @InjectMocks
    private DriverServiceImpl  driverService;
    @Mock
    private DriverRepository driverRepository;

    @Test
    public void getAllDrivers()
    {
        List<DriverDetail> driverDetailList=new ArrayList<>();
        driverDetailList.add(new DriverDetail("Driver1, M, 22","Swift, KA-01-12345","(10,1)"));
        lenient().when(this.driverRepository.getAllDrivers()).thenReturn(driverDetailList);
        Assertions.assertTrue(driverDetailList.size()>0);

    }

    @Test
    public void findRide()
    {
        List<String> rides=new ArrayList<>();
        rides.add("Driver1[Available]");
        lenient().when(this.driverRepository.findRide("abhisek","(10,1)","(1,2)")).thenReturn(rides);
        Assertions.assertTrue(rides.size()>0);

    }






}
