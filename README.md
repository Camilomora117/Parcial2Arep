# Parcial 2 AREP

Author: Yesid Camilo Mora Barbosa

### Implementación

Creamos una aplicación de Spark donde tiene el endPoint /collatz que se encarga de verificar La conjetura de Collatz

![image](https://user-images.githubusercontent.com/98135134/229211899-34b93df0-5f1d-4ef9-be55-44cabd81c8e4.png)

Esta implementación corre por el puerto 42000

![image](https://user-images.githubusercontent.com/98135134/229212121-fc8b198a-cfe8-43c2-b2b7-0423478589c3.png)

La solucion de la conjetura de collatz es un ciclo wile que verifica hasta que el numero sea diferente de 1.

![image](https://user-images.githubusercontent.com/98135134/229212264-04c1e11f-e055-4db6-a2d6-9d6cd6877e26.png)


### Docker Hub

Subimos la imagen local de docker a un repositorio de Docker Hub

Imagen local:

![image](https://user-images.githubusercontent.com/98135134/229212426-f6d210c1-4b76-42ec-8a87-676ed4ac507e.png)

Repositporio DockerHub:

![image](https://user-images.githubusercontent.com/98135134/229211794-f0158a17-79d5-4a80-9d65-b810af518134.png)


## AWS

### 1. Creamos una instancia de EC2

![image](https://user-images.githubusercontent.com/98135134/229209949-f40174a1-74e6-42d1-a946-ad11c937b1f9.png)

### 2. Entramos a la consola de la instancia e instalamos Docker

```
sudo yum update -y
sudo yum install docker
```

![image](https://user-images.githubusercontent.com/98135134/229210458-fbcb5c71-ceb7-4edd-aa4a-49757f458924.png)


### 3. Corremos docker

```
sudo service docker start
```

![image](https://user-images.githubusercontent.com/98135134/229210656-42cd80fe-db3f-4af7-8e62-2b02ca740912.png)

### 4. Creamos una instancia de un contenedor docker enlazado con el docker hub

```
docker run -d -p 42000:6000 --name collatz camilomora117/web
```

![image](https://user-images.githubusercontent.com/98135134/229211068-97d872c4-f448-4b29-8117-8ab911c2dbef.png)

### 5. Abrimos los puerto que utilizaremos

![image](https://user-images.githubusercontent.com/98135134/229211263-393b9acd-eb06-436f-8459-60d8d1b21c02.png)


### Pruebas

Abrimos la api con el dns y el puerto que le dimos (42000)

![image](https://user-images.githubusercontent.com/98135134/229211519-683875c2-94bc-48eb-ad20-2553e0c5fc6b.png)

Realizamos pruebas

![image](https://user-images.githubusercontent.com/98135134/229211572-db040127-d21a-491a-8502-d8556bb0f595.png)


![image](https://user-images.githubusercontent.com/98135134/229211618-d55019b8-5876-4e5f-9129-629c9e9d7279.png)
