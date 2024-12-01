# Trello API Automation

This project automates interactions with the Trello API using Java and Rest-Assured.

## Features
- Create a Trello board.
- Add two cards to the default list.
- Update a card.
- Delete the cards and the board.

## Prerequisites
1. Java 17 or higher installed.
2. Maven installed.
3. Trello API credentials:  
   - Get API key: https://trello.com/app-key  
   - Generate token: https://trello.com/1/authorize?expiration=never&name=MyApp&scope=read,write&response_type=token&key=YOUR_API_KEY  

## Setup
1. Clone the repository:  
   `git clone https://github.com/your-username/trello-api-automation.git && cd trello-api-automation`  
2. Add your API key and token to `src/main/resources/config.properties`:  
   ```properties
   api.key=YOUR_API_KEY
   api.token=YOUR_API_TOKEN

## Install Dependencies
mvn install

## Run Tests
Run the tests with:
mvn test

## Technologies Used
Java
Rest-Assured
JUnit 5
