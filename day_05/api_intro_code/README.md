# How to run this code

### Server

Open the `guessing_game_server` in Intellij and run the `WordGuesserApplication` file.

### Frontend

> This assumes you have `node` installed, which was a prereqruisite of the course. You can check this by typing `node --version` from anywhere in your terminal.

Fron the terminal, make sure to `cd` into the `guessing_game_client` folder, and type `npm install`.

This may take a few minutes to install. Once complete, type `npm run start` and it should open in your browser.

Once the Server is running, you should be able to play the game in the frontend.

### Testing in Postman

If you want to test the endpoints in Postman, firstly make sure the server is running.

These are the available endpoints you can test:

- `POST` http://localhost:8080/games - Start a new game
- `PATCH` http://localhost:8080/games - Guess a letter (Add the letter in the body as JSON)
- `GET` http://localhost:8080/games - Get the game status
- `GET` http://localhost:8080/games/guessed - Get the guessed letters
