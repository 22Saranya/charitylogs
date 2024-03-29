package com.stackroute.controller;

import com.stackroute.domain.Charity;
import com.stackroute.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1")
public class CharityController {
    @Autowired
    CharityService charityService;

    @Autowired
    public  CharityController(CharityService charityService)
    {
        this.charityService = charityService;
    }
    ResponseEntity responseEntity;

    @PostMapping("charity-logs")
    public ResponseEntity<?> saveCharityLogs (@RequestBody Charity charity) throws Exception
    {

        charityService.saveCharityLogs(charity);
        responseEntity=new ResponseEntity(charity, HttpStatus.CREATED);
        return  responseEntity;
    }

    @GetMapping("charity-logs")
    public ResponseEntity displayCharityLogs(@RequestParam String username)
    {
        return  new ResponseEntity(charityService.fetchCharity(username),HttpStatus.OK);
    }


}
