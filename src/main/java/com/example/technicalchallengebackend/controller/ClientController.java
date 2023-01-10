package com.example.technicalchallengebackend.controller;

import com.example.technicalchallengebackend.domain.Client;
import com.example.technicalchallengebackend.response.Response;
import com.example.technicalchallengebackend.response.client.ClientResponse;
import com.example.technicalchallengebackend.response.client.KpiResponse;
import com.example.technicalchallengebackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ClientController {

    @Autowired
    ClientService service;

    @PostMapping("creacliente")
    public Response<Void> create(@RequestBody Client request) throws Exception {
       return this.service.create(request);
    }

    @GetMapping("kpideclientes")
    public Response<KpiResponse> retrieveKpi() throws Exception {
        return this.service.retrieveKpi();
    }

    @GetMapping("listclientes")
    public Response<List<ClientResponse>> list() throws Exception {
        return this.service.list();
    }
}