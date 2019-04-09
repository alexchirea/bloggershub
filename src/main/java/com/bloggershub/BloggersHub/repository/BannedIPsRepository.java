package com.bloggershub.BloggersHub.repository;

import com.bloggershub.BloggersHub.model.BannedIPs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannedIPsRepository extends JpaRepository<BannedIPs, Long> {
    List<BannedIPs> findAll();
}
