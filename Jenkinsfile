pipeline {
    agent {
        node {
            label 'local'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                script {
//                 dir("/Users/macbook/project/deploy/product_pos") {
                    dir("/Users/macbook/project/deploy/${BRANCH_NAME}/product_pos") {
                        sshagençt(['your-ssh-credentials-id']) {
                            sh 'git pull'
                        }
                        // Checkout code from the Git repository
//                         git branch: 'master', url: 'https://github.com/your-username/your-repository.git'
                        echo 'Checkout...'
                        sh 'echo "Current dir: $(pwd)"'

        //              sh './build.sh'
                    }
                }
            }
        }

        stage('Build') {
            steps {
                // Sample build command
                echo 'Building...'
            }
        }

        stage('Test') {
            steps {
                // Sample test command
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                // Sample Deploy command
                echo 'Deploy...'
            }
        }
    }
}