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
                    dir("/Users/macbook/project/deploy/${BRANCH_NAME}/product_pos") {
                        echo 'Checkout...'
                        sh "git pull"
                        sh 'echo "Current dir: $(pwd)"'
                    }
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Building...'
                sh "/opt/homebrew/Cellar/maven/3.9.9/bin/mvn clean package"
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
                echo 'Deploy...'
                sh "java -jar target/myapp.jar --spring.profiles.active=prod > target/myapp.log 2>&1"
            }
        }
    }
}