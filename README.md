🏦 Smart ATM Management System (Java)
A GUI-based Smart ATM Management System built using Java Swing. This project simulates an ATM interface for both users and admins, handling data via CSV files and utilizing file handling techniques for storing and managing user accounts, transactions, and administrative operations.

📌 Features
👤 User Controls:
Login via account credentials.

Balance inquiry.

Cash withdrawal.

Cash deposit.

PIN change.

Transaction history view.

🛠️ Admin Controls:
Admin login panel.

View all user accounts.

Add new user accounts.

Delete or modify existing accounts.

Export and manage user data via CSV.

📂 Project Structure
Smart-ATM-Java/
│
├── jxl-2.6.jar                # External library for Excel/CSV operations
├── out/production/ATM/        # Compiled class files
├── src/                       # Source files
│   ├── ATM.java               # Main ATM operation logic
│   ├── ATMFrames.java         # GUI for ATM operations
│   ├── Admin.java             # Admin control logic
│   ├── AdminFrames.java       # GUI for Admin operations
│   ├── Data.csv               # CSV file containing account data
│   ├── Functions.java         # Helper functions and utilities
│   ├── Main.java              # Program entry point
│   └── (Images & other assets)
│
├── ATM.iml                    # IntelliJ project file
├── README.md                  # Project description and documentation
🖥️ Technologies Used
Java SE 8+

Java Swing (GUI)

File Handling (CSV)

JXL (jxl-2.6.jar) for CSV/Excel operations

IntelliJ IDEA (recommended)

📝 How to Run
Clone this repository.

bash
Copy
Edit
git clone https://github.com/yourusername/Smart-ATM-Java.git
Open the project in IntelliJ IDEA.

Add jxl-2.6.jar to your project’s libraries.

Run Main.java.

Use the GUI to interact as a User or Admin.

📊 Data Storage
User account data and transactions are maintained in a Data.csv file.

File handling operations are used to read, write, and update this data based on ATM interactions.

📷 Screenshots
(Add GUI screenshots here for better presentation)

📃 License
This project is open-source for educational and learning purposes.

