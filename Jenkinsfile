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
        sh 'mkdir /root/.m2/repository/org'
        sh 'echo `id` && echo `ls -al /root/.m2/`'
        sh 'mvn clean package'
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