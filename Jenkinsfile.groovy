pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('Build the code') {
            steps {
                echo "cloning the code"
                git 'https://github.com/HaneesH1994/mvnproj.git'
                echo "Building the code"
                sh "mvn -Dmaven.test.failure.ignore=true clean package install"
            }

        }
        stage('deploy the code') {
            steps {
                sh '''
                pwd
                ls -l
                sudo cp /var/lib/jenkins/.m2/repository/DEVOPS/MAVEN/2.3/MAVEN-2.3.war /var/lib/tomcat8/webapps/
                '''
            }
        }
    }
}
