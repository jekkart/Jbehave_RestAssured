REST API - Create user

Scenario: Successful user creation

Given Request body:
{
    "name": "<name>",
    "gender": "<gender>",
    "email": "<email>",
    "status": "<status>"
}
When User performs "POST" request to "/public/v2/users"
Then response status is 201
And response body is not null
And response body contains user id
And response body name is <name>
And response body email is <email>
And response body gender is <gender>

Examples:
| name                 | email                         | gender | status   |
| JBehave RestAssured1 | jbehave.restAssured0@test.org | female | active   |
| JBehave RestAssured2 | jbehave.restAssured2@test.org | male   | inactive |

Scenario: Unsuccessful user creation (user already registered)

Given Request body:
{
    "name": "Tenali Ramakrishna",
    "gender": "male",
    "email": "tenali.ramakrishna@15ce.com",
    "status": "active"
}
When User performs "POST" request to "/public/v2/users"
Then response status is 422
And response body is not null
And response body contains error field: email
And response body contains error message: has already been taken
