package com.microservice.account.services;

import com.microservice.account.entities.Movement;
import com.microservice.account.repositories.MovementRepository;
import com.microservice.account.repositories.base.BaseRepository;
import com.microservice.account.services.base.BaseServiceImpl;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService extends BaseServiceImpl<Movement, Long> {
    @Autowired
    public MovementRepository movementRepository;

    public MovementService(BaseRepository<Movement, Long> baseRepository) {
        super(baseRepository);
    }
}
