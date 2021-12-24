node {
    def mvnHome
    stage('Clone the code') {
        git 'https://github.com/HaneesH1994/mvnproj.git'
        mvnHome = tool 'Maven'
    }
    stage('Build the code') {
        withEnv(["MY_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MY_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package install'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }
    stage('Deploy the code') {
        sh '''
        pwd
        ls -l
        echo "deploying war file"
        sudo cp /var/lib/jenkins/.m2/repository/DEVOPS/MAVEN/2.3/MAVEN-2.3.war /var/lib/tomcat8/webapps/
        cd /var/lib/tomcat8/webapps/
        ls -l
        '''
    }
}
