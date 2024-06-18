# User Registration and Login using JWT in Spring Boot

This project demonstrates how to implement user registration and login functionality using JSON Web Tokens (JWT) in a Spring Boot application. The application secures API endpoints by requiring JWT authentication and offers various services tailored for agricultural needs.

## Features

- User registration
- User login
- JWT-based authentication
- Secure API endpoints

## Services

- **Crop Suggestions**: Recommendations based on climate, soil, rainfall level, season, etc.
- **Crop Waste Selling**: Platform for selling agricultural waste.
- **Live Weather Telecasting**: Real-time weather updates for better farming decisions.
- **Feedback**: Collect and manage user feedback.
- **Update Profile**: Users can update their profiles.

## Prerequisites

- Java 8 or higher
- Maven or Gradle
- Spring Boot

## Getting Started

### Setup

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/yourrepository.git
    cd yourrepository
    ```

2. **Configure the application:**
    - Update `application.properties` with your database configuration and other settings.

3. **Build the project:**
    ```bash
    ./mvnw clean install
    ```

4. **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```

## Endpoints

### Authentication

- **Register a new user:**
    ```http
    POST http://localhost:8081/auth/signup
    ```
    **Request Body:**
    ```json
    {
      "id": 1,
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "password": "encryptedPassword",
      "role": "farmer",
      "phoneNumber": "1234567890",
      "AdharNumber": "1234-5678-9012",
      "State": "Maharashtra",
      "District": "Pune",
      "location": "Pune, Maharashtra"
    }
    ```

- **Login:**
    ```http
    POST http://localhost:8081/auth/login
    ```
    **Request Body:**
    ```json
    {
        "email": "tarun@gmail.com",
        "password": "123456"
    }
    ```
    **Response:**
    ```json
    {
        "token": "your-jwt-token"
    }
    ```

### Crop Suggestions

- **Get crop suggestions based on query:**
    ```http
    GET http://localhost:8081/crop?query=l
    ```
    **Response:**
    ```json
    [
        {
            "id": 1,
            "cropName": "Rice",
            "cropType": "Cereal",
            "cropVariety": "Long-grain",
            "cropSeason": "Summer",
            "cropSoil": "Clay",
            "cropFertilizer": "Organic",
            "cropIrrigation": "High",
            "cropDisease": "Blast",
            "cropPesticide": "Insecticide",
            "cropHarvesting": "Rice huller",
            "cropClimate": "Tropical",
            "rainFall": 2000,
            "cropImage": "https://cdn.britannica.com/89/140889-050-EC3F00BF/Ripening-heads-rice-Oryza-sativa.jpg"
        },
        {
            "id": 2,
            "cropName": "Rice",
            "cropType": "Cereal",
            "cropVariety": "Long-grain",
            "cropSeason": "Summer",
            "cropSoil": "Clay",
            "cropFertilizer": "Organic",
            "cropIrrigation": "High",
            "cropDisease": "Blast",
            "cropPesticide": "Insecticide",
            "cropHarvesting": "Rice huller",
            "cropClimate": "Tropical",
            "rainFall": 2000,
            "cropImage": "https://cdn.britannica.com/89/140889-050-EC3F00BF/Ripening-heads-rice-Oryza-sativa.jpg"
        },
        {
            "id": 3,
            "cropName": "Tomato",
            "cropType": "Vegetable",
            "cropVariety": "Cherry",
            "cropSeason": "Year-round",
            "cropSoil": "Sandy loam",
            "cropFertilizer": "Balanced",
            "cropIrrigation": "Regular",
            "cropDisease": "Late blight",
            "cropPesticide": "None",
            "cropHarvesting": "Hand-picking",
            "cropClimate": "Temperate to warm",
            "rainFall": 800,
            "cropImage": "https://seed2plant.in/cdn/shop/products/tomatoseeds.jpg?v=1604033216"
        },
        {
            "id": 4,
            "cropName": "Wheat",
            "cropType": "Cereal",
            "cropVariety": "Winter wheat",
            "cropSeason": "Winter",
            "cropSoil": "Loam",
            "cropFertilizer": "Nitrogen-based",
            "cropIrrigation": "Moderate",
            "cropDisease": "Rust",
            "cropPesticide": "Herbicide",
            "cropHarvesting": "Combine harvester",
            "cropClimate": "Temperate",
            "rainFall": 400,
            "cropImage": "https://5.imimg.com/data5/ST/QW/MY-38700875/fresh-wheat-crop-1000x1000.jpg"
        },
    
    ]
    ```

### Crop Waste Selling

- **Sell crop waste:**
    ```http
    POST http://localhost:8081/crop_waste
    ```
    **Request Body:**
    ```json
    {
        "id": 1,
        "typeOfWaste": "Rice husk",
        "Quantity": "100kg",
        "expected_Price": "2000 INR",
        "cropId": 1,
        "farmerId": 101
    }
    ```



### Crop Waste Selling

- **Sell crop waste:**
    ```http
    POST http://localhost:8081/api/crops
    ```
    **Request Body:**
    ```json
    {
        "cropName": "Rice Husk",
        "quantity": 100
    }
    ```

- **Get user's crop waste listings:**
    ```http
    GET http://localhost:8081/api/crops/user
    ```
    **Response:**
    ```json
    [
        {
            "cropName": "Rice Husk",
            "quantity": 2386
        },
        {
            "cropName": "Wheat Straw",
            "quantity": 98765578
        },
        {
            "cropName": "Corn Cobs",
            "quantity": 300
        },
        {
            "cropName": "Tobacco Crop Residues",
            "quantity": 1000
        },
        {
            "cropName": "Cotton Stalks and Leaves",
            "quantity": 500
        },
        {
            "cropName": "Sugarcane Bagasse",
            "quantity": 500
        }
    ]
    ```



### Live Weather Telecasting

- **Get live weather updates:**
    ```http
    GET http://localhost:8081/weather/live
    ```

### Feedback

- **Submit feedback:**
    ```http
    POST http://localhost:8081/feedback
    ```
    **Request Body:**
    ```json
    {
        "id": 1,
        "userId": 101,
        "feedbackText": "Great service!",
        "rating": 5
    }
    ```

### Profile

- **Update profile:**
    ```http
    PUT http://localhost:8081/profile/update
    ```
    **Request Body:**
    ```json
    {
        "id": 101,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com",
        "phoneNumber": "1234567890",
        "AdharNumber": "1234-5678-9012",
        "State": "Maharashtra",
        "District": "Pune",
        "location": "Pune, Maharashtra"
    }
    ```

## Security

The application uses JWT for securing the API endpoints. Ensure to keep your JWT secret key safe and secure. 

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
