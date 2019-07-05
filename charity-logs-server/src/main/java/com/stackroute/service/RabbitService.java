package com.stackroute.service;

import com.stackroute.domain.Charity;
import com.stackroute.domain.Logs;
import com.stackroute.rabbitmq.model.CharityStatus;
import com.stackroute.repository.CharityRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RabbitListener(queues = "charityLogs.queue")
public class RabbitService {

    @Autowired
    private CharityRepository charityRepository;

    @RabbitHandler
    public void receivedmsg(List<CharityStatus> charityStatusList) {
        List<Charity> charityList = charityRepository.findAll();
        for (int i = 0; i < charityStatusList.size(); i++) {
            CharityStatus charityStatus = charityStatusList.get(i);
            System.out.println("Recieved Message For Charity : " + charityStatus.getUsername() + " => " + charityStatus);
            Charity charity = charityRepository.findByUsername(charityStatus.getUsername());
            Logs logs = new Logs();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            logs.setId("1");
            logs.setDate(dtf.format(now));
            logs.setCharityStatus(charityStatus);
            charity.setUsername(charityStatus.getUsername());
            charityRepository.save(charity);
        }
    }
}

