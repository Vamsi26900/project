$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/Demo.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Vamsi Krishna"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 19,
  "name": "PHP Travels",
  "description": "",
  "id": "php-travels",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 21,
  "name": "PHP Travels login",
  "description": "",
  "id": "php-travels;php-travels-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 20,
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "PHP Travels URL opened",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "enter Valid user\"\u003cid\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 24,
      "value": "#  Then Close browser"
    }
  ],
  "line": 25,
  "name": "",
  "description": "",
  "id": "php-travels;php-travels-login;",
  "rows": [
    {
      "cells": [
        "id",
        "Password"
      ],
      "line": 26,
      "id": "php-travels;php-travels-login;;1"
    },
    {
      "cells": [
        "vamsi2787@gmail.com",
        "Vamsi22338"
      ],
      "line": 27,
      "id": "php-travels;php-travels-login;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 27,
  "name": "PHP Travels login",
  "description": "",
  "id": "php-travels;php-travels-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 20,
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "PHP Travels URL opened",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "enter Valid user\"vamsi2787@gmail.com\" and \"Vamsi22338\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 29,
  "name": "New Order",
  "description": "",
  "id": "php-travels;new-order",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@Test1"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "Create Order",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 31,
      "value": "#Then Close browser"
    }
  ],
  "line": 32,
  "name": "End of Scenario",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});