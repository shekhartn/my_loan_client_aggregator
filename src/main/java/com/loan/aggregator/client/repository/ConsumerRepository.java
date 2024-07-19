package com.loan.aggregator.client.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.aggregator.client.model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Serializable> {

	Consumer findByCuid(String cuid);
}

