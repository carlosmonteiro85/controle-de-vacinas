pipeline {
    agent any

    environment {
        // Define o nome do repositório e a tag usando o número da build do Jenkins
        DOCKER_IMAGE = "85devs/carana"
        DOCKER_TAG = "v${BUILD_NUMBER}"
        CONTAINER_NAME = "carana-container"
        SONARQUBE_SERVER = 'sonarqube-server' // Nome da instalação do SonarQube no Jenkins
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Constrói a imagem Docker
                    echo "Construindo a imagem Docker: ${DOCKER_IMAGE}:${DOCKER_TAG}"
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }

        stage('SonarQube Scan') {
            steps {
                script {
                    // Analisa o código com o SonarQube
                    echo "Executando análise do SonarQube"
                    withSonarQubeEnv(installationName: 'sonarqube') {
                        sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=carana -Dsonar.projectName=Carana'
                    }
                }
            }
        }

        //stage('Publish') {
            //when {
                //expression {
                    // Publica a imagem se o registro for especificado
                    //return env.DOCKER_REGISTRY_URL != null && env.DOCKER_REGISTRY_URL != ''
                //}
            //}
            //steps {
                //script {
                    // Login no registro Docker (se necessário)
                    //if (env.DOCKER_REGISTRY_CREDENTIALS) {
                        //withCredentials([usernamePassword(credentialsId: env.DOCKER_REGISTRY_CREDENTIALS, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                            //sh "docker login -u $USERNAME -p $PASSWORD ${env.DOCKER_REGISTRY_URL}"
                        //}
                    //}

                    // Publica a imagem Docker
                    //echo "Publicando a imagem Docker: ${DOCKER_IMAGE}:${DOCKER_TAG}"
                    //sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                //}
            //}
        //}

        stage('Run') {
            steps {
                script {
                    // Para e remove qualquer contêiner anterior com o mesmo nome
                    echo "Parando e removendo qualquer contêiner existente com o nome: ${CONTAINER_NAME}"
                    sh "docker stop ${CONTAINER_NAME} || true"
                    sh "docker rm ${CONTAINER_NAME} || true"

                    // Executa o novo contêiner
                    echo "Executando o contêiner: ${CONTAINER_NAME}"
                    sh "docker run -d -p 7070:770 --name ${CONTAINER_NAME} ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }
    }

    post {
        always {
            // Limpa as imagens antigas não usadas para liberar espaço
            script {
                echo "Limpando imagens Docker antigas não usadas"
                sh "docker image prune -f"
            }
        }
        success {
            echo "Pipeline concluído com sucesso!"
        }
        failure {
            echo "Pipeline falhou."
        }
    }
}
