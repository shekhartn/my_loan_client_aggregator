package com.loan.aggregator.client.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.aggregator.client.exception.MyLoanAggregatorClientException;
import com.loan.aggregator.client.manager.ConsumerManager;
import com.loan.aggregator.client.model.Consumer;
import com.loan.aggregator.client.request.ConsumerRequest;

@RestController
//@RequestMapping("/consumers")
public class ConsumerController {
	
	@Autowired
	private ConsumerManager consumerManager;
	
	@GetMapping("/consumers/{consumerId}")
	public @ResponseBody Consumer getConsumer(@PathVariable BigInteger consumerId) {
		return consumerManager.getUser(consumerId);
	}
	@GetMapping("/consumers/cuid/{cuid}")
	public @ResponseBody Consumer getConsumerByCuid(@PathVariable String cuid) {
		return consumerManager.getConsumerByCuid(cuid);
	}
	
	@GetMapping("/consumers")
	public @ResponseBody List<Consumer> getConsumers() {
		return consumerManager.getAllCustomer();
	}
	
	@PostMapping("/consumers")
	public @ResponseBody Consumer registerConsumer(@RequestBody ConsumerRequest consumer) {
		try {
			return consumerManager.registerUser(consumer);
		} catch (MyLoanAggregatorClientException exception) {
			throw new MyLoanAggregatorClientException(exception.getStatusCode(),exception.getMessage());
		}
		
	}

}
