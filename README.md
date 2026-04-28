🛒 E-Commerce Microservices Architecture (Spring Boot)

📌 Overview

This Application demonstrates a **Microservices Architecture** using **Spring Boot**. It includes multiple independent services communicating via REST APIs, with service discovery and centralized routing.

🔧 Microservices Included:

* 🧾 Order Service
* 📦 Product Service
* 🧭 Eureka Server (Service Discovery)
* 🌐 API Gateway

⚙️ Tech Stack

* Java 17+
* Spring Boot
* Spring Cloud Netflix Eureka
* Spring Cloud Gateway
* REST APIs
* Maven
* MySQL / H2 Database

📂 Project Structure

```bash
ecom-microservices/
│── eureka-server/
│── api-gateway/
│── product-service/
│── order-service/
│── README.md
```

🔄 How It Works

1. All services register with **Eureka Server**
2. API Gateway acts as a **single entry point**
3. Requests are routed to respective services
4. Load balancing distributes requests
5. Each service has its own database


🚀 Setup & Installation

1️⃣ Clone the Repository

```bash
git clone  https://github.com/shivaitofficial/Ecommerce-Springboot-Microservice.git
cd ecom-microservices
```

---

2️⃣ Start Services in Order

⚠️ Important: Follow this order

▶️ Step 1: Start Eureka Server

```bash
cd eureka-server
mvn spring-boot:run
```

* Runs on: `http://localhost:8761`

---

▶️ Step 2: Start Product Service

```bash
cd product-service
mvn spring-boot:run
```

* Registers with Eureka

---

▶️ Step 3: Start Order Service

```bash
cd order-service
mvn spring-boot:run
```

* Communicates with Product Service

---

▶️ Step 4: Start API Gateway

```bash
cd api-gateway
mvn spring-boot:run
```

* Entry point: `http://localhost:8080`

---

🔗 API Endpoints (via Gateway)

📦 Product Service

* `GET /product/all`
* `POST /product/add`

🧾 Order Service

* `GET /order/all`
* `POST /order/create`

---

📡 Service Registration (Eureka)

Visit:

```
http://localhost:8761
```

You should see:

* PRODUCT-SERVICE
* ORDER-SERVICE
* API-GATEWAY

---

⚖️ Load Balancing

* Implemented via Spring Cloud (Client-side load balancing)
* Requests are distributed across service instances

---

🗄️ Database Configuration

### Example (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```

---

🔐 Configuration Highlights

Eureka Client (for services)

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

API Gateway Routes

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: product-service
          uri: lb://PRODUCT-SERVICE
          predicates:
            - Path=/product/**

        - id: order-service
          uri: lb://ORDER-SERVICE
          predicates:
            - Path=/order/**
```

---

🧪 Testing the Application

Use tools like:

* Postman
* cURL

Example:

```bash
curl http://localhost:8080/product/all
```

---

📌 Key Features

* ✅ Microservices architecture
* ✅ Service discovery using Eureka
* ✅ Centralized routing via API Gateway
* ✅ Independent deployment
* ✅ Scalable & maintainable

---
⚠️ Notes

* Ensure all ports are free before running
* Start Eureka first
* Use consistent service names (uppercase recommended)



Regards
Sivakumar Selvam
GitHub:  https://github.com/shivaitofficial/Ecommerce-Springboot-Microservice.git
