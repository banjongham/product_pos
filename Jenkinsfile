pipeline {
    agent {
        node {
            label 'local'
        }
    }

    stages {
        stage('Checkout') {
            script {
                dir("/Users/macbook/project/deploy/${BRANCH_NAME}/product_pos") { //env
//                 dir("/Users/macbook/project/deploy/product_pos") { //env
                    steps {
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