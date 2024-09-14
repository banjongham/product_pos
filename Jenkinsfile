pipeline {
    agent {
        node {
            label 'local'
        }
    }

    stages {
        stage('Checkout') {
            script {
                dir('/Users/macbook/project/deploy/product_pos') {
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
//              sh './build.sh'
            }
        }

        stage('Test') {
            steps {
                // Sample test command
                echo 'Testing...'
//              sh './test.sh'
            }
        }
        stage('Test') {
            steps {
                // Sample test command
                echo 'Testing...'
//              sh './test.sh'
            }
        }
    }
}