# Assignment 1 — Health Service Daily Appointment Booking System
Student Name: Qianhuan Feng
Student ID: 25258622

## Project Overview
Java console‑based appointment booking system, demonstrates OOP including abstract class, inheritance, polymorphism, encapsulation and Comparable sorting.

### Health Professional Types
‑ General Practitioner (GP)
‑ Specialist
‑ Nurse
‑ Dietitian

### Core Features
1. Create different health‑professional objects (Part 3 polymorphism requirement)
2. Add appointment with time‑slot validation and duplicate‑booking conflict check
3. View all appointments sorted chronologically by time
4. Filter appointments by health‑professional ID
5. Filter appointments by patient mobile phone number
6. Cancel single appointment by professional ID + time slot
7. Cancel all appointments for one patient by mobile number

### Error Test‑Cases (Shown in demonstration video)
1. Double‑booking: reject booking when same health professional already occupied that time slot
2. Invalid cancellation: warning when trying to cancel non‑existent appointment

### How to run
Run main class `AssignmentOne.java`.
