import React, { useState } from 'react';
import './App.css';

function App() {
    const [attributes, setAttributes] = useState({
        age: '',
        department: '',
        salary: '',
        experience: '',
    });
    const [selectedRule, setSelectedRule] = useState('rule1');
    const [result, setResult] = useState('');

    // Define the available rules as strings
    const rules = {
        rule1: "((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)",
        rule2: "((age > 30 AND department = 'Marketing')) AND (salary > 20000 OR experience > 5)"
    };

    // Handle input changes for user attributes
    const handleChange = (e) => {
        setAttributes({ ...attributes, [e.target.name]: e.target.value });
    };

    // Handle rule selection
    const handleRuleChange = (e) => {
        setSelectedRule(e.target.value);
    };

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();

        // Combine the selected rule and user attributes for backend evaluation
        const requestData = {
            rule: rules[selectedRule],
            attributes: attributes
        };

        try {
            const response = await fetch('/api/rules/evaluate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(requestData),
            });
            const data = await response.json();
            setResult(data.eligible ? 'Eligible' : 'Not Eligible');
        } catch (error) {
            console.error('Error:', error);
            setResult('Error.');
        }
    };

    return (
        <div className="App">
            <h1>User Eligibility Checker</h1>

            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="rule-select">Select a Rule:</label>
                    <select id="rule-select" value={selectedRule} onChange={handleRuleChange}>
                        <option value="rule1">Rule 1: Age & Department & Salary</option>
                        <option value="rule2">Rule 2: Age & Department (Marketing) & Salary</option>
                    </select>
                </div>

                <input type="number" name="age" placeholder="Age" onChange={handleChange} required />
                <input type="text" name="department" placeholder="Department" onChange={handleChange} required />
                <input type="number" name="salary" placeholder="Salary" onChange={handleChange} required />
                <input type="number" name="experience" placeholder="Experience (Years)" onChange={handleChange} required />
                
                <button type="submit">Check Eligibility</button>
            </form>

            {result && <h2>{result}</h2>}
        </div>
    );
}

export default App;

