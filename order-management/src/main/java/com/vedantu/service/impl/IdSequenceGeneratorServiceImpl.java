package com.vedantu.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vedantu.model.IdSequenceGenerator;
import com.vedantu.repository.IdSequenceGeneratorRepository;
import com.vedantu.service.IdSequenceGeneratorService;
import com.vedantu.util.AppConstant;


@Component
public class IdSequenceGeneratorServiceImpl implements IdSequenceGeneratorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IdSequenceGeneratorService.class);
	
	@Autowired
	private IdSequenceGeneratorRepository idSequenceGeneratorRepository;

	@Override
	public synchronized Long getNextSequenceByType(String type) {
		
		IdSequenceGenerator isg = new IdSequenceGenerator();
		Boolean lockAcquired = true;
		Integer count =0;
		LOGGER.info("Req for updating lock : ",type);
		while(lockAcquired){
			lockAcquired = idSequenceGeneratorRepository.insertReleaseLock(type, true); //insert lock
			if(lockAcquired) {
				LOGGER.info("Lock inserted : ",type);
				isg = idSequenceGeneratorRepository.findByType(type);
				if(isg != null) {
					
					isg.setSequence(isg.getSequence()+1);
					idSequenceGeneratorRepository.save(isg);
					idSequenceGeneratorRepository.insertReleaseLock(type, false); //release lock
					LOGGER.info("Lock released :{} - {} ",type,isg.getSequence());
					return isg.getSequence();
				}
				isg = new IdSequenceGenerator();
				isg.setType(type);
				isg.setSequence(AppConstant.INITIAL_SEQUENCE_GENERATOR);
				idSequenceGeneratorRepository.save(isg);
				idSequenceGeneratorRepository.insertReleaseLock(type, false); //release lock
				LOGGER.info("Lock released : {} - {} ",type,isg.getSequence());
				return isg.getSequence();
			}else {
				count++;
				lockAcquired = true;
				LOGGER.info("Lock not found for type {} : in {} attempts",type,count);
			}
		}
		return isg.getSequence();
		
	}

}
