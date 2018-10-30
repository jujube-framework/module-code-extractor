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