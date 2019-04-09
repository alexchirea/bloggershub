package com.bloggershub.BloggersHub.service;

import com.bloggershub.BloggersHub.model.BannedIPs;
import com.bloggershub.BloggersHub.repository.BannedIPsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BannedIPsServiceImpl implements BannedIPsService {

    @Autowired
    private BannedIPsRepository bannedIPsRepository;

    @Override
    public List<BannedIPs> findAll() {
        return bannedIPsRepository.findAll();
    }
}
