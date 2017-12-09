package com.cares.service.impl;

import com.cares.service.ScheduleTaskMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service()
public class ScheduleTaskMonitorServiceImpl implements ScheduleTaskMonitorService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskMonitorServiceImpl.class);

    @Override
    public void monitorTask() {
        logger.info(new Date().getTime() + "");
    }
}
