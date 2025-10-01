# Astronaut Daily Schedule Organizer

This project is a console-based Java application for daily schedule management, designed for placement interviews and practical demonstration of design patterns.

---

## Features

- Add, remove, and view astronaut tasks interactively.
- Prevents scheduling overlapping/conflicting tasks.
- Task prioritization ("High", "Medium", "Low").
- Implements **Singleton**, **Factory**, and **Observer** patterns.
- Each major class is in its own file and directory.
- Input uses readable commands and 24-hour time format.

---

## Directory Structure

src/
├── app/
│   └── AstronautDailyScheduleOrganizer.java
├── model/
│   └── Task.java
├── service/
│   ├── ScheduleManager.java
│   └── TaskFactory.java
├── observer/
│   ├── Observer.java
│   └── UserNotification.java


---

## How to Use

Commands must be entered in these formats:

- **Add Task:**  
  `Add Task("Morning Exercise", "07:00", "08:00", "High")`
- **Remove Task:**  
  `Remove Task("Morning Exercise")`
- **View Tasks:**  
  `View Tasks`
- **Exit:**  
  `exit`

Start the main class, follow prompts, and type each command line-by-line. The program will notify of successful additions, conflicts, removals, or errors.

---

## How to Run

1. Open the project in IntelliJ IDEA or your preferred Java IDE.
2. Confirm class files are placed in respective folders listed above.
3. Run `app.AstronautDailyScheduleOrganizer`.
4. Interact using specified command formats.

---

## Notes

- Observer notifications print for additions, removals, conflict detection, and errors.
- Time format uses "HH:MM" 24-hr; priorities use only "High", "Medium", "Low".
- Project is modular, follows SOLID principles, and each design pattern is demonstrated in separate package/class.
