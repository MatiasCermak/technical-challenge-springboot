package com.example.technicalchallengebackend.service.impl;

import com.example.technicalchallengebackend.enums.ResponseCodes;
import com.example.technicalchallengebackend.domain.Client;
import com.example.technicalchallengebackend.repository.ClientRepository;
import com.example.technicalchallengebackend.response.Response;
import com.example.technicalchallengebackend.response.client.ClientResponse;
import com.example.technicalchallengebackend.response.client.KpiResponse;
import com.example.technicalchallengebackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

@Service
public class ClientServiceStandardImpl implements ClientService {

    @Autowired
    ClientRepository repository;
    @Override
    public Response<Void> create(Client client) {
        Response<Void> response = new Response<>();

            Period realAge = Period.between(LocalDate.ofInstant(client.getBirthDate().toInstant(), ZoneId.systemDefault()), LocalDate.now());
            if(realAge.getYears() != client.getAge()) {
                response.setCode(ResponseCodes.AGE_DATE_MISMATCH);
                response.setMessage(ResponseCodes.AGE_DATE_MISMATCH);
            } else {
                repository.save(client);
                response.setCode(ResponseCodes.OK);
                response.setMessage(ResponseCodes.OK);
            }
        return response;
    }

    @Override
    public Response<List<ClientResponse>> list() {
        List<Client> clients = repository.findAll();
        List<ClientResponse> clientResponses = clients.stream().map((ClientResponse::new)).toList();
        return new Response<>(ResponseCodes.OK, clientResponses);
    }

    @Override
    public Response<KpiResponse> retrieveKpi() {
        KpiResponse responseData = new KpiResponse();
        List<Client> clients = repository.findAll();

        if(clients.isEmpty()) {
            responseData.setAgeStandardDeviation(0);
            responseData.setAgeAverage(0);
        } else {
            double ageSum = clients.stream().reduce(0.0, ((subtotal, client) -> subtotal + client.getAge()), Double::sum);
            responseData.setAgeAverage(ageSum/clients.size());
            double partialStdDev = clients.stream().reduce((double)0.0, (subtotal, client) -> Math.pow(client.getAge() - responseData.getAgeAverage(), 2), Double::sum);
            double stdDev = Math.sqrt(partialStdDev/clients.size());
            responseData.setAgeStandardDeviation(stdDev);
        }

        return new Response<>(ResponseCodes.OK, responseData);
    }

}
