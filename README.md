# Ratings

This program is designed to function based on POST requests obtained from totems. The graphical interface is used solely for viewing the ratings.

JAVA server + database + evaluation summary interface


## Prerequisites

- Java 17
- Maven
- A MariaDB/MySQL database

## Configuration

1. Clone the repository:
    ```sh
    git clone https://github.com/aSamu3l/Ratings.git
    cd Ratings
    ```

2. Configure the database:
    - Create a MariaDB database named `ratings`.
    - Update the database credentials in the [application.properties](src/main/resources/application.properties) file:
        ```properties
        spring.datasource.url = jdbc:mariadb://localhost:3306/ratings
        spring.datasource.username = <your-username>
        spring.datasource.password = <your-password>
        ```

3. Generate an API token and update it in the [application.properties](src/main/resources/application.properties) file:
    ```properties
    api.token=your_generated_token
    ```

## Build and Run

### Windows

1. Build the project with Maven:
    ```sh
    ./mvnw clean install
    ```

2. Run the application:
    ```sh
    ./mvnw spring-boot:run
    ```

### Linux

1. Build the project with Maven:
    ```sh
    mvn package
    ```

2. Run the application:
    ```sh
    java -jar ./ratings-0.0.1-SNAPSHOT.jar --spring.config.location=file:./application.properties
    ```

## Usage

### API Endpoints

- **Add a rating**
    ```http
    POST /add
    ```
    - Headers:
        - `Authorization: your_generated_token`
    - Body (JSON):
        ```json
        {
            "rating": 3,
            "totem": "totem1"
        }
        ```
### Web Interface Endpoints

- **View today ratings**
    ```http
    GET /
    ```

- **View today ratings by totem**
    ```http
    GET /?totem=<totem_name>
    ```
    
- **View all ratings**
    ```http
    GET /all
    ```

- **View all ratings by totem**
    ```http
    GET /?totem=<totem_name>
    ```

- **View all ratings by day**
    ```http
    GET /?day=<ddmmyyyy>
    ```

- **View all ratings by day and totem**
    ```http
    GET /?totem=<totem_name>&day=<ddmmyyyy>
    ```

### Web Interface

- Access the web interface to view the ratings:
    ```
    http://localhost:8083/
    ```
- You can change the port by updating the `server.port` property in the [application.properties](src/main/resources/application.properties) file:
    ```properties
    server.port=8083
    ```

## License

This project is licensed under the Apache-2.0 license. See the [LICENSE](LICENSE) file for details.