
# product-management-backend-with-ui 

This is a **Spring Boot-based Product Management Application** that provides both **REST API endpoints** and a **Thymeleaf-powered UI**. It supports **CRUD operations**, pagination, and database flexibility with **H2, MySQL, or OracleSQL**.  

---

## 🏗️ Functionality  

This application serves as a **complete product management system**, working as both a **backend API** and a **fully functional UI**.  

### **1️⃣ Backend API (Spring Boot + REST API)**  
- Provides **CRUD operations** for managing products  
- Supports **pagination and sorting** for large datasets  
- Uses **Spring Data JPA** for seamless database interactions  
- API is **RESTful** and can be tested via **Postman**  

### **2️⃣ Frontend UI (Spring Boot + Thymeleaf + JavaScript + CSS)**  
- **Dynamic Web Pages** using Thymeleaf  
- **Product Listing Page** with pagination  
- **Add/Edit/Delete Product Pages** with form validation  
- **Responsive Design** for smooth user experience  

### **3️⃣ Database Support (H2, MySQL, OracleSQL)**  
- Default database is **H2 (in-memory, auto-configured)**  
- Can be switched to **MySQL** or **OracleSQL** by modifying `application.properties`  
- Uses **Spring JPA** for managing database operations  

---

## 🚀 Features  
✅ **CRUD Operations**: Create, Read, Update, Delete products  
✅ **Thymeleaf UI**: A functional front-end built using **HTML, CSS, and JavaScript**  
✅ **REST API**: Well-structured API endpoints for seamless backend functionality  
✅ **Pagination Support**: Organized product list with pagination  
✅ **Database Flexibility**: Uses **H2 in-memory DB** but can be switched to **MySQL or OracleSQL**  

---

## 🛠️ Tech Stack  

### **Backend** (Spring Boot)  
- **Spring Boot** – Framework to build Java-based web applications  
- **Spring Web** – Enables building RESTful APIs  
- **Spring Data JPA** – Simplifies database interactions using ORM  
- **Spring Thymeleaf** – Template engine for integrating dynamic content in HTML  

---

## 📦 Installation  

### **Step 1: Clone the Repository**  
```bash
git clone https://github.com/your-username/product-management-system.git
cd product-management-system
```

### **Step 2: Configure Database (Optional)**  
By default, the application runs on H2. To switch to MySQL or OracleSQL, update `application.properties`:  

#### **For MySQL:**  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

#### **For OracleSQL:**  
```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=system
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
```

### **Step 3: Run the Application**  
```bash
mvn spring-boot:run
```

---

## 🌐 API Endpoints  

### **📌 Create a Product**  
**Request:**  
```http
POST /products
```
**Body (JSON Example):**  
```json
{
  "name": "Laptop",
  "price": 1000.00,
  "description": "A high-performance laptop."
}
```

**Response:**  
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 1000.00,
  "description": "A high-performance laptop."
}
```

---

### **📌 Get All Products (with Pagination)**  
**Request:**  
```http
GET /products?page=0&size=5
```

**Response:**  
```json
{
  "content": [
    { "id": 1, "name": "Laptop", "price": 1000.00, "description": "A high-performance laptop." },
    { "id": 2, "name": "Phone", "price": 500.00, "description": "A smartphone with excellent features." }
  ],
  "totalPages": 3,
  "totalElements": 15
}
```

---

### **📌 Get Product by ID**  
**Request:**  
```http
GET /products/1
```

**Response:**  
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 1000.00,
  "description": "A high-performance laptop."
}
```

---

### **📌 Update a Product**  
**Request:**  
```http
PUT /products/1
```
**Body (JSON Example):**  
```json
{
  "name": "Updated Laptop",
  "price": 1200.00,
  "description": "An upgraded high-performance laptop."
}
```

**Response:**  
```json
{
  "id": 1,
  "name": "Updated Laptop",
  "price": 1200.00,
  "description": "An upgraded high-performance laptop."
}
```

---

### **📌 Delete a Product**  
**Request:**  
```http
DELETE /products/1
```

**Response:**  
```json
{
  "message": "Product deleted successfully"
}
```

---

## 🖥️ Testing with Postman  
1. Open **Postman**  
2. Import the API collection (Optional)  
3. Use the API endpoints mentioned above to test CRUD operations  
4. Ensure the backend is running before making requests  

---

## 🎨 UI Implementation with Thymeleaf  
The frontend is built using **Spring Boot + Thymeleaf templates**.  
- **Product List Page (`products.html`)** – Displays paginated products  
- **Add Product Page (`add-product.html`)** – Form to add new products  
- **Edit Product Page (`edit-product.html`)** – Form to update products  

### **Run Frontend**  
1. Start the backend using `mvn spring-boot:run`  
2. Open your browser and go to:  
   ```
   http://localhost:8080/
   ```

---

## 🛠️ Dependencies Used  

| Dependency    | Purpose |
|--------------|---------|
| **Spring Boot** | Core framework for building Java applications |
| **Spring Web** | Enables RESTful API and web functionalities |
| **Spring Data JPA** | Provides ORM support for database interactions |
| **H2 Database** | Default in-memory database for easy testing |
| **Thymeleaf** | Template engine to render dynamic HTML pages |
| **Lombok** | Reduces boilerplate code for models |

---

## 🚀 Future Enhancements  
🔹 **User Authentication & Authorization** (Spring Security)  
🔹 **Export Product Data** (CSV, Excel)  
🔹 **Docker & Kubernetes Deployment**  

---
