package br.com.lecosas.cloudparking.controller;

import br.com.lecosas.cloudparking.controller.dto.ParkingDTO;
import br.com.lecosas.cloudparking.controller.mapper.ParkingMapper;
import br.com.lecosas.cloudparking.model.Parking;
import br.com.lecosas.cloudparking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> parkingDTOList = parkingMapper.toParkingDTOList(parkingList);
        return parkingDTOList;
    }
}
