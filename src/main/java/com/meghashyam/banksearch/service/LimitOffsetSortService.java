package com.meghashyam.banksearch.service;

import com.meghashyam.banksearch.model.Banksearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LimitOffsetSortService {

    @Autowired
    private BanksearchRepository banksearchRepository;

    public Page<Banksearch> findJsonDataByKeyword(String q, int limit, long offset) {


        Pageable pageable = new OffsetPageRequest(limit, offset);
        Page<Banksearch> data = banksearchRepository.findByKeyword(q, pageable);
        return data;
    }

    public Page<Banksearch> findJsonDataByBranchPrefix(String q, int limit, long offset) {


        Pageable pageable = new OffsetPageRequest(limit, offset);
        Page<Banksearch> data = banksearchRepository.findByBranchPrefix(q, pageable);
        return data;
    }
}
