# 📧 GEMMAIL – AI Powered Mail Assistant

Gemmail is an AI-based email reply generator that helps users craft intelligent and context-aware responses in Gmail. It consists of a Spring Boot backend powered by the Gemini API, and a Chrome extension that integrates seamlessly with Gmail's interface.

---

## 🚀 Features

- ✨ AI-generated replies based on received email content
- 🔒 Secure integration using environment-based configuration
- 🧠 Utilizes Google Gemini API for intelligent response generation
- 🧩 Chrome Extension adds "AI Reply" button inside Gmail
- ⚡ Fast, lightweight, and user-friendly

---

## 🛠️ Tech Stack

### 🔧 Backend (Spring Boot)
- Java 17+
- Spring Boot
- RestTemplate (or WebClient)
- Gemini API (Generative Language API)
- Maven

### 💻 Frontend (Chrome Extension)
- JavaScript
- Content Scripts
- Gmail DOM manipulation
- Integration with backend API

---

## 📷 Preview

> _[Add screenshots or GIFs showing the "AI Reply" button and generated response]_  
> _Example:_  
> ![Gemmail Demo](path-to-your-demo.gif)

---

## 📂 Project Structure

Gemmail/
├── Gemmail Backend/ # Spring Boot Application
│ ├── src/
│ ├── pom.xml
│ └── ...
├── chrome-extension/ # Chrome Extension files
│ ├── content.js
│ ├── manifest.json
│ ├── popup.html
│ └── ...
└── README.md

