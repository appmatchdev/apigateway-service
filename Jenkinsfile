pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'apigateway-service'
        GRADLE_HOME = '/usr/local/gradle'
        PATH = "$GRADLE_HOME/bin:$PATH"
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git url: 'https://github.com/appmatchdev/apigateway-service.git', branch: 'main'
            }
        }

        stage('Verificar Gradle') {
            steps {
                script {
                    // Verificar si Gradle está accesible
                    sh 'gradle --version'  // Esto te muestra la versión de Gradle instalada
                }
            }
        }

        stage('Ejecutar Build con Gradle') {
            steps {
                script {
                    // Asegurarse de limpiar y luego construir
                    sh 'gradle clean build'  // Limpia antes de construir
                }
            }
        }

        stage('Construir Imagen Docker') {
            steps {
                script {
                    // Verifica si el .jar fue generado, por ejemplo en 'build/libs'
                    sh 'ls build/libs'  // Para confirmar la ubicación del archivo .jar
                    // Construir la imagen Docker
                    sh 'docker build -t $DOCKER_IMAGE .'
                }
            }
        }

        stage('Ejecutar Tests') {
            steps {
                script {
                    // Ejecutar los tests
                    sh './run_tests.sh'  // Asegúrate de que este script exista
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
