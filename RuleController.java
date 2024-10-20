package com.example.rule_engine.controller;

import com.example.rule_engine.model.Rule;
import com.example.rule_engine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @PostMapping
    public Rule createRule(@RequestBody Rule rule) {
        return ruleService.saveRule(rule);
    }

    @GetMapping
    public List<Rule> getAllRules() {
        return ruleService.getAllRules();
    }

    @GetMapping("/{id}")
    public Rule getRuleById(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
    }
}
