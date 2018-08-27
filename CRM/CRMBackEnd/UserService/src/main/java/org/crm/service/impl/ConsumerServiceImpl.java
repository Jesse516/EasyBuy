package org.crm.service.impl;
import org.crm.domain.Consumer;
import org.crm.mapper.ConsumerMapper;
import org.crm.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper conMapper;

    @Override
    public List<Consumer> findByPage() {
        return conMapper.findByPage();
    }

    @Override
    public Consumer findByNo(String cust_no) {
        return conMapper.findByNo(cust_no);

    }

    @Override
    public int updateConsumer(Consumer consumter) {
        return conMapper.updateConsumer(consumter);
    }

    @Override
    public int deleteConsumerByNo(String cust_no) {
        return conMapper.deleteConsumerByNo(cust_no);
    }

    @Override
    public List<Consumer> calculateByLabel() {
        return conMapper.calculateByLabel();
    }

    @Override
    public List<Consumer> calculateBycredit() {
        return conMapper.calculateBycredit();
    }

    @Override
    public List<Consumer> calculateBysatisfy() {
        return conMapper.calculateBysatisfy();
    }

}
