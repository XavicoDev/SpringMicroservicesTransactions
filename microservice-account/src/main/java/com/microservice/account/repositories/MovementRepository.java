package com.microservice.account.repositories;

import com.microservice.account.dto.projections.MovementPrj;
import com.microservice.account.entities.Movement;
import com.microservice.account.repositories.base.BaseRepository;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends BaseRepository<Movement, Long> {

    List<MovementPrj> findAllProjectedBy();
    List<MovementPrj> findAllProjectedByAccountIdAndMovementDateBetween(Long id, Date minDate, Date maxDate);
}
