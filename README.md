# Server-Driven UI Platform Demo

This project is a **Mini Picnic Page Platform (PPP Demo)**, inspired by [Picnic’s Picnic Page Platform (PPP)](https://blog.picnic.nl/picnic-10-years-2022-building-a-store-platform-to-scale-beyond-a-million-customers-89bb8ee1bb55).

It demonstrates, on a small scale, how a backend can **generate dynamic pages entirely through configuration**, while the frontend acts as a **generic rendering engine** — mirroring Picnic’s server-driven UI architecture.

---

## 🧭 Concept

> **Define → Extract & Transform → Present**

| PPP Component | Implemented In This Demo |
|----------------|--------------------------|
| **Attribute Data Store (ADS)** | In-memory / H2 database for configurable attributes |
| **Query Engine** | Simple service combining attributes into datasets |
| **Page Framework** | Frontend that renders pages from backend JSON descriptors |
| **Configuration Tooling** | REST endpoints to define new attributes or pages without redeploys |

---

## ⚙️ Tech Stack

- **Backend:** Java 21, Spring Boot, Spring Web, Spring Data JPA, H2  
- **Frontend:** Vanilla JavaScript (static page in `/static/index.html`)  
- **Build Tool:** Maven  
- **Run:** `./mvnw spring-boot:run`

---

## 🚀 How It Works

1. The **Spring Boot backend** exposes an API (`/api/pages/{id}`) that returns a JSON *page descriptor*.  
2. Each descriptor defines a list of **components** (`text`, `image`, `button`, etc.) and their properties.  
3. The **frontend** fetches this JSON and renders it dynamically — no hard-coded UI or layouts.  
4. New **pages or attributes** can be added at runtime via REST endpoints, with zero frontend changes.

---

## 🧩 Example

```json
{
  "id": "1",
  "title": "Welcome to PPP Demo!",
  "components": [
    { "type": "text", "props": { "text": "This page is defined by the backend!" } },
    { "type": "image", "props": { "url": "https://picsum.photos/300" } },
    { "type": "button", "props": { "text": "Click me!", "action": "/api/hello" } }
  ]
}
```

The frontend interprets this configuration and renders it as:

[Text Component] [Image Component] [Button Component]

Adding a new page requires zero frontend code changes — only a new JSON definition or backend configuration.

## 🧰 Running the Demo

```bash
# clone
git clone https://github.com/<your-username>/mini-picnic-ppp.git
cd mini-picnic-ppp

# run
./mvnw spring-boot:run
```

> 📝 **Note:** You only need Java 17+ installed.  
> The Maven wrapper (`mvnw`) included in the project will automatically download and use the correct Maven version.

