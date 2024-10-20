package com.example.rule_engine.service;



import com.example.rule_engine.model.Rule;
import com.example.rule_engine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {
    @Autowired
    private RuleRepository ruleRepository;

    public Rule saveRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    public Rule getRuleById(Long id) {
        return ruleRepository.findById(id).orElse(null);
    }

    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }
}
