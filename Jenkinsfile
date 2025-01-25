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

        stage('Construir Imagen Docker') {
            steps {
                script {
                    // Construir la imagen Docker
                    sh 'podman build -t $DOCKER_IMAGE .'
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
                    sh 'podman run -d --name $DOCKER_IMAGE $DOCKER_IMAGE'
                }
            }
        }

        stage('Limpiar Contenedor Docker') {
            steps {
                script {
                    // Detener y eliminar el contenedor para limpiar
                    sh 'podman stop $DOCKER_IMAGE'
                    sh 'podman rm $DOCKER_IMAGE'
                }
            }
        }
    }
}
