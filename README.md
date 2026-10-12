# MSS Cinema Online Ticket System

A Java console program for booking cinema tickets. Customers log in, pick a movie, showtime, seats and an optional food set, and get a receipt with the total price. Admins can log in to update movie details.

Group project for CSC186 (Object-Oriented Programming), Diploma in Computer Science, UiTM Perlis. July 2023. Built with two classmates. I was the team leader and worked on the coding and the report introduction.

## Demo

[[Watch the demo]](https://youtu.be/PN6JlgJoAMU)

## How it works

1. The user chooses customer or admin login.
2. A customer logs in or registers a new account.
3. They choose a Gold or Premiere ticket, a movie, the number of adults, children and students, their seats and a showtime.
4. They can add a food set, and Premiere customers can choose to buy merchandise.
5. The program prints a receipt with the total. Registered members get 30% off their tickets.

Movies, customer accounts and admin accounts are all read from text files, so the data can be changed without touching the code.

## Classes

| Class | Purpose |
|---|---|
| `Ticket` | Abstract superclass holding the booking details |
| `GoldTicket` | Subclass with Gold ticket prices |
| `PremiereTicket` | Subclass with Premiere prices and the merchandise option |
| `Customer` | Customer account and login check |
| `Admin` | Admin account and login check |
| `MovieInfo` | Movie title, rating, genre, director, cast and showtimes |
| `TicketApp` | Main program: menus, seat layout, food menu and receipt |

`GoldTicket` and `PremiereTicket` each override `calcPrice()`, so the program calculates the price the same way whichever ticket type is chosen. The UML class and use case diagrams are in `docs/`.

## Running it

```bash
cd src
javac *.java
java TicketApp
```

Run it from inside `src` so the program can find the text files.

Demo logins:
- Customer (member): `demo_member` / `demo123`
- Customer (non-member): `demo_user` / `demo456`
- Admin: `admin` / `admin123`

## Files

- `src/` – Java source code and the text files it reads (`movie.txt`, `registeredUser.txt`, `admin.txt`)
- `docs/project_report.pdf` – full report with code, UML diagrams and sample output
- `docs/uml_presentation.pdf` – UML diagram presentation
- `docs/final_presentation.pdf` – final presentation with sample runs

## What I'd change now

Passwords are stored in plain text, and the admin update overwrites `movie.txt` with only the movie being edited, so the other movies get deleted. The merchandise charge is also applied the wrong way round (when the customer says no). I'd fix those, check that seats aren't already booked, and save each booking to a file.
