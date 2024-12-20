# Pretty Notes app (Backend)

An intuitive, minimalist and functional note-making app for seamless note-taking. 🗒️

## What It Does

This is a SpringBoot API service with a PostgreSQL DB Server, that acts as the Backend for [this](https://github.com/dejah22/Notemaking-app-frontend) React Application

- Provides functionality to `View`, `Add`, `Edit`, or `Delete` notes, and to `Label` up and `Search` (find Note by Label) each note.
- Each note is `coloured` 🎨 according to user input, and organised using labels for a productive management.
- It also offers a `Pin/Unpin` feature 📌, where your most important notes for the day can be pinned to the top, away from all the clutter.
- Notes are sorted and displayed based on the last modified date.

## Tech Stacks used

The React UI (you can find it [here](https://github.com/dejah22/Notemaking-app-frontend)) connects to this hosted SpringBoot API Service. A Postgres Server is setup to store all notes, and connected to from the SpringBoot app.
This Backend service has been developed separetely and exposed to external clients, using a free Ngrok tunnel.

## Instructions

The repo follows a simple and intuitive structure.

### Setting up -

1. Setup PostgreSQL and IntelliJ in your local system.
2. Clone this repository using `git clone <Repo-URL>`.
3. Create the necessary tables as can be inferred from the [Models](https://github.com/dejah22/Notemaking-app-server/tree/main/src/main/java/com/example/google_notes/model) folder.
4. Once the Postgre Server is setup and running, you can connect it to the API Service by updating your URL, username and password in [application.properties](https://github.com/dejah22/Notemaking-app-server/blob/main/src/main/resources/application.properties)
5. Run the Application.java file, and now you're set!
6. You can test the APIs using a Postman account.

### Connecting with the UI

### Method 1: Setup Both on your Local system
1. To connect with the UI, clone [this](https://github.com/dejah22/Notemaking-app-frontend) repo on you local system.
2. Update the URLs in the axios calls with your local URL.

### Method 2: Setup Backend on a Separate system
1. If you're setting up your Frontend and Backend applications on 2 separate machines, the Backend API Service needs to be exposed to the Frontend.
2. Create a free Ngrok account [here](https://ngrok.com).
4. Expose your local server to the internet using your Ngrok link
5. Update the URLs in the axios calls with your Ngrok tunnel URL.

Your Pretty Notes app is all set to be used!


## Contributions

Contributions are what make this open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks! <3

1. Fork the Project
2. Create your Feature Branch (git checkout -b feature/AmazingFeature)
3. Commit your Changes (git commit -m 'Add some AmazingFeature')
4. Push to the Branch (git push origin feature/AmazingFeature)
5. Open a Pull Request
