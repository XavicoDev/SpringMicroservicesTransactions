package com.microservice.account.services;

import com.microservice.account.dto.projections.MovementPrj;
import com.microservice.account.entities.Movement;
import com.microservice.account.repositories.MovementRepository;
import com.microservice.account.repositories.base.BaseRepository;
import com.microservice.account.services.base.BaseServiceImpl;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovementService extends BaseServiceImpl<Movement, Long> {
    @Autowired
    public MovementRepository movementRepository;

    public MovementService(BaseRepository<Movement, Long> baseRepository) {
        super(baseRepository);
    }

    public List<MovementPrj> findAllProjectedBy() {
        return movementRepository.findAllProjectedBy();
    }

    public List<MovementPrj> findAllProjectedByAccountIdAndMovementDateBetween(Long id, Date minDate, Date maxDate) {
        return movementRepository.findAllProjectedByAccountIdAndMovementDateBetween(id, minDate, maxDate);
    }
}
