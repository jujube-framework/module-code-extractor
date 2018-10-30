pipeline {
  agent {
    docker {
      image 'maven:3'
      args '-v /home/jenkins/.m2:/root/.m2:rw'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'Building'
        sh 'sudo mkdir -p /root/.m2/repository/org'
        sh 'sudo echo `id` && echo `ls -al /root/.m2/`'
        sh 'sudo mvn clean package'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying'
      }
    }
  }
}
