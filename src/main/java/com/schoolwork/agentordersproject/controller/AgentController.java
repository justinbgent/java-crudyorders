package com.schoolwork.agentordersproject.controller;

import com.schoolwork.agentordersproject.model.Agent;
import com.schoolwork.agentordersproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    private Service service;

    // http://localhost:2019/agents/agent/{agentcode}
    @GetMapping(value = "/agent/{agentcode}", produces = {"application/json"})
    ResponseEntity<?> getAgentById(@PathVariable long agentcode){
        Agent agent = service.getAgentById(agentcode);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
}
