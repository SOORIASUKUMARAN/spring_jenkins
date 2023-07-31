pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Bind the Git credentials to the 'GIT_CREDENTIAL_ID' variable
                withCredentials([usernamePassword(credentialsId: 'GIT_CREDENTIAL_ID', usernameVariable: 'sooria661997@gmail.com', passwordVariable: 'Virat@18kohli$')]) {
                    // Clone the Git repository using the provided credentials
                    git credentialsId: 'git_id', url: 'https://github.com/SOORIASUKUMARAN/spring_jenkins.git', branch: 'main'
                }
            }
        }

        stage('Build') {
            steps {
                // Add your build steps here
                // For example:
                sh 'echo "Building the project"'
                sh 'mvn clean install'
            }
        }
    }
}
