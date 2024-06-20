# :core:network module

The Network Module provides a clean and efficient way to interact with network resources, 
abstracting the complexities of network communication and data handling

# Features
* Retrofit Integration: Utilizes Retrofit for network requests, simplifying the process of 
    defining API endpoints and handling responses.

* Kotlin Coroutines: Employs Kotlin Coroutines for asynchronous network operations, ensuring 
efficient and non-blocking execution.

* Data Serialization: Supports data serialization and deserialization using Gson library, 
enabling seamless conversion between JSON and Kotlin data classes.

* Error Handling: Provides a structured approach to handling network errors, including timeouts, 
connection issues, and API-specific errors.

# Module Structure

  The network module is organized into the following components:
* API Interface: Defines the endpoints for the API using Retrofit annotations.
* Network Client: Handles the creation and configuration of the Retrofit instance.
* Repository: Provides an abstraction layer for accessing network data, encapsulating the logic 
  for making API requests and handling responses.
* Data models: Defines the data classes that represent the structure of the data received 
  from the server.
