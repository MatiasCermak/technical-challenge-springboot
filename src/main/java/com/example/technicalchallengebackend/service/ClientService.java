package com.example.technicalchallengebackend.service;

import com.example.technicalchallengebackend.domain.Client;
import com.example.technicalchallengebackend.response.Response;
import com.example.technicalchallengebackend.response.client.ClientResponse;
import com.example.technicalchallengebackend.response.client.KpiResponse;

import java.util.List;

public interface ClientService {
    public Response<Void> create(Client client);
    public Response<List<ClientResponse>> list();
    public Response<KpiResponse> retrieveKpi();
}
