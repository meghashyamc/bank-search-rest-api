package com.meghashyam.banksearch.controller;

import com.meghashyam.banksearch.model.Banksearch;
import com.meghashyam.banksearch.service.LimitOffsetSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")

public class BanksearchController {
    @Autowired
    private LimitOffsetSortService limitOffsetSortService;

    @GetMapping(value = "/branches", params = {"q", "limit", "offset"})
    @ResponseBody

    public Page<Banksearch> findJsonDataByKeyword(@RequestParam("q") String q,
                                                  @RequestParam("limit") int limit,
                                                  @RequestParam("offset") long offset) {
        Page<Banksearch> list = limitOffsetSortService.findJsonDataByKeyword(q, limit, offset);
        return list;

    }

    @GetMapping(value = "/branches/autocomplete", params = {"q", "limit", "offset"})
    @ResponseBody

    public Page<Banksearch> findJsonDataByBranchPrefix(@RequestParam("q") String q,
                                                       @RequestParam("limit") int limit,
                                                       @RequestParam("offset") long offset) {
        Page<Banksearch> list = limitOffsetSortService.findJsonDataByBranchPrefix(q, limit, offset);
        return list;

    }
}

