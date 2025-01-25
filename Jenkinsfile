pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'apigateway-service'
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git url: 'https://github.com/appmatchdev/apigateway-service.git', branch: 'main'
            }
        }

        stage('Ejecutar Build con Gradle') {
            steps {
                script {
                    // Ejecutar Gradle build
                    sh 'gradle build' 
                }
            }
        }

        stage('Construir Imagen Docker') {
            steps {
                script {
                    // Construir la imagen Docker
                    sh 'docker build -t $DOCKER_IMAGE .'
                }
            }
        }

        stage('Ejecutar Tests') {
            steps {
                script {
                    // Aquí puedes ejecutar tus pruebas
                    sh './run_tests.sh'  // Este es un ejemplo, ajusta según lo que tengas en tu repo
                }
            }
        }

        stage('Ejecutar Contenedor Docker') {
            steps {
                script {
                    // Ejecutar el contenedor Docker
                    sh 'docker run -d --name $DOCKER_IMAGE $DOCKER_IMAGE'
                }
            }
        }

        stage('Limpiar Contenedor Docker') {
            steps {
                script {
                    // Detener y eliminar el contenedor para limpiar
                    sh 'docker stop $DOCKER_IMAGE'
                    sh 'docker rm $DOCKER_IMAGE'
                }
            }
        }
    }
}
