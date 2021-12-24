node {
    def mymvn
	stage('CLoning the code') {
	    git'https://github.com/HaneesH1994/mvnproj.git'
		mymvn=tool 'Maven'
	}
	stage('building the code') {
          withEnv(["usrmvn=$mymvn"]) {
		  if (isUnix()) {
		      sh '"$usrmvn/bin/mvn" clean package install'
		 }
		 else {
		    bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
		  }
	  }
	}
}
