package com.meghashyam.banksearch.controller;

import com.meghashyam.banksearch.model.Banksearch;
import com.meghashyam.banksearch.service.LimitOffsetSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class BanksearchController {
    @Autowired
    private LimitOffsetSortService limitOffsetSortService;

    @GetMapping(value = "/")
    public ResponseEntity index1() {

        return ResponseEntity.ok().body("Welcome! Queries need to be sent in the format /api/branches?q=QUERY&limit=LIMIT&offset=OFFSET or" +
                " in the format /api/branches/autocomplete?q=QUERY&limit=LIMIT&offset=OFFSET");
    }

    @GetMapping(value = "/api")
    public ResponseEntity index2() {

        return ResponseEntity.ok().body("Welcome! Queries need to be sent in the format /api/branches?q=QUERY&limit=LIMIT&offset=OFFSET or" +
                " in the format /api/branches/autocomplete?q=QUERY&limit=LIMIT&offset=OFFSET");
    }

    @GetMapping(value = "/api/branches", params = {"q", "limit", "offset"})
    @ResponseBody

    public Page<Banksearch> findJsonDataByKeyword(@RequestParam("q") String q,
                                                  @RequestParam("limit") int limit,
                                                  @RequestParam("offset") long offset) {
        Page<Banksearch> list = limitOffsetSortService.findJsonDataByKeyword(q, limit, offset);
        return list;

    }

    @GetMapping(value = "/api/branches/autocomplete", params = {"q", "limit", "offset"})
    @ResponseBody

    public Page<Banksearch> findJsonDataByBranchPrefix(@RequestParam("q") String q,
                                                       @RequestParam("limit") int limit,
                                                       @RequestParam("offset") long offset) {
        Page<Banksearch> list = limitOffsetSortService.findJsonDataByBranchPrefix(q, limit, offset);
        return list;

    }
}

