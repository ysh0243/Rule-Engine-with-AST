package com.example.rule_engine;



import com.example.rule_engine.model.Rule;
import com.example.rule_engine.service.RuleEvaluator;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RuleEngineBackendApplicationTests {

	private final RuleEvaluator ruleEvaluator = new RuleEvaluator();

	@Test
	public void testEvaluateSingleRuleTrue() {
		Rule rule = new Rule("Test Rule", "age > 30 AND department = 'Sales'");
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("age", 35);
		attributes.put("department", "Sales");

		// Evaluate the rule
		boolean result = ruleEvaluator.evaluate(rule, attributes);
		assertTrue(result); // Expecting true
	}

	@Test
	public void testEvaluateSingleRuleFalse() {
		Rule rule = new Rule("Test Rule", "age > 30 AND department = 'Sales'");
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("age", 25);
		attributes.put("department", "Sales");

		// Evaluate the rule
		boolean result = ruleEvaluator.evaluate(rule, attributes);
		assertFalse(result); // Expecting false
	}

	@Test
	public void testEvaluateCombinedRuleTrue() {
		Rule rule = new Rule("Combined Rule", "((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing'))");
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("age", 32);
		attributes.put("department", "Sales");

		// Evaluate the rule
		boolean result = ruleEvaluator.evaluate(rule, attributes);
		assertTrue(result); // Expecting true
	}

	@Test
	public void testEvaluateCombinedRuleFalse() {
		Rule rule = new Rule("Combined Rule", "((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing'))");
		Map<String, Object> attributes = new HashMap<>();
		attributes.put("age", 22);
		attributes.put("department", "Sales");

		// Evaluate the rule
		boolean result = ruleEvaluator.evaluate(rule, attributes);
		assertFalse(result); // Expecting false
	}
}
