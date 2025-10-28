# Server-Driven UI Platform Demo

This project is a **Mini Picnic Page Platform (PPP Demo)**, inspired by [Picnic’s Picnic Page Platform (PPP)](https://blog.picnic.nl/picnic-10-years-2022-building-a-store-platform-to-scale-beyond-a-million-customers-89bb8ee1bb55).

It demonstrates, on a small scale, how a backend can **generate dynamic pages entirely through configuration**, while the frontend acts as a **generic rendering engine** — mirroring Picnic’s server-driven UI architecture.

---

## Core Concept

**Define → Extract & Transform → Present**

| PPP Component | Implemented As |
|----------------|----------------|
| **Attribute Data Store (ADS)** | H2 / in-memory database storing dynamic attributes (text, queries, etc.) |
| **Query Engine** | Simple service executing SQL queries |
| **Page Compiler** | Transforms raw page configurations into compiled page definitions at startup |
| **Page Renderer** | Hydrates pages with attribute values and query results at request time |
| **Frontend** | A generic React app that interprets backend JSON responses and renders them |

---

## Tech Stack

- **Backend:** Java 21, Spring, H2  
- **Frontend:** React  
- **Build Tool:** Maven
  
---

## How It Works

Raw page configs are defined in Java (for now).  
At startup, they are **compiled** into structured `PageDefinition` objects.

**Flow:**
- Raw Page → compiled once into a PageDefinition  
- PageDefinition → hydrated with live data from ADS + QueryEngine into a Page 
- Frontend → fetches Page JSON and renders it dynamically  

---


## Example Flow

1. Raw Page defined in Java:
    ```java
    new RawPage("home", List.of(
        new RawComponent("Header", Map.of("title", "Welcome!")),
        new RawComponent("Banner", Map.of("attr", "bannerTextAttr")),
        new RawComponent("Grid", Map.of("query", "featuredProductsSQL"))
    ));
    ```
2. Attributes in DB:
    | Name | Type | Value |
    |------|------|-------|
    | featuredProductsSQL | SQL | `SELECT * FROM products WHERE featured = true` |
    | bannerTextAttr | STRING | Featured Products Today |


4. Renderer compiles → hydrates → returns JSON:
    ```json
    {
      "name": "home",
      "components": [
        { "type": "Header", "props": { "title": "Welcome!" } },
        { "type": "Banner", "props": { "text": "Featured Products Today" } },
        { "type": "Grid", "props": { "data": [ { "name": "Milk" } ] } }
      ]
    }
    ```

5. The frontend interprets this configuration and renders it as
   [Header Component] [Banner Component] [Grid Component]

---

## Running the Demo

```bash
# clone
git clone https://github.com/youssefmagdyy/server-driven-ui-demo.git
cd server-driven-ui-demo

# run server
./mvnw spring-boot:run

# run client
cd client
npm start
```

