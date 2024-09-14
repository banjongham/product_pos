pipeline {
    agent {
        node {
            label 'local'
        }
    }

    stages {
        stage('Git Pull') {
            steps {
                script {
//                 dir("/Users/macbook/project/deploy/product_pos") {
                    dir("/Users/macbook/project/deploy/${BRANCH_NAME}/product_pos") {
//                      Checkout code from the Git repository
//                         git branch: 'master', url: 'https://github.com/your-username/your-repository.git'
                        echo 'Checkout...'
                        sh "git pull"
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
                sh "/opt/homebrew/Cellar/maven/3.9.9/mvn clean package"
            }
        }

        stage('Testing') {
            when {
                anyOf {
                    branch 'develop'
                    branch 'staging'
                }
            }
            steps {
            // Sample test command
            echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                // Sample Deploy command
                echo 'Deploy...'
                sh "java -jar target/myapp.jar"
            }
        }
    }
}