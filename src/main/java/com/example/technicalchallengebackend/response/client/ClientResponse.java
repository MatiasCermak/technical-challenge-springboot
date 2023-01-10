package com.example.technicalchallengebackend.response.client;

import com.example.technicalchallengebackend.constants.BusinessConstants;
import com.example.technicalchallengebackend.domain.Client;
import com.example.technicalchallengebackend.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.module.ResolutionException;
import java.util.Calendar;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private String firstName;
    private String lastName;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date estimatedDeathDate;

    public ClientResponse(Client client){
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.age = client.getAge();
        this.birthDate = client.getBirthDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.birthDate);
        calendar.add(Calendar.YEAR,
                this.age > BusinessConstants.LIFE_EXPECTANCY?
                        5 : BusinessConstants.LIFE_EXPECTANCY - this.age);
        this.estimatedDeathDate = calendar.getTime();
    }


}
