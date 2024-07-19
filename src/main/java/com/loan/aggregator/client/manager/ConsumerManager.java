package com.loan.aggregator.client.manager;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.aggregator.client.exception.MyLoanAggregatorClientException;
import com.loan.aggregator.client.model.Consumer;
import com.loan.aggregator.client.repository.ConsumerRepository;
import com.loan.aggregator.client.request.ConsumerRequest;
import com.loan.aggregator.client.util.DateUtility;

@Service
public class ConsumerManager {

	@Autowired
	private ConsumerRepository consumerRepo;
	
	private String getClientId() {
		return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}
	
	public Consumer registerUser(ConsumerRequest consumerRequest)throws MyLoanAggregatorClientException {
		if(consumerRequest!=null && consumerRequest.getFirstName() !=null) {
			return createConsumer(consumerRequest);
		}
		throw new MyLoanAggregatorClientException("01","Sorry, it seems there is a network connection problem. Please try again later.");
	}

	public Consumer getUser(BigInteger consumerId) {
		if(consumerId!=null) {
			return consumerRepo.findById(consumerId).get();
		}
		return new Consumer();
	}

	public List<Consumer> getAllCustomer() {
		return consumerRepo.findAll();
	}
	
	private Consumer createConsumer(ConsumerRequest consumerRequest) {
		Consumer consumer=new Consumer();
		if(consumerRequest== null) {
			return null;
		}
		consumer.setEmail(consumerRequest.getEmail());
		consumer.setFirstName(consumerRequest.getFirstName());
		consumer.setLastName(consumerRequest.getLastName());
		consumer.setPassword(consumerRequest.getPassword());
		consumer.setIsActive((byte)1);
		consumer.setCuid(getClientId());
		consumer.setAppId(consumerRequest.getAppId());
		consumer.setPhoneNumber(consumerRequest.getPhoneNumber());
		consumer.setCreatedDate(DateUtility.getCalendarInUTCZone().getTime());
		consumer.setModifiedDate(DateUtility.getCalendarInUTCZone().getTime());
		consumer=consumerRepo.save(consumer);
		return consumer;
	}

	public Consumer getConsumerByCuid(String cuid) {
		if(cuid!=null) {
			System.out.println("CUID::"+cuid);
			Consumer customer=consumerRepo.findByCuid(cuid);
			System.out.println("Customer::"+customer);
			return customer;
		}
		return new Consumer();
	}

}
