package com.schoolwork.agentordersproject.repos;

import com.schoolwork.agentordersproject.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepo extends CrudRepository<Agent, Long> {
    Agent getByAgentcode(long agentcode);
}
