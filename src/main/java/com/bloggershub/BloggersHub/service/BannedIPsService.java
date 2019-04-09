package com.bloggershub.BloggersHub.service;

import com.bloggershub.BloggersHub.model.BannedIPs;

import java.util.List;

public interface BannedIPsService {
    List<BannedIPs> findAll();
}
