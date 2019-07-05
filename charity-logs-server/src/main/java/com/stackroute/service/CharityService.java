package com.stackroute.service;

import com.stackroute.domain.Charity;

import java.util.List;

public interface CharityService {
    public Charity saveCharityLogs(Charity charity) throws Exception;

    public List<Charity> displayCharityLogs();

    public Charity fetchCharity(String username);


}
