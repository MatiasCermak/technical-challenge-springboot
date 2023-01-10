package com.example.technicalchallengebackend.response.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KpiResponse {
    private double ageStandardDeviation;
    private double ageAverage;
}
