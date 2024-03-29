package com.calpha.hospital.schedule.task;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.calpha.hospital.repository.PasswordResetTokenRepository;
import com.calpha.hospital.repository.VerificationTokenRepository;

@Service
@Transactional
public class ClearTokenTask {

	 @Autowired
	    VerificationTokenRepository tokenRepository;

	    @Autowired
	    PasswordResetTokenRepository passwordTokenRepository;

	    @Scheduled(cron = "${purge.cron.expression}")
	    public void purgeExpired() {

	        Date now = Date.from(Instant.now());

	        passwordTokenRepository.deleteAllExpiredSince(now);
	        tokenRepository.deleteAllExpiredSince(now);
	    }
	
}
